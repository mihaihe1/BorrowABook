package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class User {
    private String userName;
    private String password;
    private String email;
    private final Date accountCreation;

    public User(String userName, String password, String email){
        this.userName = userName;
        this.password = password;
        this.email = email;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        this.accountCreation = new Date(System.currentTimeMillis());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAccountCreation() {
        return accountCreation;
    }

    @Override
    public String toString(){
        return userName + " / " + email + " / " + accountCreation;
    }
}
