FROM maven:3.6.0-jdk-11-slim
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app/
RUN mvn clean verify

FROM openjdk:11-jre-slim
COPY /target/*.jar /app/target/
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -jar /app/target/*.jar" ]