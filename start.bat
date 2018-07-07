// START /B "" cassandra > logs\cassandra-log.txt
// timeout 10 >nul
START /B "" mvn clean > logs\mvn-clean-log.txt
timeout 5 >nul
START /B "" mvn install > logs\mvn-install-log.txt
timeout 8 >nul
START /B "" mvn package > logs\mvn-package-log.txt
timeout 5 >nul
cd target
java -jar release-0.0.1.jar