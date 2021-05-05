package com.erreius.developer.dev2018.views;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.CodigosResponse;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;
import com.erreius.developer.dev2018.R;
import com.erreius.developer.dev2018.interfaces.MainContract;
import com.erreius.developer.dev2018.presenters.MainPresenter;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;

import static com.erreius.developer.dev2018.views.RegistrarP1Fragment.MY_PREFS_NAME;

public class LoginView extends AppCompatActivity implements MainContract.View{
    @BindView(R.id.buttonSuscriptor) Button btnSuscriptor;
    @BindView(R.id.btnProbar) Button btnProbar;
    @BindView(R.id.btnCompreCodigo) Button btnCompreCodigo;

    private AppUpdateManager mAppUpdateManager;
    private static final int RC_APP_UPDATE = 11;
    private InstallStateUpdatedListener mInstallStateUpdatedListener;
    public MainPresenter mPresenter;
    private Integer mIdUser;
    private String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        ButterKnife.bind(this);

        mPresenter = new MainPresenter(this);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        Integer restoredText = prefs.getInt("idUserRedsocial", 0);
        //Integer restoredText = 1;
        if (restoredText != 0) {

            mIdUser = prefs.getInt("idUserRedsocial", 0);
            //mIdUser = 12572;
            mPassword = prefs.getString("Password", "");
            User user = new User();
            user.setIdUser(mIdUser);
            user.setPassword(mPassword);

            mPresenter.readPlayers(user);
        }
        else{
            String dUser = prefs.getString("idSuscriptor", "");
            mPassword = prefs.getString("Password", "");
            if (!dUser.isEmpty()){
                User user = new User();
                user.setUserName(dUser);
                user.setPassword(mPassword);

                mPresenter.readPlayers(user);
            }
        }
        btnSuscriptor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginView.this, MasterView.class);
                intent.putExtra("Opcion","Suscriptor");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        btnProbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginView.this, MasterView.class);
                intent.putExtra("Opcion","Login");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        btnCompreCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginView.this, MasterView.class);
                intent.putExtra("Opcion","Login");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }


    @Override
    public void onCreatePlayerSuccessful() {

    }

    @Override
    public void onCreatePlayerFailure() {

    }

    @Override
    public void onProcessStart() {

    }

    @Override
    public void onProcessEnd() {

    }

    @Override
    public void onUserRead(User user) {
        Intent intent = new Intent(LoginView.this, MasterView.class);
        if (user.getUrlFoto() != null)
        {
            intent.putExtra("UrlFoto",user.getUrlFoto());
            intent.putExtra("Name",user.getFullUserName());
        }
        intent.putExtra("Opcion","Logueado");
        Log.println(Log.INFO,"Opcion","Log");
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void onUserCreate(User user) {

    }

    @Override
    public void onEncryptData(EncryptData encryptData) {

    }

    @Override
    public void onGuardarNota(Codigo codigo) {

    }

    @Override
    public void onObtenerNotas(CodigosResponse codigos) {

    }
}