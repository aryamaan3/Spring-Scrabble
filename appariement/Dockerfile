FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/appariement-1.jar
COPY ${JAR_FILE} appariement.jar
ENTRYPOINT java -jar /appariement.jar