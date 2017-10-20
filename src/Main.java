import org.apache.commons.cli.ParseException;

import java.security.NoSuchAlgorithmException;

public class Main {


    public static void main(String[] args) throws ParseException, java.text.ParseException, NoSuchAlgorithmException {

        Cmd c = new Cmd();

        DataSet userSet = c.Parse(args);
        if (c.isHelp()) {
            Cmd.help();
            System.exit(0);
        }

        Init init = new Init();
        init.createExampleUsers();

        User Me = new User(userSet);
        User Reg = Auth.isUser(Me, init.users);

        if (userSet.isAuthentication() && Auth.status == 0) {
            Auth.rightPass(Me, Reg);
        }
        if (userSet.isAuthorization() && Auth.status == 0) {
            Auth.access(Me, Reg);
        }
        if (userSet.isAccounting() && Auth.status == 0) {
            Auth.checkDateVol(Me);
        }
        System.exit(Auth.status);
    }
}
