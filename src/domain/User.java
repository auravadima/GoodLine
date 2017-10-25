package domain;

import main.Passwords;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    private String login;
    private String pass;
    private String salt;
    private ArrayList<Authorization> acc = new ArrayList<>();
    private ArrayList<Accounting> inf = new ArrayList<>();

    public User(String login, String pass, String res, String role) throws NoSuchAlgorithmException {
        this.login = login;
        this.pass = pass;
        addAccess(res, role);
        setSalt();
    }

    private void setSalt() throws NoSuchAlgorithmException {
        this.salt = Passwords.randSalt();
        this.pass = Passwords.getHash(this.pass, this.salt);
    }

    public String getSalt() {
        return this.salt;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPass() {
        return this.pass;
    }

    public ArrayList<Authorization> getAcc() {
        return this.acc;
    }

    public void addAccess(String res, String role) {
        this.acc.add(new Authorization(res, role));
    }

    public void addInf(String ds, String de, String vol) {
        this.inf.add(new Accounting(ds, de, vol));
    }
}
