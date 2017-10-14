import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;

public class Init {

    public ArrayList<dataSet> sets = new ArrayList<>();
    public ArrayList<user> users = new ArrayList<>();

    public void createExampleUsersSets() throws NoSuchAlgorithmException {
        dataSet set = new dataSet("example");
        set.setLogin("auravadima");
        set.setPass("rAAzhyGF");
        set.setRes("A.B", "WRITE");
        sets.add(set);

        set = new dataSet("example");
        set.setLogin("vasya");
        set.setPass("qwerty");
        set.setRes("A.K.Y", "READ");
        sets.add(set);

        set = new dataSet("example");
        set.setLogin("jdoe");
        set.setPass("sup3rpaZZ");
        set.setRes("a", "READ");
        sets.add(set);
        //        users.add(new user("jrow","2d09fb4129e6480d97df3fee634b9220","a.bc","EXECUTE","",""));
        set = new dataSet("example");
        set.setLogin("jrow");
        set.setPass("Qweqrty12");
        set.setRes("a.b.c", "EXECUTE");
        sets.add(set);
    }

    public void createExampleUsers() throws NoSuchAlgorithmException, ParseException {
        this.createExampleUsersSets();
        for (int i = 0; i < this.sets.size(); i++) {
            users.add(new user(this.sets.get(i)));
        }
        users.get(2).addAccess("a.b", "WRITE");
        users.get(3).addAccess("a.bc", "EXECUTE");
    }

}
