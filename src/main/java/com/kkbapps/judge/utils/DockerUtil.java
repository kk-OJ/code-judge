package com.kkbapps.judge.utils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.*;
import com.github.dockerjava.api.model.*;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.ExecStartResultCallback;
import com.kkbapps.judge.constant.Constants;
import com.kkbapps.judge.constant.enums.ExecuteTypeEnum;
import com.kkbapps.judge.constant.enums.JudgeTypeEnum;
import com.kkbapps.judge.exception.BusinessException;
import com.kkbapps.judge.pojo.Result;
import com.kkbapps.judge.pojo.dto.JudgeConstraint;
import com.kkbapps.judge.pojo.vo.ExecuteInfo;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class DockerUtil {

    public static Result executeCodeWithDocker(JudgeConstraint judgeConstraint, Integer index, String folderPath, String fileName) {
        // 创建 DockerClient 用于后续操作
        DockerClient dockerClient = DockerClientBuilder.getInstance().build();
        String containerId = null;
        try {
            // 拉取镜像
            pullImages(dockerClient, index);
            // 创建并启动容器
            containerId = createAndStartContainer(dockerClient, index, judgeConstraint.getMemoryLimit(), folderPath);
            // 编译代码
            compile(dockerClient, index, containerId, fileName);
            System.out.println("编译代码结束");
            // 执行代码
            // 仅执行代码
            if(JudgeTypeEnum.EXECUTE_CODE_ONLY.getState().equals(judgeConstraint.getType())) {
                executeCodeOnly(dockerClient, index, containerId, judgeConstraint, folderPath);
            }
            // 普通判题
            else if(JudgeTypeEnum.NORMAL_JUDGE.getState().equals(judgeConstraint.getType())) {
                normalJudge();
            }
        } finally {
            // 释放资源（容器）
            deleteContainer(dockerClient,containerId);
        }
        return Result.error(100,"ll");
    }

    /**
     * 拉取镜像
     */
    private static void pullImages(DockerClient dockerClient, Integer index) {
        if(!Constants.INIT[index]) {
            String image = Constants.IMAGES[index];
            PullImageCmd pullImageCmd = dockerClient.pullImageCmd(image);
            try {
                pullImageCmd
                        .exec(new PullImageResultCallback())        // 执行回调
                        .awaitCompletion();                         // 阻塞等待执行结束
            } catch (InterruptedException e) {
                System.out.println("拉取" + image + "镜像异常");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 创建并启动容器
     */
    private static String createAndStartContainer(DockerClient dockerClient, Integer index, Long memoryLimit, String folderPath) {
        // 配置设置
        HostConfig hostConfig = new HostConfig();
        hostConfig.withMemory(memoryLimit);                                                                         // 限制内存
        hostConfig.withMemorySwap(0L);
        hostConfig.withCpuCount(1L);
        hostConfig.setBinds(new Bind(folderPath, new Volume(Constants.containerVolumePath)));                         // 挂载数据卷
        // 创建容器
        CreateContainerCmd containerCmd = dockerClient.createContainerCmd(Constants.IMAGES[index]);
        CreateContainerResponse createContainerResponse = containerCmd
                .withHostConfig(hostConfig)
                .withNetworkDisabled(true)
                .withReadonlyRootfs(true)
                .withAttachStdin(true)
                .withAttachStderr(true)
                .withAttachStdout(true)
                .withTty(true)
                .exec();
        String containerId = createContainerResponse.getId();
        // 启动容器
        dockerClient.startContainerCmd(containerId).exec();
        return containerId;
    }

    /**
     * 创建执行命令
     */

    /**
     * 获取输入输出
     */


    /**
     * 删除容器
     */
    private static void deleteContainer(DockerClient dockerClient, String containerId) {
        dockerClient.removeContainerCmd(containerId).withForce(true).exec();
    }

    /**
     * 编译代码
     */
    private static void compile(DockerClient dockerClient, Integer index, String containerId, String fileName) {
        // 获取编译命令
        if(Constants.langCompileCmd[index] == null) return;         // 不需要编译
        String[] cmdArray = String.format(Constants.langCompileCmd[index], Constants.containerVolumePath + File.separator + fileName).split(" ");
        // 创建执行命令
        ExecCreateCmdResponse execCreateCmdResponse = dockerClient.execCreateCmd(containerId)
                .withCmd(cmdArray)
                .withAttachStderr(true)
                .withAttachStdin(true)
                .withAttachStdout(true)
                .exec();
        // 获取输出（编译错误）
        ExecStartResultCallback execStartResultCallback = new ExecStartResultCallback() {
            @Override
            public void onNext(Frame frame) {
                StreamType streamType = frame.getStreamType();
                if (StreamType.STDERR.equals(streamType)) {
                    ExecuteInfo executeInfo = new ExecuteInfo();
                    executeInfo.setExecuteType(ExecuteTypeEnum.COMPILE_ERROR.getDesc());
                    executeInfo.setExecuteResult(new String(frame.getPayload()));
                    throw new BusinessException(Result.success(200,"编译失败",executeInfo));
                }
                super.onNext(frame);
            }
        };
        try {
            // 执行命令
            dockerClient.execStartCmd(execCreateCmdResponse.getId())
                    .exec(execStartResultCallback)
                    .awaitCompletion();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 仅执行代码
     */
    private static void executeCodeOnly(DockerClient dockerClient, Integer index, String containerId, JudgeConstraint judgeConstraint, String folderPath) {
        // 获取执行次数
        int num = judgeConstraint.getInputs().length;
        for(int i=0;i<num;i++) {
            // 执行命令
            ExecCreateCmdResponse execCreateCmdResponse = dockerClient.execCreateCmd(containerId)
                    .withCmd(Constants.langRunCmd[index])
                    .withAttachStderr(true)
                    .withAttachStdin(true)
                    .withAttachStdout(true)
                    .withTty(true)
                    .exec();
            // 获取输出
            ExecStartResultCallback execStartResultCallback = new ExecStartResultCallback() {
                @Override
                public void onNext(Frame frame) {
                    System.out.println("运行结果：" + new String(frame.getPayload()));
                    super.onNext(frame);
                }

            };
            File in = new File(folderPath + File.separator + i + ".in");
            try {
                // 执行命令
                dockerClient.execStartCmd(execCreateCmdResponse.getId())
                        .exec(execStartResultCallback)
                        .awaitCompletion();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 普通判题
     */
    private static void normalJudge() {
        System.out.println("普通判题");
    }

}
