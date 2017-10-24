package domain;

import main.DataSet;
import main.Passwords;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    public String login;
    public String pass;
    public String salt;
    public ArrayList<Authorization> acc = new ArrayList<>();
    private ArrayList<Accounting> inf = new ArrayList<>();

    public User(DataSet set) throws Exception {
        if (set.hasAuthenticationData()) {
            this.login = set.login;
            this.pass = set.pass;
        }
        if (set.hasAuthorizationData()) {
            addAccess(set.acc.res, set.acc.role);
        }
        if (set.hasAccountingData()) {
            addAcc(set.inf.ds, set.inf.de, set.inf.vol);
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
