package com.erreius.developer.dev2018.interfaces;

import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    @POST("/api/login/activarcodigo")
    @FormUrlEncoded
    Call<User> activarcodigo(@Field("IdUser") int iduser,
                                @Field("Codigo") String codigo
    );

    @POST("/api/employees/encryptdata")
    @FormUrlEncoded
    Call<EncryptData> encryptdata(@Field("EUS") String iduser,
                                  @Field("EPS") String password
    );
}
