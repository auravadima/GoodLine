package domain;

public class Authorization {

    public String res;
    public Roles role;

    Authorization(String res, String role) {
        this.res = res;
        try {
            this.role = Roles.valueOf(role);
        } catch (IllegalArgumentException e) {
            this.role = Roles.UNDEFINED;
        }
    }
}
