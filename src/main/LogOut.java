package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class LogOut {

    private final Logger logger = LogManager.getRootLogger();

    void printLoginError(String login) {
        logger.info(String.format("Login %s does not exist", login));
    }

    void printPassError(String login, String password) {
        logger.info(String.format("Password %s for user %s is incorrect", password, login));
    }

    void printRoleError(String role) {
        logger.info(String.format("Role %s is not defined", role));
    }

    void printAccessError(String path, String role, String login) {
        logger.info(String.format("Path %s with role %s for user %s not avaliable", path, role, login));
    }

    void printAccountingError(String login) {
        logger.info(String.format("User %s entered inccorect data(ds,de,vol)", login));
    }

}
