package com.erreius.developer.codigos.interactor;

import android.util.Log;

import com.erreius.developer.codigos.ApiUtils;
import com.erreius.developer.codigos.Model.User;
import com.erreius.developer.codigos.interfaces.APIService;
import com.erreius.developer.codigos.interfaces.MainContract;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MainInteractor implements MainContract.Ineractor{
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
                                 user.getPassword()
        ).enqueue(new Callback<User>() {
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
    public void performReadPlayers(User user) {
        mListner.onStart();
        mAPIService.authenticateUser(user.UserName, user.Password).enqueue(new Callback<User>() {
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
}

