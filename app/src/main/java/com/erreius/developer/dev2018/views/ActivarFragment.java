package com.erreius.developer.dev2018.views;

import android.content.SharedPreferences;
import android.graphics.Color;
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
import android.widget.TextView;

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


public class ActivarFragment extends Fragment implements  MainContract.View{
    @BindView(R.id.txtEncontrarCodigo) TextView mEncontrarCodigo;
    @BindView(R.id.btnActivar) Button mActivar;
    @BindView(R.id.txtCodigo) TextInputEditText mCodigo;
    @BindView(R.id.progressBar) ProgressBar mProgressbar;
    public MainPresenter mPresenter;


    public ActivarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenter(this);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                getFragmentManager().beginTransaction().
                        remove(ActivarFragment.this).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activar, container, false);

        ButterKnife.bind(this,view);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Erreius");

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setOverflowIcon(null);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        mProgressbar.bringToFront();
        mEncontrarCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EncontrarCodigoFragment nextFrag= new EncontrarCodigoFragment();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        mActivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View focusView = null;
                if (TextUtils.isEmpty(mCodigo.getText())){
                    mCodigo.setError("Campo requerido");
                    focusView = mCodigo;
                    focusView.requestFocus();
                } else {
                    String item = mCodigo.getText().toString().trim();
                    SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                    Integer idUser = prefs.getInt("idUserRedsocial", 0);
                    Codigo codigo = new Codigo();
                    codigo.setCodigo(item);
                    codigo.setIdUser(idUser);

                    mPresenter.activarCodigo(codigo);
                }
            }
        });

        return view;
    }

    @Override
    public void onCreatePlayerSuccessful() {
        CodesFragment nextFrag= new CodesFragment();

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
        mProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onProcessEnd() {
        mProgressbar.setVisibility(View.GONE);
    }

    @Override
    public void onUserRead(User user) {

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
