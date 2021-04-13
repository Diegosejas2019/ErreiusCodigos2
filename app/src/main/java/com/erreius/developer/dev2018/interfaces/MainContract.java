package com.erreius.developer.dev2018.interfaces;

import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.CodigosResponse;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;

public interface MainContract {

    interface View{
        void onCreatePlayerSuccessful();
        void onCreatePlayerFailure();
        void onProcessStart();
        void onProcessEnd();
        void onUserRead(User user);
        void onUserCreate(User user);
        void onEncryptData(EncryptData encryptData);
        void onGuardarNota(Codigo codigo);
        void onObtenerNotas(CodigosResponse codigos);
    }

    interface Presenter{
        void createNewPlayer(User user);
        void readPlayers(User user);
        void activarCodigo(Codigo codigo);
        void guardarNota(Codigo codigo);
        void encryptData(EncryptData encryptData);
        void obtenerNotas(Codigo codigos);
        void eliminarnota(Codigo codigos);
    }

    interface Interactor{
        void performCreatePlayer(User user);
        void performReadPlayers(User user);
        void performActivarCodigo(Codigo codigo);
        void performEncryptData(EncryptData encryptData);
        void performGuardarNota(Codigo codigo);
        void performEliminarNota(Codigo codigo);
        void performObtenerNotas(Codigo codigo);
    }

    interface onOperationListener{
        void onSuccess();
        void onSuccessNota(Codigo codigo);
        void onSuccessObtenerNota(CodigosResponse codigo);
        void onSuccessCreate(User user);
        void onSuccessRead(User user);
        void onSuccessEncrypt(EncryptData encryptData);
        void onFailure();
        void onStart();
        void onEnd();
    }
}
