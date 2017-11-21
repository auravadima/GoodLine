if [[ "$OSTYPE" == "win32" ]]; then
        java -Dlog4j.configurationFile=log4j.properties -classpath bin;libs/*;src main.Main $1
else
        java -Dlog4j.configurationFile=log4j.properties -classpath bin:libs/*:src main.Main $1
fi