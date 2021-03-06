package com.erreius.developer.dev2018.interactor;

import com.erreius.developer.dev2018.utils.ApiUtils;
import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.CodigosResponse;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;
import com.erreius.developer.dev2018.interfaces.APIService;
import com.erreius.developer.dev2018.interfaces.MainContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractor implements MainContract.Interactor{
    private APIService mAPIService;
    private MainContract.onOperationListener mListner;


    public MainInteractor(MainContract.onOperationListener mListner) {
        this.mListner = mListner;
        mAPIService = ApiUtils.getAPIService();
    }

    @Override
    public void performCreatePlayer(User user) {
        mListner.onStart();
        mAPIService.registeruser(user.getUserName(),
                                 user.getFullUserName(),
                                 user.getEmail(),
                                 user.getTelefono(),
                                 user.getPassword(),
                                 user.getUrlFoto(),
                                 user.getTipoRed()
        ).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(response.isSuccessful()) {
                    mListner.onSuccessCreate(response.body());
                    mListner.onEnd();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mListner.onFailure();
                mListner.onEnd();
            }
        });
    }

    @Override
    public void performReadPlayers(User user) {
        mListner.onStart();
        mAPIService.authenticateUser(user.UserName, user.Password,user.IdUser,user.Email).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(response.isSuccessful()) {
                    mListner.onSuccessRead(response.body());
                    mListner.onEnd();
                }
                else{
                    mListner.onFailure();
                    mListner.onEnd();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mListner.onFailure();
                mListner.onEnd();
            }
        });
    }

    @Override
    public void performEncryptData(EncryptData encryptData) {
        mListner.onStart();
        mAPIService.encryptdata(encryptData.EUS, encryptData.EPS).enqueue(new Callback<EncryptData>() {
            @Override
            public void onResponse(Call<EncryptData> call, Response<EncryptData> response) {

                if(response.isSuccessful()) {
                    mListner.onSuccessEncrypt(response.body());
                    mListner.onEnd();
                }
            }

            @Override
            public void onFailure(Call<EncryptData> call, Throwable t) {
                mListner.onFailure();
                mListner.onEnd();
            }
        });
    }

    @Override
    public void performGuardarNota(Codigo codigo) {
        mAPIService.guardarnota(codigo.IdUser, codigo.getTituloCodigo(),codigo.getNota()).enqueue(new Callback<Codigo>() {
            @Override
            public void onResponse(Call<Codigo> call, Response<Codigo> response) {

                if(response.isSuccessful()) {
                    mListner.onSuccessNota(response.body());
                    mListner.onEnd();
                }
            }

            @Override
            public void onFailure(Call<Codigo> call, Throwable t) {
                mListner.onFailure();
                mListner.onEnd();
            }
        });
    }

    @Override
    public void performEliminarNota(Codigo codigo) {
        mAPIService.eliminarnota(codigo.getIdNota()).enqueue(new Callback<Codigo>() {
            @Override
            public void onResponse(Call<Codigo> call, Response<Codigo> response) {

                if(response.isSuccessful()) {
                    mListner.onSuccessNota(response.body());
                    mListner.onEnd();
                }
            }

            @Override
            public void onFailure(Call<Codigo> call, Throwable t) {
                mListner.onFailure();
                mListner.onEnd();
            }
        });
    }

    @Override
    public void performActivarCodigo(Codigo codigo) {
        mAPIService.activarcodigo(codigo.IdUser, codigo.Codigo).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(response.isSuccessful()) {
                    mListner.onSuccess();
                    mListner.onEnd();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mListner.onFailure();
                mListner.onEnd();
            }
        });
    }
    @Override
    public void performObtenerNotas(Codigo codigo) {
        mAPIService.obtenernotas(codigo.IdUser).enqueue(new Callback<CodigosResponse>() {
            @Override
            public void onResponse(Call<CodigosResponse> call, Response<CodigosResponse> response) {

                if(response.isSuccessful()) {
                    mListner.onSuccessObtenerNota(response.body());
                    mListner.onEnd();
                }
            }

            @Override
            public void onFailure(Call<CodigosResponse> call, Throwable t) {
                mListner.onFailure();
                mListner.onEnd();
            }
        });
    }
}

