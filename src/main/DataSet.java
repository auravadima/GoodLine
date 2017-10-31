package main;

class DataSet {
    private String login;
    private String pass;
    private String ds;
    private String de;
    private String vol;
    private String res;
    private String role;

    boolean hasAuthenticationData() {
        return (this.login != null && this.pass != null);
    }

    boolean hasAuthorizationData() {
        return (hasAuthenticationData() && this.res != null && this.role != null);
    }

    boolean hasAccountingData() {

        return (hasAuthorizationData() && this.ds != null && this.de != null && this.vol != null);
    }

    String getLogin() {
        return login;
    }

    void setLogin(String login) {
        this.login = login;
    }

    String getPass() {
        return pass;
    }

    void setPass(String pass) {
        this.pass = pass;
    }

    String getDs() {
        return ds;
    }

    void setDs(String ds) {
        this.ds = ds;
    }

    String getDe() {
        return de;
    }

    void setDe(String de) {
        this.de = de;
    }

    String getVol() {
        return vol;
    }

    void setVol(String vol) {
        this.vol = vol;
    }

    String getRes() {
        return res;
    }

    void setRes(String res) {
        this.res = res;
    }

    String getRole() {
        return role;
    }

    void setRole(String role) {
        this.role = role;
    }
}
