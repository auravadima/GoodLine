package domain;

public class Authorization {

    public String res;
    public Roles role;

    Authorization(String res, Roles role) {
        this.res = res;
        this.role = role;
    }
}
