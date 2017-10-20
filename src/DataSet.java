import java.security.NoSuchAlgorithmException;

public class DataSet {
    String login;
    String pass;
    String res;
    String role;
    String salt;
    String ds;
    String de;
    String vol;

    public DataSet(String anyString) {
        createExampleUser();
    }

    public DataSet() {
    }

    public boolean isAuthentication() {
        if (this.login != null && this.pass != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAuthorization() {
        if (isAuthentication() && this.res != null && this.role != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAccounting() {
        if (isAuthorization() && this.ds != null & this.de != null & this.vol != null) {
            return true;
        } else {
            return false;
        }
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) throws NoSuchAlgorithmException {
        if (this.salt == null) {
            this.pass = pass;
        } else {
            this.pass = Passwords.hash(Passwords.hash(pass) + this.salt);
        }
    }

    public void setInfo(String ds, String de, String vol) {
        this.ds = ds;
        this.de = de;
        this.vol = vol;
    }

    public void setRes(String res, String role) {
        this.res = res;
        this.role = role;
    }

    public void createExampleUser() {
        this.salt = Passwords.randSalt();
    }

    public void setSalt() {
        this.salt = Passwords.randSalt();
    }


}
