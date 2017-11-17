package domain;

import java.util.logging.Logger;

public class LogOut {

    private final Logger logger = Logger.getLogger(LogOut.class.getName());

    public void printLoginError(String login) {
        logger.info(String.format("Login %s does not exist", login));
    }

    public void printPassError(String login, String password) {
        logger.info(String.format("Password %s for user %s is incorrect", password, login));
    }

    public void printRoleError(String role) {
        logger.info(String.format("Role %s is not defined", role));
    }

    public void printAccessError(String path, String role, String login) {
        logger.info(String.format("Path %s with role %s for user %s not avaliable", path, role, login));
    }

    public void printAccountingError(String login) {
        logger.info(String.format("User %s entered inccorect data(ds,de,vol)", login));
    }

}
