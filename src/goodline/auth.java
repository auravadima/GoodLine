public class auth {

    public static user isUser(user us){

        for(int i = 0; i < main.users.size(); i++){

            if(us.login.equals(main.users.get(i).login)) {
                return main.users.get(i);
            }

        }

        System.exit(1);
        return us;

    }



    public static void rightPass(user us, user RegUs){

        if (!RegUs.pass.equals(us.pass)){
            System.exit(2);
        }

    }



    public static void access(user us, user RegUs) {

        if (!us.role.equals(RegUs)){
            System.exit(4);
        }

        if (us.res == null) {
            return;
        }

        String[] userRes = us.res.split("\\.");
        String[] accessRes = RegUs.res.split("\\.");
        if(userRes.length < accessRes.length) {
            System.exit(4);
        }

        if(us.res != null) {

            for(int i = 0; i < accessRes.length; i++) {
                if (accessRes[i].equals(userRes[i])) {
                    continue;
                }
                else {
                    System.exit(4);
                }
            }

        }



    }

}
