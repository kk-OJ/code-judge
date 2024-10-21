# code-judge

> code-judge，支持代码运行与在线评测的OJ判题机
>
> Code judge, an online judge machine that supports code execution and online evaluation.
>
> 作者：[zyyzyykk](https://github.com/zyyzyykk/)
>
> 源代码：https://github.com/kk-OJ/code-judge
>
> 预览：http://code.kkbpro.com/
>
> 更新时间：2024-04-06

### 🛸 预览

访问以下网址：http://code.kkbpro.com/

![code-judge](http://img.kkbapps.com/judge/code-judge-1.3.png)

### 💪 部署

##### 前端：

1.前端的打包文件位于 `front` 文件夹下，可直接部署

2.前端仅是一个可以在线运行代码的页面，不是OJ

3.前端页面的源代码在 [code-executor](https://github.com/kk-OJ/code-executor) 仓库

##### 后端：

1.部署前请确保服务器已安装 `JDK1.8` 和 `Docker` 环境

2.后端的相关文件位于 `backend` 文件夹下

3.运行 `install.sh`，拉取支持的语言环境镜像

4.启动 `judge.jar`，完成后端部署

### 💡 功能说明

1.code-judge是一个支持代码运行与在线评测的OJ判题机，可用于获取代码的执行结果、OJ判题（未实现）

2.调用code-judge的API需要签名密钥。签名密钥一小时内有效，同一IP获取签名密钥10分钟后才可重新获取

3.调用code-judge的API有频率限制，同一IP调用的时间间隔不能小于5秒

[接口文档](./API.md)

### 👨‍💻 更新记录

##### 2024-04-06：

- 代码执行逻辑优化

##### 2024-03-08：

- 代码执行功能基本完成

### 🏘️ 关于此项目

作者：[zyyzyykk](https://github.com/zyyzyykk/)

欢迎对此项目提出宝贵的意见或建议，也可以加入我们一起进行此项目的维护与开发
