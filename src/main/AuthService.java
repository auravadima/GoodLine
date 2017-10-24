package main;

import domain.User;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AuthService {

    static User isUser(DataSet us, ArrayList<User> users) {
        for (User user : users) {
            if (us.login.equals(user.login)) {
                return user;
            }
        }
        return null;
    }

    static boolean isRightPass(DataSet us, User regUs) throws NoSuchAlgorithmException {
        return regUs.pass.equals(Passwords.getHash(us.pass, regUs.salt)); //2
    }

    static boolean isDateVolValid(DataSet us) {
        if (us.inf != null) {
            SimpleDateFormat format = new SimpleDateFormat();
            format.setLenient(false);
            format.applyPattern("yyyy-MM-dd");
            try {
                format.parse(us.inf.ds);
                format.parse(us.inf.de);
            } catch (ParseException e) {
                return false;
            }
            try {
                Integer.parseInt(us.inf.vol);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    static boolean isRoleValid(DataSet us) {
        if (us.acc.role != null) {
            switch (us.acc.role) {
                case "WRITE":
                    break;
                case "READ":
                    break;
                case "EXECUTE":
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    static boolean hasAccess(DataSet us, User regUs) {
        boolean hasAccess = false;
        String[] userRes = us.acc.res.split("\\.");

        for (int i = 0; i < regUs.acc.size(); i++) {
            if (us.acc.role.equals(regUs.acc.get(i).role)) {
                String[] accessRes = regUs.acc.get(i).res.split("\\.");
                if (userRes.length < accessRes.length) {
                    continue;
                }
                for (int k = 0; k < accessRes.length; k++) {
                    hasAccess = accessRes[k].equals(userRes[k]);
                }
                if (hasAccess) {
                    return true;
                }
            }
        }
        return false;
    }
}
