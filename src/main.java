import java.util.ArrayList;

public class main {

    public static ArrayList<user> users = new ArrayList<user>();

    public static void main(String[] args) {

        users.add(new user("auravadima","rAAzhyGF"));
        users.add(new user("vasya","qwerty"));
        user Me = new user(args);
        auth.isUser(Me);

    }
}
