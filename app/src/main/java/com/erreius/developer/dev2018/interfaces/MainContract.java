package com.erreius.developer.dev2018.interfaces;

import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;

public interface MainContract {

    interface View{
        void onCreatePlayerSuccessful();
        void onCreatePlayerFailure();
        void onProcessStart();
        void onProcessEnd();
        void onUserRead(User user);
        void onEncryptData(EncryptData encryptData);
    }

    interface Presenter{
        void createNewPlayer(User user);
        void readPlayers(User user);
        void activarCodigo(Codigo codigo);
        void encryptData(EncryptData encryptData);
    }

    interface Interactor{
        void performCreatePlayer(User user);
        void performReadPlayers(User user);
        void performActivarCodigo(Codigo codigo);
        void performEncryptData(EncryptData encryptData);
    }

    interface onOperationListener{
        void onSuccess();
        void onSuccessRead(User user);
        void onSuccessEncrypt(EncryptData encryptData);
        void onFailure();
        void onStart();
        void onEnd();
    }
}
