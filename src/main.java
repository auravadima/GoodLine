import java.util.ArrayList;

public class main {

    public static int status = 0;
    public static ArrayList<user> users = new ArrayList<>();

    public static void main(String[] args) {

        users.add(new user("auravadima","rAAzhyGF","A.B.C","WRITE"));
        users.add(new user("vasya","qwerty","A.G.Y","READ"));
        if(cmd.minCheck(args)) {
            user Me = new user(args);
            user Reg = auth.isUser(Me);
            if (status == 0) {
                auth.rightPass(Me, Reg);
                cmd.checkArgs(args);
            }
            if (status == 0 && args.length > 2) {
                auth.access(Me, Reg);
            }
        }
        System.exit(status);
    }
}
