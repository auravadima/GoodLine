package main;

import domain.Connect;
import domain.Roles;
import org.flywaydb.core.Flyway;

import java.io.File;

class Main {

    public static void main(String[] args) throws Exception {

        Flyway flyway = new Flyway();
        flyway.setLocations("db/migration");
        flyway.setDataSource("jdbc:h2:file:./database", "auravadima", "rAAzhyGF1");
        if (!new File("./database.mv.db").exists()) {
            flyway.migrate();
        }
        LogOut log = new LogOut();

        Connect cnt = new Connect(new DB());
        cnt.setConn(cnt.getDB().getConnection());

        CmdArgsParser cmdParser = new CmdArgsParser();
        DataSet userData = cmdParser.parse(args);
        if (userData.getLogin() == null || userData.getHelp()) {
            cmdParser.help();
            cnt.getConn().close();
            System.exit(0);
        }

        Boolean usExist = AuthService.userExist(cnt, userData.getLogin());

        if (userData.hasAuthenticationData()) {
            if (!usExist) {
                log.printLoginError(userData.getLogin());
                cnt.getConn().close();
                System.exit(1);
            }
            if (!AuthService.isRightPass(cnt, userData.getPass(), userData.getLogin())) {
                log.printPassError(userData.getLogin(), userData.getPass());
                cnt.getConn().close();
                System.exit(2);
            }
        }

        if (userData.hasAuthorizationData()) {
            if (!Roles.isDefined(userData.getRole())) {
                log.printRoleError(userData.getRole());
                cnt.getConn().close();
                System.exit(3);
            }
            if (!AuthService.hasAccess(cnt, userData.getRes(), userData.getRole(), userData.getLogin())) {
                log.printAccessError(userData.getRes(), userData.getRole(), userData.getLogin());
                cnt.getConn().close();
                System.exit(4);
            }
        }
        if (userData.hasAccountingData()
                && (!AuthService.isDateValid(userData.getDs())
                || !AuthService.isDateValid(userData.getDe())
                || !AuthService.isVolValid(userData.getVol()))) {
            log.printAccountingError(userData.getLogin());
            cnt.getConn().close();
            System.exit(5);
        }
        cnt.getConn().close();
        System.exit(0);
    }
}
