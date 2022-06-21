FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/anagrammeur-1.jar
COPY ${JAR_FILE} anagrammeur.jar
RUN mkdir anagrammeur
COPY liste_francais.txt anagrammeur/liste_francais.txt
ENTRYPOINT java -jar /anagrammeur.jar $SERVER_IP $IS_DOCKER