FROM alpine:3.14

# Instalação de pacotes e configuração inicial
RUN apk update && \
    apk upgrade && \
    apk add --update openjdk11 tzdata curl unzip bash git && \
    rm -rf /var/cache/apk/*

# Criação do usuário e grupo notes
RUN addgroup -S notes && adduser -S notes -G notes

# Configuração do ambiente Maven
ENV MAVEN_VERSION 3.6.3
ENV MAVEN_HOME /usr/lib/mvn
ENV PATH $MAVEN_HOME/bin:$PATH

# Instalação do Maven
RUN wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
    tar -zxvf apache-maven-$MAVEN_VERSION-bin.tar.gz && \
    rm apache-maven-$MAVEN_VERSION-bin.tar.gz && \
    mv apache-maven-$MAVEN_VERSION /usr/lib/mvn

# Criação do diretório e ajuste de permissões para o usuário notes
RUN mkdir -p /opt/note && \
    chown -R notes:notes /opt/note && \
    chmod -R 755 /opt/note

# Definição do usuário e diretório de trabalho
USER notes:notes
WORKDIR /opt/note

# Clone do repositório e construção do projeto Maven
RUN git clone https://github.com/callicoder/spring-boot-mysql-rest-api-tutorial.git /opt/note && \
    mvn package -Dmaven.test.skip=true

# Configuração do arquivo JAR e entrada principal
ARG JAR_FILE=target/easy-notes-1.0.0.jar
COPY application.properties /opt/note/application.properties

ENTRYPOINT ["java", "-jar", "/opt/note/easy-notes-1.0.0.jar"]
