package main;

import domain.Authorization;
import domain.User;

import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


class AuthService {

    static User findUser(String login, ArrayList<User> users) {
        for (User user : users) {
            if (login.equals(user.getLogin())) {
                return user;
            }
        }
        return null;
    }

    static boolean isRightPass(String usPass, User regUs) throws NoSuchAlgorithmException {
        return Passwords.safeCompare(regUs.getPass(), Passwords.getHash(usPass, regUs.getSalt()));
    }

    static boolean isVolValid(String vol) {
        try {
            Integer.parseInt(vol);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean isDateValid(String ds) {
        try {
            java.time.LocalDate.parse(ds);
            return true;
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
    }

    static boolean hasAccess(String res, String role, User regUs) {
        if (role == null) {
            return true;
        }
        res = res + ".";
        for (Authorization authInf : regUs.getAcc()) {
            if (role.equals(authInf.role.toString())) {
                String usRes = authInf.res + ".";
                if (res.startsWith(usRes)) {
                    return true;
                }
            }
        }
        return false;
    }
}
