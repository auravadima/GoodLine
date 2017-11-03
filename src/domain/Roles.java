package domain;

public enum Roles {
    READ, WRITE, EXECUTE, UNDEFINED;

    public static boolean isDefined(String role) {
        try {
            Roles.valueOf(role);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

}