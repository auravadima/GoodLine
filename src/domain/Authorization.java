package domain;

public class Authorization {

    public String res;
    public Roles role;

    Authorization(String res, String role) {
        this.res = res;
        this.role = Roles.fromString(role);
    }
}
