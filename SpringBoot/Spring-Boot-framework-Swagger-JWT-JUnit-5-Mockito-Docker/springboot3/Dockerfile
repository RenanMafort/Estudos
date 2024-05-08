FROM openjdk:18-jdk-slim
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} renansereia.jar
ENTRYPOINT ["java","-jar","/renansereia.jar"]