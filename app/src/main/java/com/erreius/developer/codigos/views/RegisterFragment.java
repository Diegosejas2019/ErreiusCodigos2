package com.erreius.developer.codigos.views;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.erreius.developer.codigos.ApiUtils;
import com.erreius.developer.codigos.Model.User;
import com.erreius.developer.codigos.R;
import com.erreius.developer.codigos.interactor.UserInteractor;
import com.erreius.developer.codigos.interfaces.APIService;
import com.erreius.developer.codigos.interfaces.MainContract;
import com.erreius.developer.codigos.presenters.MainPresenter;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment implements  MainContract.View{

    @BindView(R.id.progressBar) ProgressBar mProgressbar;
    @BindView(R.id.btnRegister) Button mRegistrar;
    public MainPresenter mPresenter;
    @BindView(R.id.txtNroSuscriptor) EditText mNroSuscriptor;
    @BindView(R.id.txtPassword) EditText mPassword;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Context mCtx;

    public RegisterFragment() {

    }

    public static RegisterFragment newInstance(String param1, String param2, Context mCtx) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mPresenter = new MainPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.bind(this,view);

        mCtx = view.getContext();
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
        Toast.makeText(getContext(),"fallo",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProcessStart() {
        mProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onProcessEnd() {
        mProgressbar.setVisibility(View.INVISIBLE);
    }
}