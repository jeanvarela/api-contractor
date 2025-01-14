# Dockerfile da API

# Estágio de compilação e construção
FROM openjdk:17-jdk AS build

# Atualizar lista de pacotes e instalar netcat
WORKDIR /app

COPY target/api_cotractor.jar /app/api.jar

COPY wait-for.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

EXPOSE 8080

CMD ["java", "-jar", "api.jar"]