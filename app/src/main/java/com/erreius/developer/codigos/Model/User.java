package com.erreius.developer.codigos.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    public User(String userName,String password) {
        UserName = userName;
        Password = password;
    }

    @SerializedName("IdUser")
    public int IdUser;

    @SerializedName("UserName")
    public String UserName;

    @SerializedName("FullUserName")
    public String FullUserName;

    @SerializedName("Password")
    public String Password;

    @SerializedName("Email")
    public String Email;

    public int getIdUser() {
        return IdUser;
    }

    public String getUserName() {
        return UserName;
    }

    public String getFullUserName() {
        return FullUserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public String toString() {
        return "Post{" +
                "email='" + this.Email + '\'' +
                ", password='" + this.Password +
                '}';
    }
}
