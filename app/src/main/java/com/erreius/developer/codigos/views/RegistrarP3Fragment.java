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
import android.widget.ProgressBar;

import com.erreius.developer.codigos.Model.User;
import com.erreius.developer.codigos.R;
import com.erreius.developer.codigos.interfaces.MainContract;
import com.erreius.developer.codigos.presenters.MainPresenter;
import com.google.android.material.textfield.TextInputEditText;


public class RegistrarP3Fragment extends Fragment implements  MainContract.View{
    public MainPresenter mPresenter;
    @BindView(R.id.btnRegister) Button mRegister;
    @BindView(R.id.txtContraseña) TextInputEditText mContraseña;
    @BindView(R.id.txtVerificarContraseña) TextInputEditText mReContraseña;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    private static final String ARG_PARAM1 = "email";
    private static final String ARG_PARAM2 = "nombre";
    private static final String ARG_PARAM3 = "telefono";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;

    public RegistrarP3Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
        mPresenter = new MainPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrar_p3, container, false);

        ButterKnife.bind(this,view);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View focusView = null;
                boolean cancel = false;

                if (TextUtils.isEmpty(mReContraseña.getText())){
                    mReContraseña.setError("Campo requerido");
                    focusView = mReContraseña;
                    cancel = true;
                }

                if (TextUtils.isEmpty(mContraseña.getText())){
                    mContraseña.setError("Campo requerido");
                    focusView = mContraseña;
                    cancel = true;
                }
                else{
                    if (!mContraseña.getText().toString().equals(mReContraseña.getText().toString()))
                    {
                        mReContraseña.setError("Las contraseñas deben coincidir");
                        focusView = mReContraseña;
                        cancel = true;
                    }
                }
                if (cancel) {
                    focusView.requestFocus();
                } else {
                    String contraseña = mContraseña.getText().toString().trim();

                    User user = new User();
                    user.UserName = mParam2;
                    user.Email = mParam1;
                    user.Telefono = mParam3;
                    user.Password = contraseña;

                    mPresenter.createNewPlayer(user);
                }
            }
        });
        return view;
    }

    @Override
    public void onCreatePlayerSuccessful() {
        RegistrarPFFragment nextFrag= new RegistrarPFFragment();

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onCreatePlayerFailure() {

    }

    @Override
    public void onProcessStart() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onProcessEnd() {
        mProgressBar.setVisibility(View.GONE);
    }
}