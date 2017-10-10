import org.apache.commons.cli.ParseException;

import java.util.ArrayList;

public class main {
    public static int status = 0;
    public static ArrayList<user> users = new ArrayList<>();

    public static void main(String[] args) throws ParseException, java.text.ParseException {
        cmd c = new cmd();
        users.add(new user("auravadima","rAAzhyGF","A.B","WRITE","","",""));
        users.add(new user("vasya","qwerty","A.K.Y","READ","","",""));
            String[] checkedArgs = c.Parse(args);
            user Me = new user(checkedArgs);
            user Reg = auth.isUser(Me);
                    if(status == 0) auth.rightPass(Me,Reg);
                    if(status == 0 && !checkedArgs[3].equals("")) auth.checkRole(checkedArgs);
                    if(status == 0 && !checkedArgs[3].equals("")) auth.access(Me, Reg);
                    if(status == 0 && !checkedArgs[6].equals("")) auth.checkDateVol(checkedArgs);
                    System.out.println(status);
            System.exit(status);
    }
}
