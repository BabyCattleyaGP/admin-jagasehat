package com.example.baby.adminjagasehat;

public class UserModel{
    String emailUser, kerjaUser, usiaUser, key;

    public UserModel(){
        
    }

    public UserModel (String email, String job, String age, String key){
        this.emailUser = email;
        this.usiaUser = age;
        this.kerjaUser = job;
        this.key = key;
    }

}