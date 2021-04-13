package com.erreius.developer.dev2018.interfaces;

import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.CodigosResponse;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("/api/login/authenticateuser")
    @FormUrlEncoded
    Call<User> authenticateUser(@Field("UserName") String userName,
                                @Field("Password") String password,
                                @Field("idUser") Integer idUser,
                                @Field("Email") String email
    );

    @POST("/api/login/registrarusuario")
    @FormUrlEncoded
    Call<User> registeruser(@Field("Nombre") String nombre,
                            @Field("Apellido") String apellido,
                            @Field("Email") String email,
                            @Field("Telefono") String telefono,
                            @Field("Password") String password,
                            @Field("UrlFoto") String urlfoto,
                            @Field("TipoRed") String tipored
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

    @POST("/api/login/guardarnota")
    @FormUrlEncoded
    Call<Codigo> guardarnota(@Field("IdUser") int iduser,
                             @Field("TituloCodigo") String titulocodigo,
                             @Field("Nota") String nota
    );
    @POST("/api/login/obtenernotas")
    @FormUrlEncoded
    Call<CodigosResponse> obtenernotas(@Field("IdUser") int iduser
    );

    @POST("/api/login/eliminarnota")
    @FormUrlEncoded
    Call<Codigo> eliminarnota(@Field("idNota") int idnota
    );
}
