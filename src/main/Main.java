package main;

import domain.User;

public class Main {

    public static void main(String[] args) throws Exception {

        CmdArgsParser cmdParser = new CmdArgsParser();
        if (cmdParser.parse(args) == null) {
            CmdArgsParser.help();
            System.exit(0);
        }
        DataSet userData = cmdParser.parse(args);

        ExampleUsers exampleUsers = new ExampleUsers();
        exampleUsers.createExampleUsers();

        User regUs = AuthService.findUser(userData.login, exampleUsers.getUsers());

        if (userData.hasAuthenticationData()) {
            if (regUs == null) {
                System.exit(1);
            }
            if (!AuthService.isRightPass(userData.pass, regUs)) {
                System.exit(2);
            }
        }
        if (userData.hasAuthorizationData()) {
            if (!AuthService.isRoleValid(userData.acc.role)) {
                System.exit(3);
            }
            if (!AuthService.hasAccess(userData.acc, regUs)) {
                System.exit(4);
            }
        }
        if (userData.hasAccountingData() && !AuthService.isDateVolValid(userData.inf)) {
            System.exit(5);
        }
        System.exit(0);
    }
}
