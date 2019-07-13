FROM openjdk:11-jre-slim
RUN mkdir /code
COPY target/*.jar /code
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -jar /code/*.jar" ]