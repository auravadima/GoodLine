public class user {
    
    String login;
    String pass;
    String res;
    String role;

    user(String ...  str){
        this.login = str[0];
        this.pass = str[1];
        if(str.length == 4) {
            this.res = str[2];
            this.role = str[3];
        }
    }
}
