package main;

import domain.User;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User("auravadima", "rAAzhyGF", "A.B", "WRITE"));
        users.add(new User("vasya", "qwerty", "A.K.Y", "READ"));
        users.add(new User("jdoe", "sup3rpaZZ", "a", "READ"));
        users.add(new User("jrow", "Qweqrty12", "a.b.c", "EXECUTE"));

        users.get(2).addAccess("a.b", "WRITE");
        users.get(3).addAccess("a.bc", "EXECUTE");

        CmdArgsParser cmdParser = new CmdArgsParser();
        if(cmdParser.parse(args) == null){
            CmdArgsParser.help();
            System.exit(0);
        }
        DataSet userData = cmdParser.parse(args);

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
            if (!AuthService.isRoleValid(userData.getRole())) {
                System.exit(3);
            }
            if (!AuthService.hasAccess(userData.getRes(),userData.getRole() , regUs)) {
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
