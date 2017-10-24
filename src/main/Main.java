package main;

import domain.User;

public class Main {

    public static void main(String[] args) throws Exception {

        CmdArgsParser cmdParser = new CmdArgsParser();
        DataSet userData = cmdParser.Parse(args);
        if (cmdParser.isHelp()) {
            CmdArgsParser.help();
            System.exit(0);
        }

        ExampleUsers exampleUsers = new ExampleUsers();
        exampleUsers.createExampleUsers();

        User me = new User(userData);
        User regUs = AuthService.isUser(me, exampleUsers.users);

        if (userData.hasAuthenticationData()) {
            if (regUs == null) {
                System.exit(1);
            }
            if (!AuthService.isRightPass(me, regUs)) {
                System.exit(2);
            }
        }
        if (userData.hasAuthorizationData()) {
            if (!AuthService.isRoleValid(me)) {
                System.exit(3);
            }
            if (!AuthService.hasAccess(me, regUs)) {
                System.exit(4);
            }
        }
        if (userData.hasAccountingData() && !AuthService.isDateVolValid(me)) {
            System.exit(5);
        }
        System.exit(0);
    }
}
