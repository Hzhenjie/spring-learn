FROM java:8
MAINTAINER zhenjie
LABEL description="this is a project which is about rabbitMQ !"
COPY ./rabbitMQ-1.0-SNAPSHOT.jar /opt/
WORKDIR /opt/
EXPOSE 10086
RUN echo "this is a project which is about rabbitMQ !"
#匿名挂载，在宿主机/var/lib/docker/volumes/生成，此容器可以在指定容器生成
VOLUME /opt/rabbitMQ_volume
ENTRYPOINT java -jar /opt/rabbitMQ-1.0-SNAPSHOT.jar