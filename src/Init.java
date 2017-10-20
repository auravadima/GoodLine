import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;

public class Init {

    public ArrayList<DataSet> sets = new ArrayList<>();
    public ArrayList<User> users = new ArrayList<>();

    public void createExampleUsersSets() throws NoSuchAlgorithmException {
        DataSet set = new DataSet("exampleUser");
        set.setLogin("auravadima");
        set.setPass("rAAzhyGF");
        set.setRes("A.B", "WRITE");
        sets.add(set);

        set = new DataSet("exampleUser");
        set.setLogin("vasya");
        set.setPass("qwerty");
        set.setRes("A.K.Y", "READ");
        sets.add(set);

        set = new DataSet("exampleUser");
        set.setLogin("jdoe");
        set.setPass("sup3rpaZZ");
        set.setRes("a", "READ");
        sets.add(set);

        set = new DataSet("exampleUser");
        set.setLogin("jrow");
        set.setPass("Qweqrty12");
        set.setRes("a.b.c", "EXECUTE");
        sets.add(set);
    }

    public void createExampleUsers() throws NoSuchAlgorithmException, ParseException {
        this.createExampleUsersSets();
        for (int i = 0; i < this.sets.size(); i++) {
            users.add(new User(this.sets.get(i)));
        }
        users.get(2).addAccess("a.b", "WRITE");
        users.get(3).addAccess("a.bc", "EXECUTE");
    }

}
