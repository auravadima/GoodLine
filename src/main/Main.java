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

        User regUs = AuthService.isUser(userData, exampleUsers.users);

        if (userData.hasAuthenticationData()) {
            if (regUs == null) {
                System.exit(1);
            }
            if (!AuthService.isRightPass(userData, regUs)) {
                System.exit(2);
            }
        }
        if (userData.hasAuthorizationData()) {
            if (!AuthService.isRoleValid(userData)) {
                System.exit(3);
            }
            if (!AuthService.hasAccess(userData, regUs)) {
                System.exit(4);
            }
        }
        if (userData.hasAccountingData() && !AuthService.isDateVolValid(userData)) {
            System.exit(5);
        }
        System.exit(0);
    }
}
