FROM openjdk:11
LABEL authors="Renan Sereia"
VOLUME /tmp
EXPOSE 8888
ADD ./target/hr-config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar

ENTRYPOINT ["java","-jar" ,"hr-config-server.jar"]