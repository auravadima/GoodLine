package main;

import domain.User;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class AuthService {

    static int status = 0;

    static User isUser(User us, ArrayList<User> users) {
        for (User user : users) {
            if (us.login.equals(user.login)) {
                return user;
            }
        }
        status = 1;
        return us;
    }


    static void rightPass(User us, User regUs) throws NoSuchAlgorithmException {
        if (!regUs.pass.equals(Passwords.getHash(us.pass, regUs.salt))) {
            status = 2;
        }

    }


    static void checkDateVol(User us) {
        if (us.inf != null) {
            SimpleDateFormat format = new SimpleDateFormat();
            format.setLenient(false);
            format.applyPattern("yyyy-MM-dd");
            try {
                format.parse(us.inf.get(us.inf.size() - 1).ds);
                format.parse(us.inf.get(us.inf.size() - 1).de);
            } catch (ParseException e) {
                status = 5;
                return;
            }
            try {
                Integer.parseInt(us.inf.get(us.inf.size() - 1).vol);
            } catch (NumberFormatException e) {
                status = 5;
            }
        }
    }


    static void access(User us, User RegUs) {
        if (us.acc.get(0).role != null) {
            switch (us.acc.get(0).role) {
                case "WRITE":
                    break;
                case "READ":
                    break;
                case "EXECUTE":
                    break;
                default:
                    status = 3;
                    return;
            }
        } else {
            CmdArgsParser.help();
        }
        boolean access = false;
        String[] userRes = us.acc.get(0).res.split("\\.");

        for (int i = 0; i < RegUs.acc.size(); i++) {
            if (us.acc.get(0).role.equals(RegUs.acc.get(i).role) && !access) {
                String[] accessRes = RegUs.acc.get(i).res.split("\\.");
                if (userRes.length < accessRes.length) {
                    continue;
                }
                for (int k = 0; k < accessRes.length; k++) {
                    access = accessRes[k].equals(userRes[k]);
                }
            }
        }
        if (!access) {
            status = 4;
        }
    }
}
