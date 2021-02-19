package com.erreius.developer.dev2018.presenters;

import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;
import com.erreius.developer.dev2018.interactor.MainInteractor;
import com.erreius.developer.dev2018.interfaces.MainContract;

public class MainPresenter implements MainContract.Presenter, MainContract.onOperationListener{

    private MainContract.View mView;
    private MainInteractor mInteractor;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mInteractor = new MainInteractor(this);
    }

    @Override
    public void createNewPlayer(User user) {
        mInteractor.performCreatePlayer(user);
    }

    @Override
    public void readPlayers(User user) {
        mInteractor.performReadPlayers(user);
    }

    @Override
    public void activarCodigo(Codigo codigo) {
        mInteractor.performActivarCodigo(codigo);
    }

    @Override
    public void encryptData(EncryptData encryptData) {
        mInteractor.performEncryptData(encryptData);
    }

    @Override
    public void onSuccess() {
        mView.onCreatePlayerSuccessful();
    }

    @Override
    public void onSuccessRead(User user) {
        mView.onUserRead(user);
    }

    @Override
    public void onSuccessEncrypt(EncryptData encryptData) {
        mView.onEncryptData(encryptData);
    }

    @Override
    public void onFailure() {
        mView.onCreatePlayerFailure();
    }

    @Override
    public void onStart() {
        mView.onProcessStart();
    }

    @Override
    public void onEnd() {
        mView.onProcessEnd();
    }
}
