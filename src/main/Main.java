package main;

import domain.User;

public class Main {


    public static void main(String[] args) throws Exception {

        CmdArgsParser c = new CmdArgsParser();

        DataSet userData = c.Parse(args);
        if (c.isHelp()) {
            CmdArgsParser.help();
            System.exit(0);
        }

        ExampleUsers exampleUsers = new ExampleUsers();
        exampleUsers.createExampleUsers();

        User Me = new User(userData);
        User Reg = AuthService.isUser(Me, exampleUsers.users);

        if (userData.isAuthentication() && (AuthService.status == 0)) {
            AuthService.rightPass(Me, Reg);
        }
        if (userData.isAuthorization() && (AuthService.status == 0)) {
            AuthService.access(Me, Reg);
        }
        if (userData.isAccounting() && (AuthService.status == 0)) {
            AuthService.checkDateVol(Me);
        }
        System.exit(AuthService.status);
    }
}
