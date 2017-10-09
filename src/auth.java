public class auth {

    public static void isUser(user us){

        for(int i = 0; i < main.users.size(); i++){
            if(us.login.equals(main.users.get(i).login)) {
                return;
            }

        }
        System.exit(1);
    }

}
