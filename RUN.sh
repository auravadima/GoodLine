if [[ "$OSTYPE" == "win32" ]]; then
        java -classpath bin;libs/commons-cli-1.4.jar;libs/h2-1.4.196.jar main.Main $1 2>> log.aaa
else
        java -classpath bin:libs/commons-cli-1.4.jar:libs/h2-1.4.196.jar main.Main $1 2>> log.aaa
fi