package com.erreius.developer.codigos.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    public User(String userName,String password) {
        UserName = userName;
        Password = password;
    }
    public User() {
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

    @SerializedName("Telefono")
    public String Telefono;

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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    @Override
    public String toString() {
        return "Post{" +
                "email='" + this.Email + '\'' +
                ", password='" + this.Password +
                '}';
    }
}
