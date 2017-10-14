import org.apache.commons.cli.ParseException;

import java.security.NoSuchAlgorithmException;

public class main {


    public static void main(String[] args) throws ParseException, java.text.ParseException, NoSuchAlgorithmException {

        cmd c = new cmd();

        dataSet userSet = c.Parse(args);
        if (c.isHelp()) {
            cmd.help();
            System.exit(0);
        }

        Init init = new Init();
        init.createExampleUsers();

        user Me = new user(userSet);
        user Reg = auth.isUser(Me, init.users);

        if (userSet.isAuthentication() && auth.status == 0) {
            auth.rightPass(Me, Reg);
        }
        if (userSet.isAuthorization() && auth.status == 0) {
            auth.access(Me, Reg);
        }
        if (userSet.isAccounting() && auth.status == 0) {
            auth.checkDateVol(Me);
        }
        System.exit(auth.status);
    }
}
