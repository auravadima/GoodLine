package main;

import domain.Roles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.AuthService;

import java.sql.Connection;

class Main {

    public static void main(String[] args) throws Exception {

        final Logger logger = LogManager.getRootLogger();
        AuthService authService = new AuthService();
        DB db = new DB();
        db.migrate();
        db.connect();
        try (Connection conn = db.getConn()) {

            CmdArgsParser cmdParser = new CmdArgsParser();
            DataSet userData = cmdParser.parse(args);
            if (userData.getLogin() == null || userData.getHelp()) {
                cmdParser.help();
                db.getConn().close();
                System.exit(0);
            }

            Boolean usExist = authService.userExist(db, userData.getLogin());

            if (userData.hasAuthenticationData()) {
                if (!usExist) {
                    logger.info(String.format("Login %s does not exist", userData.getLogin()));
                    db.getConn().close();
                    System.exit(1);
                }
                if (!authService.isRightPass(db, userData.getPass(), userData.getLogin())) {
                    logger.info(String.format("Password %s for user %s is incorrect", userData.getPass(), userData.getLogin()));
                    db.getConn().close();
                    System.exit(2);
                }
            }

            if (userData.hasAuthorizationData()) {
                if (!Roles.isDefined(userData.getRole())) {
                    logger.info(String.format("Role %s is not defined", userData.getRole()));
                    db.getConn().close();
                    System.exit(3);
                }
                if (!authService.hasAccess(db, userData.getRes(), userData.getRole(), userData.getLogin())) {
                    logger.info(String.format("Path %s with role %s for user %s not avaliable",
                            userData.getRes(), userData.getRole(), userData.getLogin()));
                    db.getConn().close();
                    System.exit(4);
                }
            }
            if (userData.hasAccountingData()
                    && (!authService.isDateValid(userData.getDs())
                    || !authService.isDateValid(userData.getDe())
                    || !authService.isVolValid(userData.getVol()))) {
                logger.info(String.format("User %s entered inccorect data(ds,de,vol)", userData.getLogin()));
                db.getConn().close();
                System.exit(5);
            }
        }
        System.exit(0);
    }
}
