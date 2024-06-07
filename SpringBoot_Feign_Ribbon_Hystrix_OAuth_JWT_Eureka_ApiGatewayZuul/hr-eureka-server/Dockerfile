FROM openjdk:11
LABEL authors="Renan Sereia"
VOLUME /tmp
EXPOSE 8761
ADD ./target/hr-eureka-server-0.0.1-SNAPSHOT.jar hr-eureka-server.jar

ENTRYPOINT ["java","-jar" ,"hr-eureka-server.jar"]