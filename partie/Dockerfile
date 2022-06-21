FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/PartieApplication.partie-1.jar
COPY ${JAR_FILE} partie.jar
ENTRYPOINT java -jar /partie.jar $SERVER_IP $IS_DOCKER