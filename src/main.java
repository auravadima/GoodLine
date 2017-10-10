import org.apache.commons.cli.ParseException;

import java.util.ArrayList;

public class main {

    public static ArrayList<user> users = new ArrayList<>();

    public static void main(String[] args) throws ParseException {

        cmd c = new cmd();
        users.add(new user("auravadima","rAAzhyGF","A.B.C","WRITE"));
        users.add(new user("vasya","qwerty","A.G.Y","READ"));
            String[] checkedArgs = c.Parse(args);
            user Me = new user(checkedArgs);
            user Reg = auth.isUser(Me);
                auth.rightPass(Me, Reg);
                cmd.checkArgs(args);
                auth.access(Me, Reg);
        System.exit(0);
    }
}
