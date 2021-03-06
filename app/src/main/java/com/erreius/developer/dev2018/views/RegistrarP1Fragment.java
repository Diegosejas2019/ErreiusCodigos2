package com.erreius.developer.dev2018.views;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.CodigosResponse;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;
import com.erreius.developer.dev2018.R;
import com.erreius.developer.dev2018.interfaces.MainContract;
import com.erreius.developer.dev2018.presenters.MainPresenter;

import static android.content.Context.MODE_PRIVATE;


public class RegistrarP1Fragment extends Fragment implements  MainContract.View {
    public MainPresenter mPresenter;
    @BindView(R.id.btnRegister) Button mRegistrar;
    @BindView(R.id.btnContinuar) Button mContinuar;
    @BindView(R.id.txtNroSuscriptor) EditText mEmail;
    @BindView(R.id.txtContraseña) EditText mContraseña;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public RegistrarP1Fragment() {
        // Required empty public constructor
    }

    public static RegistrarP1Fragment newInstance(String param1, String param2) {
        RegistrarP1Fragment fragment = new RegistrarP1Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        mPresenter = new MainPresenter(this);

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                LoginFragment nextFrag= new LoginFragment();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrar_p1, container, false);

        ButterKnife.bind(this,view);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Erreius");

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setOverflowIcon(null);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        mProgressBar.bringToFront();
        mContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mContraseña.getText().toString().trim();

                View focusView = null;
                boolean cancel = false;

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Campo requerido");
                    focusView = mEmail;
                    cancel = true;
                }

                if (TextUtils.isEmpty(password)){
                    mContraseña.setError("Campo requerido");
                    focusView = mContraseña;
                    cancel = true;
                }

                if (cancel) {
                    focusView.requestFocus();
                } else {

                    User user = new User();
                    user.Email = email;
                    user.Password = password;

                    mPresenter.readPlayers(user);
                }
            }
        });

        mRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarP2Fragment nextFrag= new RegistrarP2Fragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    @Override
    public void onCreatePlayerSuccessful() {
    }

    @Override
    public void onCreatePlayerFailure() {
        Toast.makeText(getContext(),"Los datos ingresados son incorrectos.",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProcessStart() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onProcessEnd() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onUserRead(User user) {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putInt("idUser", user.getIdUser());
        editor.putInt("idUserRedsocial", user.getIdUserRedSocial());
        editor.putString("Password", mContraseña.getText().toString());
        editor.apply();

        Log.println(Log.INFO,"Opcion", String.valueOf(user.getIdUserRedSocial()));

        //((MasterView)getActivity()).setName(user.getFullUserName());

        CodesFragment nextFrag= new CodesFragment();
        Bundle bundle=new Bundle();
        bundle.putString("Name", user.getFullUserName());
        nextFrag.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                .addToBackStack(null)
                .commit();
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