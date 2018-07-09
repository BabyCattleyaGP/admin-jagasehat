package com.example.baby.adminjagasehat;

public class UserModel{
    String ID, emailUser, kerjaUser, usiaUser, key, jkUser, tpUser;

    public UserModel(){

    }

    public UserModel (String ID, String email, String job, String age, String jk, String tp){
        this.ID = ID;
        this.emailUser = email;
        this.usiaUser = age;
        this.kerjaUser = job;
        this.jkUser =  jk;
        this.tpUser = tp;
    }

}