import java.text.SimpleDateFormat;

public class auth {



    public static user isUser(user us){

        for(int i = 0; i < main.users.size(); i++){
            if(us.login.equals(main.users.get(i).login)) {
                return main.users.get(i);
            }

        }
        main.status = 1;
        return us;

    }



    public static boolean rightPass(user us, user RegUs){

        if (!RegUs.pass.equals(us.pass)){
            main.status = 2;
            return false;
        }
        return true;

    }


    public static void checkRole(String[] args){
        if (args.length > 3) {
            args[2] = args[2];
            if (args[3] != null) {
                switch (args[3]) {
                    case "WRITE":
                        break;
                    case "READ":
                        break;
                    case "EXECUTE":
                        break;
                    default:
                        main.status = 3;
                        return;
                }
            }
        }
        else{
            cmd.help();
        }
    }


    public static void checkDateVol(String[] args){
        if(args.length == 7){
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");

            try {

                format.parse(args[4]);
                format.parse(args[5]);

            } catch (java.text.ParseException e) {

                main.status = 5;
                return;
            }
            try {
                Integer.parseInt(args[6]);
            } catch (NumberFormatException e) {

                main.status = 5;
                return;
            }
        }
    }



    public static void access(user us, user RegUs) {

        if (!us.role.equals(RegUs.role)){
            main.status = 4;
            return;
        }

        String[] userRes = us.res.split("\\.");
        String[] accessRes = RegUs.res.split("\\.");
        if(userRes.length < accessRes.length) {
            main.status = 4;
            return;
        }

        if(us.res != null) {

            for(int i = 0; i < accessRes.length; i++) {
                if (accessRes[i].equals(userRes[i])) {
                    continue;
                }
                else {
                    main.status = 4; return;
                }
            }

        }

    }

}
