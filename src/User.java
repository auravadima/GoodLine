import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;

public class User {

    String  login;
    String  pass;
    String  salt;

    ArrayList<Accounting> inf = new ArrayList<>();
    ArrayList<Authorization> acc = new ArrayList<>();

    public User(DataSet set) throws ParseException, NoSuchAlgorithmException {
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
        if (set.salt != null) {
            setSalt(set.salt);
        }
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void addAccess(String res, String role)

    {
        this.acc.add(new Authorization(res, role));
    }

    public void addAcc(String ds, String de, String vol) {
        this.inf.add(new Accounting(ds, de, vol));
    }
}
