package main;

import domain.User;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

class ExampleUsers {

    ArrayList<User> users = new ArrayList<>();
    private ArrayList<DataSet> sets = new ArrayList<>();

    private void createExampleUsersSets() throws NoSuchAlgorithmException {
        sets.add(new DataSet("auravadima", "rAAzhyGF", "A.B", "WRITE"));
        sets.add(new DataSet("vasya", "qwerty", "A.K.Y", "READ"));
        sets.add(new DataSet("jdoe", "sup3rpaZZ", "a", "READ"));
        sets.add(new DataSet("jrow", "Qweqrty12", "a.b.c", "EXECUTE"));
    }

    void createExampleUsers() throws Exception {
        users.clear();
        sets.clear();
        this.createExampleUsersSets();
        for (DataSet set : this.sets) {
            users.add(new User(set));
        }
        for (User user : users) {
            user.setSalt();
        }
        users.get(2).addAccess("a.b", "WRITE");
        users.get(3).addAccess("a.bc", "EXECUTE");
    }
}
