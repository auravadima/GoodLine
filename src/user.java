import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class user {
    
    String login;
    String pass;
    String res;
    String role;
    String ds;
    String de;
    int vol;
    String salt;

    user(String ...  str) throws ParseException, NoSuchAlgorithmException {
        if(str[0] != null) {
            this.login = str[0];
            this.pass = str[1];
        }
        if(str[2] != null){
            this.res = str[2];
            this.role = str[3];
        }
        if(str[4] != ""){
            this.ds = str[4];
            this.de = str[5];
            this.vol = Integer.valueOf(str[6]);
        }
    }

    public void setSalt(String salt){
        this.salt = salt;
    }

}
