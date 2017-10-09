public class user {
    
    String login;
    String pass;
    String res;
    String role;

    user(String ...  str){
        if(str.length > 1) {
            this.login = str[0];
            this.pass = str[1];
        }
        else if(str.length == 4) {
            this.res = str[2];
            this.role = str[3];
        }
        else{
            cmd.help();
        }
    }

}
