FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/anagrammeur-1.jar
COPY ${JAR_FILE} anagrammeur.jar
ENTRYPOINT java -jar /anagrammeur.jar