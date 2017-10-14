import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class user {
    
    String login;
    String pass;
    String ds;
    String de;
    int vol;
    String salt;

    ArrayList<access> acc = new ArrayList<access>();

    user(String ...  str) throws ParseException, NoSuchAlgorithmException {
        if(str[0] != null) {
            this.login = str[0];
            this.pass = str[1];
        }
        if(str[2] != ""){
            acc.add(new access(str[2],str[3]));
           }
        if(str[4] != ""){
            this.ds = str[4];
            this.de = str[5];
            try {
                Integer.parseInt(str[6]);
            } catch (NumberFormatException e) {

                main.status = 5;
                return;

            }
            this.vol = Integer.valueOf(str[6]);
        }
    }

    public void setSalt(String salt){
        this.salt = salt;
    }

    public void setAccess(String res, String role) {
        this.acc.add(new access(res,role));
    }
}
