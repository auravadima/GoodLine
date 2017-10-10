import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class user {
    
    String login;
    String pass;
    String res;
    String role;
    Date ds;
    Date de;
    int vol;

    user(String ...  str) throws ParseException {
        if(str.length == 2) {
            this.login = str[0];
            this.pass = str[1];
        }
        if(str.length == 4){
            this.res = str[2];
            this.role = str[3];
        }
        if(str.length == 7){
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            this.ds = format.parse(str[4]);
            this.de = format.parse(str[5]);
            this.vol = Integer.valueOf(str[6]);
        }
    }

}
