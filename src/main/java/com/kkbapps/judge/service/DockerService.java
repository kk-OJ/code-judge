package com.kkbapps.judge.service;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.PullImageCmd;
import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.core.DockerClientBuilder;
import com.kkbapps.judge.constant.Constants;
import com.kkbapps.judge.pojo.Result;
import com.kkbapps.judge.pojo.dto.JudgeConstraint;
import org.springframework.stereotype.Service;

@Service
public class DockerService {

    public Result exeCode(JudgeConstraint judgeConstraint, Integer index) {
        // 创建 DockerClient 用于后续操作
        DockerClient dockerClient = DockerClientBuilder.getInstance().build();
        // 拉取镜像
        pullImages(dockerClient, index);
        return Result.error(100,"ll");
    }

    /**
     * 拉取镜像
     */
    private void pullImages(DockerClient dockerClient, Integer index) {
        if(!Constants.INIT[index]) {
            String image = Constants.IMAGES[index];
            PullImageCmd pullImageCmd = dockerClient.pullImageCmd(image);
            PullImageResultCallback pullImageResultCallback = new PullImageResultCallback();
            try {
                pullImageCmd
                        .exec(pullImageResultCallback)
                        .awaitCompletion();
            } catch (InterruptedException e) {
                System.out.println("拉取镜像异常");
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 创建容器
     */
    private void CreateContainer() {

    }



}
