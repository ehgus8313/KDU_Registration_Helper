package com.godohosting.ehgus83133.sugangapp;

public class User {

    String userID;
    String userName;
    String userEmail;
    String userGender;
    String userMajor;
    String admin;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserMajor() {
        return userMajor;
    }

    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public User(String userID, String userName, String userEmail, String userGender, String userMajor, String admin) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userMajor = userMajor;
        this.admin = admin;
    }


}
