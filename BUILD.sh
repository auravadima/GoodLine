if [[ "$OSTYPE" == "win32" ]]; then
        javac -d jarfiles -cp libs/commons-cli-1.4.jar;libs/flyway-core-4.2.0.jar;libs/log4j-api-2.9.1.jar;libs/log4j-core-2.9.1c.jar src/services/* src/main/*.java src/domain/*.java
else
        javac -d jarfiles -cp libs/commons-cli-1.4.jar:libs/flyway-core-4.2.0.jar:libs/log4j-api-2.9.1.jar:libs/log4j-core-2.9.1c.jar src/services/* src/main/*.java src/domain/*.java
fi
mkdir jarfiles
cd jarfiles
mkdir resources
cp ../src/resources/* resources
jar xf ../libs/commons-cli-1.4.jar 
jar xf ../libs/h2-1.4.196.jar 
jar xf ../libs/log4j-core-2.9.1.jar 
jar xf ../libs/flyway-core-4.2.0.jar 
jar xf ../libs/log4j-api-2.9.1.jar 
jar cfm run.jar ../META-INF/MANIFEST.MF main domain services ../db META-INF org resources
mv run.jar ../run.jar

