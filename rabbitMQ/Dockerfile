FROM java:8
MAINTAINER zhenjie
LABEL description="this is a project which is about rabbitMQ !"

#ARG构建参数，ARG 设置的环境变量仅对 Dockerfile 内有效，也就是说只有 docker build 的过程中有效，构建好的镜像内不存在此环境变量。
#ARG GROUP

#ENV环境变量，声明后，可以再后面使用
#ENV VERSION 1.0

#复制宿主机的文件到容器，推荐使用
COPY ./rabbitMQ-1.0-SNAPSHOT.jar /opt/
#工作目录，进入容器的默认目录
WORKDIR /opt/
#仅仅只是声明端口。
EXPOSE 10086

#RUN 是在 docker build时运行，而CMD有些不同在docker run 时运行，注意：如果 Dockerfile 中如果存在多个 CMD 指令，仅最后一个生效。
RUN echo "this is a project which is about rabbitMQ !"

#匿名挂载，在宿主机/var/lib/docker/volumes/生成，此容器可以在下面指定容器的目录生成
#定义匿名数据卷。在启动容器时忘记挂载数据卷，会自动挂载到匿名卷。
#在启动容器 docker run 的时候，我们可以通过 -v 参数修改挂载点。
#VOLUME ["<路径1>", "<路径2>"...]
VOLUME /opt/rabbitMQ_volume
#类似于 CMD 指令，不会被 docker run 的命令行参数指定的指令所覆盖
#但是, 如果运行 docker run 时使用了 --entrypoint 选项，将覆盖 ENTRYPOINT 指令指定的程序。
#优点：在执行 docker run 的时候可以指定 ENTRYPOINT 运行所需的参数。
#注意：如果 Dockerfile 中如果存在多个 ENTRYPOINT 指令，仅最后一个生效。
ENTRYPOINT java -jar /opt/rabbitMQ-1.0-SNAPSHOT.jar

#FROM- 镜像从那里来
#MAINTAINER- 镜像维护者信息
#RUN- 构建镜像执行的命令，每一次RUN都会构建一层
#CMD- 容器启动的命令，如果有多个则以最后一个为准，也可以为ENTRYPOINT提供参数
#VOLUME- 定义数据卷，如果没有定义则使用默认
#USER- 指定后续执行的用户组和用户
#WORKDIR- 切换当前执行的工作目录
#HEALTHCHECH- 健康检测指令
#ARG- 变量属性值，但不在容器内部起作用
#EXPOSE- 暴露端口
#ENV- 变量属性值，容器内部也会起作用
#ADD- 添加文件，如果是压缩文件也解压
#COPY- 添加文件，以复制的形式
#ENTRYPOINT- 容器进入时执行的命令