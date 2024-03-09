#!/bin/bash
# 安装 c、c++ 环境镜像
docker pull gcc && \
# 安装 python 环境镜像
docker pull python:alpine && \
# 安装 javascript 环境镜像
docker pull node:alpine && \
# 安装 golang 环境镜像
docker pull golang:alpine && \
# 安装 java 环境镜像
docker pull openjdk:8-alpine