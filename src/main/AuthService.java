package main;

import domain.User;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat format = new SimpleDateFormat();
        format.setLenient(false);
        format.applyPattern("yyyy-MM-dd");
        try {
            format.parse(ds);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    static boolean hasAccess(String res, String role, User regUs) {
        boolean hasAccess = false;
        if (role == null) {
            return true;
        }
        String[] userRes = res.split("\\.");
        for (int i = 0; i < regUs.getAcc().size(); i++) {
            if (role.equals(regUs.getAcc().get(i).role.toString())) {
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
