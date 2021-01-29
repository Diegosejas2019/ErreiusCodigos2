package com.erreius.developer.codigos.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.erreius.developer.codigos.Model.User;
import com.erreius.developer.codigos.R;


public class RegistrarP2Fragment extends Fragment {

    @BindView(R.id.btnContinuar) Button mContinuar;
    @BindView(R.id.txtEmail) EditText mEmail;
    @BindView(R.id.txtNombre) EditText mNombre;
    @BindView(R.id.txtTelefono) EditText mTelefono;

    public RegistrarP2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrar_p2, container, false);

        ButterKnife.bind(this,view);

        mContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View focusView = null;
                boolean cancel = false;

                if (TextUtils.isEmpty(mTelefono.getText())){
                    mTelefono.setError("Campo requerido");
                    focusView = mTelefono;
                    cancel = true;
                }

                if (TextUtils.isEmpty(mNombre.getText())){
                    mNombre.setError("Campo requerido");
                    focusView = mNombre;
                    cancel = true;
                }

                if (TextUtils.isEmpty(mEmail.getText())){
                    mEmail.setError("Campo requerido");
                    focusView = mEmail;
                    cancel = true;
                }
                else {
                    if (!isValidEmail(mEmail.getText())){
                        mEmail.setError("Formato invalido");
                        focusView = mEmail;
                        cancel = true;
                    }
                }

                if (cancel) {
                    focusView.requestFocus();
                } else {

                    String email = mEmail.getText().toString().trim();
                    String nombre = mNombre.getText().toString().trim();
                    String telefono = mTelefono.getText().toString().trim();

                    RegistrarP3Fragment nextFrag= new RegistrarP3Fragment();
                    Bundle bundle=new Bundle();
                    bundle.putString("email", email);
                    bundle.putString("nombre", nombre);
                    bundle.putString("telefono", telefono);
                    nextFrag.setArguments(bundle);

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
        return view;
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}