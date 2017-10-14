import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
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



    public static boolean rightPass(user us, user RegUs) throws NoSuchAlgorithmException {
        us.pass = passwords.Hash(passwords.Hash(us.pass) + us.salt);
        if (!RegUs.pass.equals(us.pass)){
            main.status = 2;
            return false;
        }
        return true;

    }


    public static void checkRole(user us){
        if (us.acc.get(0).role != null) {
            switch (us.acc.get(0).role) {
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
        else{
            cmd.help();
        }
    }


    public static void checkDateVol(user us){
        if(!us.ds.isEmpty()){
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            try {

                format.parse(us.ds);
                format.parse(us.de);

            } catch (ParseException e) {

                main.status = 5;
                return;
            }
        }
    }


//////////////////////////////
    public static void access(user us, user RegUs) {
        boolean access = false;
        String[] userRes = us.acc.get(0).res.split("\\.");

            for( int i = 0; i < RegUs.acc.size(); i++){
                if(us.acc.get(0).role.equals(RegUs.acc.get(i).role) && !access){
                      String[] accessRes = RegUs.acc.get(i).res.split("\\.");
                    if(userRes.length < accessRes.length) {
                        main.status = 4;
                        return;
                    }

                    if(!us.acc.isEmpty()) {

                        for(int k = 0; k < accessRes.length; k++) {
                            if (!accessRes[k].equals(userRes[k])) {

                            }
                            access = true;
                        }

                    }
                }
            }
            if(!access){
                main.status = 4;
                return;
            }
   }

}
