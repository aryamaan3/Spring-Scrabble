# scrabble-td2-darpa_g

lancement local sans docker

```
mvn clean install -Dskiptest
mvn test
mvn exec:java -pl appariement
mvn exec:java -pl anagrammeur -Dserver.port=8081 -Dexec.args="http://localhost:8080/ false"
mvn exec:java -pl partie -Dserver.port=8082 -Dexec.args="http://localhost:8080/ false"
mvn exec:java -pl joueur -Dserver.port=8083 -Dexec.args="http://localhost:8080/ false"
mvn exec:java -pl joueur -Dserver.port=8084 -Dexec.args="http://localhost:8080/ false"
mvn exec:java -pl joueur -Dserver.port=8085 -Dexec.args="http://localhost:8080/ false"
mvn exec:java -pl joueur -Dserver.port=8086 -Dexec.args="http://localhost:8080/ false"
cd partie
mvn failsafe:integration-test -Dit.test=partieController.TestPartieControllerIT#initPartieTest
```

