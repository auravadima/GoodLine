package main;

import domain.Roles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.AuthService;

import java.sql.Connection;

class Main {

    public static void main(String[] args) throws Exception {

        int status = 0;

        final Logger logger = LogManager.getRootLogger();
        AuthService authService = new AuthService();
        try (Connection conn = new DB().getConn()) {

            CmdArgsParser cmdParser = new CmdArgsParser();
            DataSet userData = cmdParser.parse(args);
            if (userData.getLogin() == null || userData.getHelp()) {
                cmdParser.help();
            }
            else {

                Boolean usExist = authService.userExist(conn, userData.getLogin());

                if (userData.hasAuthenticationData()) {
                    if (!usExist) {
                        logger.info(String.format("Login %s does not exist", userData.getLogin()));
                        status = 1;
                    }
                    if (!authService.isRightPass(conn, userData.getPass(), userData.getLogin()) && status == 0) {
                        logger.info(String.format("Password %s for user %s is incorrect", userData.getPass(), userData.getLogin()));
                        status = 2;
                    }
                }

                if (userData.hasAuthorizationData() && status == 0) {
                    if (!Roles.isDefined(userData.getRole())) {
                        logger.info(String.format("Role %s is not defined", userData.getRole()));
                        status = 3;
                    }
                    if (!authService.hasAccess(conn, userData.getRes(), userData.getRole(), userData.getLogin()) && status == 0) {
                        logger.info(String.format("Path %s with role %s for user %s not avaliable",
                                userData.getRes(), userData.getRole(), userData.getLogin()));
                        status = 4;
                    }
                }
                if (userData.hasAccountingData() && status == 0
                        && (!authService.isDateValid(userData.getDs())
                        || !authService.isDateValid(userData.getDe())
                        || !authService.isVolValid(userData.getVol()))) {
                    logger.info(String.format("User %s entered inccorect data(ds,de,vol)", userData.getLogin()));
                    status = 5;
                }
            }
        }catch (Exception e){
            status = 255;
        }
        System.exit(status);
    }
}
