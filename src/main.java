import org.apache.commons.cli.ParseException;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class main {
    public static int status = 0;
    public static ArrayList<user> users = new ArrayList<>();

    public static void main(String[] args) throws ParseException, java.text.ParseException, NoSuchAlgorithmException {
        cmd c = new cmd();

        users.add(new user("auravadima","3d8ef7a9d2279c00d95aa4210785781a","A.B","WRITE","","",""));
        users.add(new user("vasya","cdbeea1cc64c6a78bd97d17876c10d96","A.K.Y","READ","","",""));
        users.get(0).setSalt("%#(e^#cew^#*we(%#((%c#&#^&");
        users.get(1).setSalt("*c(awh#^he%(&%*%e^h&ch&he#e%");

            String[] checkedArgs = c.Parse(args);
            user Me = new user(checkedArgs);
            user Reg = auth.isUser(Me);
                    if(status == 0) Me.setSalt(Reg.salt);
                    if(status == 0) auth.rightPass(Me,Reg);
                    if(status == 0 && !checkedArgs[3].equals("")) auth.checkRole(checkedArgs);
                    if(status == 0 && !checkedArgs[3].equals("")) auth.access(Me, Reg);
                    if(status == 0 && !checkedArgs[6].equals("")) auth.checkDateVol(checkedArgs);
            System.exit(status);
    }
}
