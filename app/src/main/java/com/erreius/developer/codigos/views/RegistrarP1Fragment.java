package com.erreius.developer.codigos.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.erreius.developer.codigos.Model.User;
import com.erreius.developer.codigos.R;
import com.erreius.developer.codigos.interfaces.MainContract;
import com.erreius.developer.codigos.presenters.MainPresenter;


public class RegistrarP1Fragment extends Fragment implements  MainContract.View {
    public MainPresenter mPresenter;
    @BindView(R.id.btnRegister) Button mRegistrar;
    @BindView(R.id.btnContinuar) Button mContinuar;
    @BindView(R.id.txtNroSuscriptor) EditText mNroSuscriptor;
    @BindView(R.id.txtContraseña) EditText mContraseña;
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrar_p1, container, false);

        ButterKnife.bind(this,view);

        mContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suscriptor = mNroSuscriptor.getText().toString().trim();
                String password = mContraseña.getText().toString().trim();

                if(!TextUtils.isEmpty(suscriptor) && !TextUtils.isEmpty(password)) {
                    User user = new User(suscriptor,password);
                    mPresenter.createNewPlayer(user);
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

    }

    @Override
    public void onProcessStart() {

    }

    @Override
    public void onProcessEnd() {

    }
}