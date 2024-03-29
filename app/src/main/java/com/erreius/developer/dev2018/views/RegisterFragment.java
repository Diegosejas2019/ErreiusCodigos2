package com.erreius.developer.dev2018.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.CodigosResponse;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;
import com.erreius.developer.dev2018.R;
import com.erreius.developer.dev2018.interfaces.MainContract;
import com.erreius.developer.dev2018.presenters.MainPresenter;
import com.google.android.material.textfield.TextInputEditText;

import static android.content.Context.MODE_PRIVATE;
import static com.erreius.developer.dev2018.views.RegistrarP1Fragment.MY_PREFS_NAME;

public class RegisterFragment extends Fragment implements  MainContract.View{

    @BindView(R.id.progressBar) ProgressBar mProgressbar;
    @BindView(R.id.btnRegister) Button mRegistrar;
    public MainPresenter mPresenter;
    @BindView(R.id.txtNroSuscriptor) TextInputEditText mNroSuscriptor;
    @BindView(R.id.txtPassword) TextInputEditText mPassword;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Context mCtx;

    public RegisterFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mPresenter = new MainPresenter(this);

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                getFragmentManager().beginTransaction().
                        remove(RegisterFragment.this).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.bind(this,view);
        mProgressbar.bringToFront();
        mCtx = view.getContext();

        //getActivity().setTitle("Erreius");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Erreius");

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setOverflowIcon(null);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        mRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suscriptor = mNroSuscriptor.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(!TextUtils.isEmpty(suscriptor) && !TextUtils.isEmpty(password)) {
                    User user = new User(suscriptor,password);
                    mPresenter.readPlayers(user);
                }
            }
        });
        return view;
    }

    @Override
    public void onCreatePlayerSuccessful() {
        Toast.makeText(getContext(),"Ok",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreatePlayerFailure() {
        Toast.makeText(getContext(),"Los datos ingresados son incorrectos.",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProcessStart() {
        mProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onProcessEnd() {
        mProgressbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onUserRead(User user) {

        SharedPreferences.Editor editor = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putInt("idUser", 0);
        editor.putString("idSuscriptor", mNroSuscriptor.getText().toString());
        editor.putString("Password", mPassword.getText().toString());
        editor.apply();

        CodesFragment nextFrag= new CodesFragment();
        Bundle bundle=new Bundle();
        bundle.putString("idUser", mNroSuscriptor.getText().toString());
        bundle.putString("Password", mPassword.getText().toString());
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