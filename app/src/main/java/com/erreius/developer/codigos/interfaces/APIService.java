package com.erreius.developer.codigos.interfaces;

import com.erreius.developer.codigos.Model.User;
import com.erreius.developer.codigos.interactor.UserInteractor;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @POST("/api/login/authenticateuser")
    @FormUrlEncoded
    Call<User> authenticateUser(@Field("UserName") String email,
                                @Field("Password") String password
    );

    @POST("/api/login/registeruser")
    @FormUrlEncoded
    Call<User> registeruser(@Field("Nombre") String nombre,
                            @Field("Apellido") String apellido,
                            @Field("Email") String email,
                            @Field("Telefono") String telefono,
                            @Field("Password") String password
    );
}
