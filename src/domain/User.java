package domain;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    private String login;
    private String pass;
    private String salt;
    private ArrayList<Authorization> acc = new ArrayList<>();
    //Данные этой коллекции не используются, происходит только сохранение данных в неё, но эти данные нам будут нужны
    private ArrayList<Accounting> inf = new ArrayList<>();

    public User(String login, String pass) throws NoSuchAlgorithmException {
        this.login = login;
        this.pass = pass;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) throws NoSuchAlgorithmException {
        this.salt = salt;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
