import org.apache.commons.cli.ParseException;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class main {
    public static int status = 0;
    public static ArrayList<user> users = new ArrayList<>();

    public static void main(String[] args) throws ParseException, java.text.ParseException, NoSuchAlgorithmException {
        cmd c = new cmd();

        users.add(new user("auravadima","3d8ef7a9d2279c00d95aa4210785781a","A.B","WRITE","",""));
        users.add(new user("vasya","cdbeea1cc64c6a78bd97d17876c10d96","A.K.Y","READ","",""));
        users.add(new user("jdoe","7d7b66a3db177e3104ac42ac6c11d356","a","READ","","",""));
        users.add(new user("jrow","2d09fb4129e6480d97df3fee634b9220","a.bc","EXECUTE","",""));

        users.get(0).setSalt("%#(e^#cew^#*we(%#((%c#&#^&");
        users.get(1).setSalt("*c(awh#^he%(&%*%e^h&ch&he#e%");
        users.get(2).setSalt("*c^a&*e#a%&(a%#h^ha#a(^e");
        users.get(3).setSalt("hh&h#c%c(%ea#e&(w^*&eeh&^");

        users.get(2).setAccess("a.b", "WRITE");
        users.get(3).setAccess("a.bc", "EXECUTE");

            String[] checkedArgs = c.Parse(args);
            user Me = new user(checkedArgs);
            user Reg = auth.isUser(Me);
                    if(status == 0) Me.setSalt(Reg.salt);
                    if(status == 0) auth.rightPass(Me,Reg);
                    if(status == 0 && !Me.acc.isEmpty()) auth.checkRole(Me);
                    if(status == 0 && !Me.acc.isEmpty()) auth.access(Me, Reg);
                    if(status == 0 && !checkedArgs[6].equals("")) auth.checkDateVol(Me);
            System.exit(status);
    }
}
