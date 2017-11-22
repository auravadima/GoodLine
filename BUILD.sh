if [[ "$OSTYPE" == "win32" ]]; then
        javac -d bin -cp libs/commons-cli-1.4.jar;libs/flyway-core-4.2.0.jar;libs/log4j-api-2.9.1.jar;libs/log4j-core-2.9.1c.jar src/main/*.java src/domain/*.java
else
        javac -d bin -cp libs/commons-cli-1.4.jar:libs/flyway-core-4.2.0.jar:libs/log4j-api-2.9.1.jar:libs/log4j-core-2.9.1c.jar src/main/*.java src/domain/*.java
fi