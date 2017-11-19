if [[ "$OSTYPE" == "win32" ]]; then
        java -classpath bin;libs/*;. main.Main $1 2>> log.aaa
else
        java -classpath bin:libs/*:. main.Main $1 2>> log.aaa
fi