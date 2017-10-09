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
        if (RegUs.pass.equals(us.pass)){

        }
        System.exit(2);
    }

}
