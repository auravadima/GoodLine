package main;

import domain.Accounting;
import domain.Authorization;
import domain.Roles;
import domain.User;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class AuthService {

    static User findUser(String login, ArrayList<User> users) {
        for (User user : users) {
            if (login.equals(user.getLogin())) {
                return user;
            }
        }
        return null;
    }

    static boolean isRightPass(String usPass, User regUs) throws NoSuchAlgorithmException {
        return regUs.getPass().equals(Passwords.getHash(usPass, regUs.getSalt()));
    }

    private static boolean isVolValid(Accounting auth) {
        try {
            Integer.parseInt(auth.vol);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isDateValid(Accounting auth) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.setLenient(false);
        format.applyPattern("yyyy-MM-dd");
        try {
            format.parse(auth.ds);
            format.parse(auth.de);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    static boolean isDateVolValid(Accounting auth) {
        return auth.ds == null || (isDateValid(auth) && isVolValid(auth));
    }

    static boolean isRoleValid(String role) {
        if (role != null) {
            try {
                Roles.valueOf(role);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return true;
    }

    static boolean hasAccess(Authorization userAuth, User regUs) {
        boolean hasAccess = false;
        if (userAuth.role == null) {
            return true;
        }
        String[] userRes = userAuth.res.split("\\.");
        for (int i = 0; i < regUs.getAcc().size(); i++) {
            if (userAuth.role.equals(regUs.getAcc().get(i).role)) {
                String[] accessRes = regUs.getAcc().get(i).res.split("\\.");
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
