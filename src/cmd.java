public class cmd {

    public static void help(){
        System.out.println("Это справка, которая вызывается, если число аргументов не равно двум или 4 или равно нулю");
    }

    public static void checkArgs(String[] args){
        String[] checkedArgs = new String[4];
        if (args.length == 2){
            checkedArgs[0] = args[0];
            checkedArgs[1] = args[1];
        }
        else if (args.length == 4){
            checkedArgs[2] = args[2];
            if(args[3] != null) {
                switch (args[3]) {
                    case "WRITE": break;
                    case "READ": break;
                    case "EXECUTE": break;
                    default: System.exit(3);
                }
                checkedArgs[3] = args[3];
            }
            else System.exit(3);
        }
        else{
            help();
        }
    }
}
