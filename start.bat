@echo off
START /B "" cassandra > logs\cassandra-log.txt
timeout 10 >nul && START /B "" mvn clean > logs\mvn-clean-log.txt && START /B "" mvn install > logs\mvn-install-log.txt && START /B "" mvn package > logs\mvn-package-log.txt && cd target && java -jar release-0.0.1.jar