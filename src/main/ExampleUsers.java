package main;

import domain.User;

import java.util.ArrayList;

class ExampleUsers {

    private ArrayList<User> users = new ArrayList<>();

    void createExampleUsers() throws Exception {
        users.clear();
        users.add(new User("auravadima", "rAAzhyGF", "A.B", "WRITE"));
        users.add(new User("vasya", "qwerty", "A.K.Y", "READ"));
        users.add(new User("jdoe", "sup3rpaZZ", "a", "READ"));
        users.add(new User("jrow", "Qweqrty12", "a.b.c", "EXECUTE"));

        users.get(2).addAccess("a.b", "WRITE");
        users.get(3).addAccess("a.bc", "EXECUTE");
    }

    ArrayList<User> getUsers() {
        return users;
    }
}
