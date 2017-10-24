package main;

import domain.Accounting;
import domain.Authorization;

import java.security.NoSuchAlgorithmException;

public class DataSet {
    public String login;
    public String pass;
    public Accounting inf;
    public Authorization acc;

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
        return (hasAuthenticationData() && this.acc != null);
    }

    public boolean hasAccountingData() {

        return (hasAuthorizationData() && this.inf != null);
    }

    void setLogin(String login) {
        this.login = login;
    }

    void setPass(String pass) throws NoSuchAlgorithmException {
        this.pass = pass;
    }

    void setInfo(String ds, String de, String vol) {
        this.inf = new Accounting(ds, de, vol);
    }

    void setRes(String res, String role) {
        this.acc = new Authorization(res, role);
    }
}
