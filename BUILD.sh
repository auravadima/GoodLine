if [[ "$OSTYPE" == "win32" ]]; then
        javac -d bin -cp libs/commons-cli-1.4.jar;libs/flyway-core-4.2.0.jar src/main/*.java src/domain/*.java
else
        javac -d bin -cp libs/commons-cli-1.4.jar:libs/flyway-core-4.2.0.jar src/main/*.java src/domain/*.java
fi