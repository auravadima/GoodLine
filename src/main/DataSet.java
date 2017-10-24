package main;

import java.security.NoSuchAlgorithmException;

public class DataSet {
    public String login;
    public String pass;
    public String res;
    public String role;
    public String ds;
    public String de;
    public String vol;

    DataSet() {}

    DataSet(String login, String pass, String res, String role) throws NoSuchAlgorithmException {
        setLogin(login);
        setPass(pass);
        setRes(res, role);
    }

    public boolean hasAuthenticationData() {
        return (this.login != null && this.pass != null);
    }

    public boolean hasAuthorizationData() {
        return (hasAuthenticationData() && this.res != null && this.role != null);
    }

    public boolean hasAccountingData() {
        return hasAuthorizationData() && this.ds != null && this.de != null && this.vol != null;
    }

    void setLogin(String login) {
        this.login = login;
    }

    void setPass(String pass) throws NoSuchAlgorithmException {
        this.pass = pass;
    }

    void setInfo(String ds, String de, String vol) {
        this.ds = ds;
        this.de = de;
        this.vol = vol;
    }

    void setRes(String res, String role) {
        this.res = res;
        this.role = role;
    }
}
