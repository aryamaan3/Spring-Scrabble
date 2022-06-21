FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/joueurApplication.joueur-1.jar
COPY ${JAR_FILE} joueur.jar
ENTRYPOINT java -jar /joueur.jar $SERVER_IP $IS_DOCKER