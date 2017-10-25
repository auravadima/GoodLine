package main;

import domain.Accounting;
import domain.Authorization;

import java.security.NoSuchAlgorithmException;

public class DataSet {
    String login;
    String pass;
    Accounting inf;
    Authorization acc;

    DataSet() {
    }

    DataSet(String login, String pass, String res, String role) throws NoSuchAlgorithmException {
        this.login = login;
        this.pass = pass;
        this.acc = new Authorization(res, role);
    }

    boolean hasAuthenticationData() {
        return (this.login != null && this.pass != null);
    }

    boolean hasAuthorizationData() {
        return (hasAuthenticationData() && this.acc != null);
    }

    boolean hasAccountingData() {

        return (hasAuthorizationData() && this.inf != null);
    }

    void setLogin(String login) {
        this.login = login;
    }

    void setPass(String pass) {
        this.pass = pass;
    }

    void setRes(String res, String role) {
        this.acc = new Authorization(res, role);
    }

    void setInfo(String ds, String de, String vol) {
        this.inf = new Accounting(ds, de, vol);
    }

    public Accounting getInfo() {
        return this.inf;
    }

    public Authorization getAcc() {
        return this.acc;
    }

}
