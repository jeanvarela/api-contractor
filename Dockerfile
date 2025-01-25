# Estágio de construção com Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo pom.xml e o diretório src para o contêiner
COPY pom.xml /app/
COPY src /app/src/

# Rodar o Maven para gerar o arquivo .jar
RUN mvn clean package -DskipTests

# Estágio de execução da aplicação
FROM eclipse-temurin:17-jdk

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo .jar gerado no estágio anterior
COPY --from=build /app/target/api-contractor.jar /app/api.jar

# Copiar o script wait-for-it.sh
COPY wait-for.sh /wait-for-it.sh

# Dar permissão de execução ao script
RUN chmod +x /wait-for-it.sh

# Expor a porta
EXPOSE 8080

# Comando para rodar a aplicação após garantir que o banco de dados está pronto
CMD ["/wait-for-it.sh", "db:5432", "--", "java", "-jar", "api.jar"]
