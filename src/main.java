import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        //Collection of users
        ArrayList<user> users = new ArrayList<user>();
        users.add(new user("auravadima","rAAzhyGF"));
        users.add(new user("vasya","qwerty"));
        user Me = new user(args);
        System.out.println("Hello, I'm " + Me.login + "\nMy password is " + Me.pass);
    }
}
