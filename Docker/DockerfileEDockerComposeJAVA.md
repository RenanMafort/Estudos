[![Docker Hub Repo](https://img.shields.io/docker/pulls/DOCKER_HUB_USERNAME/RESPOSITORY_NAME.svg)](https://hub.docker.com/repository/docker/renansereia/renan-sereia-springboot/general)
# Gerar o .jar através do **MAVEN**
### Gerando o .jar pulando os testes
``` yaml
mvn clean package -DskipTests

```

# Exemplo de  **Dockerfile**
``` yaml
FROM openjdk:18-jdk-slim  
ARG JAR_FILE=/target/*.jar  
COPY ${JAR_FILE} renansereia.jar  
ENTRYPOINT ["java","-jar","/renansereia.jar"]  
``` 

# Exemplo de **docker-compose.yml**  
``` yaml
version: '3.9'
services:
  db:
    image: mysql:8.0.29
    command: mysqld --default-authentication-plugin=mysql_native_password
    restart: always
    environment:
      TZ: America/Sao_Paulo
      MYSQL_ROOT_PASSWORD: admin123
      MYSQL_USER: docker
      MYSQL_PASSWORD: admin123
      MYSQL_DATABASE: rest_with_springboot
      MYSQL_ROOT_HOST: '%'
      MYSQL_TCP_PORT: 3308
    ports:
      - "3308:3308"
    expose:
      - 3308
    networks:
      - sereia-network
  rest-with-spring-boot-erudio:
    image: renansereia/renan-sereia-springboot
    restart: always
    build: .
    working_dir: /Spring-Boot-framework-Swagger-JWT-JUnit-5-Mockito-Docker
    environment:
      TZ: America/Sao_Paulo
      SPRING.DATASOURCE.URL: jdbc:mysql://db:3308/rest_with_springboot?useTimezone=true&serverTimezone=UTC
      SPRING.DATASOURCE.USERNAME: root
      SPRING.DATASOURCE.PASSWORD: admin123
    ports:
      - 80:80
    command: mvn spring-boot:run
    depends_on:
      - db
    networks:
      - sereia-network
networks:
  sereia-network:
    driver: bridge
```
### Gerando as imagens no docker
```yaml
  docker compose up -d --build
```
