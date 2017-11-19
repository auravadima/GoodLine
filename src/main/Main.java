package main;

import domain.LogOut;
import domain.Roles;

class Main {

    public static void main(String[] args) throws Exception {

        LogOut log = new LogOut();

        CmdArgsParser cmdParser = new CmdArgsParser();
        DataSet userData = cmdParser.parse(args);
        if (userData.getLogin() == null || userData.getHelp()) {
            CmdArgsParser.help();
            System.exit(0);
        }

        Boolean usExist = AuthService.userExist(userData.getLogin());

        if (userData.hasAuthenticationData()) {
            if (!usExist) {
                log.printLoginError(userData.getLogin());
                System.exit(1);
            }
            if (!AuthService.isRightPass(userData.getPass(), userData.getLogin())) {
                log.printPassError(userData.getLogin(), userData.getPass());
                System.exit(2);
            }
        }

        if (userData.hasAuthorizationData()) {
            if (!Roles.isDefined(userData.getRole())) {
                log.printRoleError(userData.getRole());
                System.exit(3);
            }
            if (!AuthService.hasAccess(userData.getRes(), userData.getRole(), userData.getLogin())) {
                log.printAccessError(userData.getRes(), userData.getRole(), userData.getLogin());
                System.exit(4);
            }
        }
        if (userData.hasAccountingData()
                && (!AuthService.isDateValid(userData.getDs())
                || !AuthService.isDateValid(userData.getDe())
                || !AuthService.isVolValid(userData.getVol()))) {
            log.printAccountingError(userData.getLogin());
            System.exit(5);
        }
        System.exit(0);
    }
}
