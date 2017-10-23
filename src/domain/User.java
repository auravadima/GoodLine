package domain;

import main.DataSet;
import main.Passwords;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    public String login;
    public String pass;
    public String salt;

    public ArrayList<Accounting> inf = new ArrayList<>();
    public ArrayList<Authorization> acc = new ArrayList<>();

    public User(DataSet set) throws Exception {
        if (set.isAuthentication()) {
            this.login = set.login;
            this.pass = set.pass;
        }
        if (set.isAuthorization()) {
            addAccess(set.res, set.role);
        }
        if (set.isAccounting()) {
            addAcc(set.ds, set.de, set.vol);
        }
    }

    public void setSalt() throws NoSuchAlgorithmException {
        this.salt = Passwords.randSalt();
        this.pass = Passwords.getHash(this.pass, this.salt);
    }

    public void addAccess(String res, String role)

    {
        this.acc.add(new Authorization(res, role));
    }

    private void addAcc(String ds, String de, String vol) {
        this.inf.add(new Accounting(ds, de, vol));
    }
}
