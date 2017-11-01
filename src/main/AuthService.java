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
        return Passwords.isEqual(regUs.getPass().getBytes(), Passwords.getHash(usPass, regUs.getSalt()).getBytes());
    }

    static boolean isVolValid(String vol) {
        try {
            Integer.parseInt(vol);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    static boolean isDateValid(String ds) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            java.time.LocalDate.parse(ds, format);
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
        return true;
    }

    static boolean hasAccess(String res, String role, User regUs) {
        if (role == null) {
            return true;
        }
        for (Authorization authInf : regUs.getAcc()) {
            if (role.equals(authInf.role.toString())) {
                if (res.startsWith(authInf.res)) {
                    return true;
                }
            }
        }
        return false;
    }
}
