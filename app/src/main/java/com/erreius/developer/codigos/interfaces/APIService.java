package com.erreius.developer.codigos.interfaces;

import com.erreius.developer.codigos.Model.User;
import com.erreius.developer.codigos.interactor.UserInteractor;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    /*@POST("AuthenticateUser")
    Call<UserInteractor> AuthenticateUser() {
        return null;
    }*/

    @POST("/api/login/authenticateuser")
    @FormUrlEncoded
    Call<User> authenticateUser(@Field("UserName") String email,
                        @Field("Password") String password);
}
