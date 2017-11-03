package main;

import domain.Roles;
import domain.User;

import java.util.ArrayList;

import static domain.Roles.*;

class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User("auravadima", "rAAzhyGF"));
        users.add(new User("vasya", "qwerty"));
        users.add(new User("jdoe", "sup3rpaZZ"));
        users.add(new User("jrow", "Qweqrty12"));
        users.add(new User("UWA", "HDP"));

        for (User user : users) {
            user.setSalt(Passwords.randSalt());
            user.setPass(Passwords.getHash(user.getPass(), user.getSalt()));
        }

        users.get(0).addAccess("A.B", WRITE);
        users.get(1).addAccess("A.K.Y", READ);
        users.get(2).addAccess("a", READ);
        users.get(2).addAccess("a.b", WRITE);
        users.get(3).addAccess("a.b.c", EXECUTE);
        users.get(3).addAccess("a.bc", EXECUTE);

        users.get(0).addInf("2015-12-12", "2016-10-10", "354");

        CmdArgsParser cmdParser = new CmdArgsParser();
        DataSet userData = cmdParser.parse(args);
        if (userData == null || userData.getHelp()) {
            CmdArgsParser.help();
            System.exit(0);
        }

        User regUs = AuthService.findUser(userData.getLogin(), users);

        if (userData.hasAuthenticationData()) {
            if (regUs == null) {
                System.exit(1);
            }
            if (!AuthService.isRightPass(userData.getPass(), regUs)) {
                System.exit(2);
            }
        }
        if (userData.hasAuthorizationData()) {
            if (!Roles.isDefined(userData.getRole())) {
                System.exit(3);
            }
            if (!AuthService.hasAccess(userData.getRes(), userData.getRole(), regUs)) {
                System.exit(4);
            }
        }
        if (userData.hasAccountingData()
                && (!AuthService.isDateValid(userData.getDs())
                || !AuthService.isDateValid(userData.getDe())
                || !AuthService.isVolValid(userData.getVol()))) {
            System.exit(5);
        }
        System.exit(0);
    }
}
