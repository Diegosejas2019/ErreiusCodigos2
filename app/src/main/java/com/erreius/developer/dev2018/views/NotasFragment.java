package com.erreius.developer.dev2018.views;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.CodigosResponse;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;
import com.erreius.developer.dev2018.R;
import com.erreius.developer.dev2018.interfaces.MainContract;
import com.erreius.developer.dev2018.presenters.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.erreius.developer.dev2018.views.RegistrarP1Fragment.MY_PREFS_NAME;

public class NotasFragment extends Fragment implements  MainContract.View{

    public MainPresenter mPresenter;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    RecyclerAdapter mRecyclerAdapter;
    public NotasFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        mPresenter = new MainPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_notas, container, false);
        View view = inflater.inflate(R.layout.fragment_notas, container, false);

        ButterKnife.bind(this,view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setOverflowIcon(null);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        Integer restoredText = prefs.getInt("idUser", 0);
        if (restoredText != 0) {

            Integer mIdUser = prefs.getInt("idUser", 0);
            Codigo codigo = new Codigo();
            codigo.setIdUser(mIdUser);

            CallNotas(codigo);
        }
        else{
            String userSuscriptor =  prefs.getString("idSuscriptor", "");
            if (userSuscriptor != "")
            {
                Integer mIdUser = Integer.valueOf(userSuscriptor);
                Codigo codigo = new Codigo();
                codigo.setIdUser(mIdUser);

                CallNotas(codigo);
            }
        }

        return view;
    }

    public void CallNotas(Codigo codigo) {
        mPresenter.obtenerNotas(codigo);
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

    }

    @Override
    public void onUserCreate(User user) {

    }

    @Override
    public void onEncryptData(EncryptData encryptData) {

    }

    @Override
    public void onGuardarNota(Codigo codigo) {
        mRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onObtenerNotas(CodigosResponse codigos) {
        List<CodigosResponse> list = new ArrayList<>();
        list.add(codigos);
        mRecyclerAdapter = new RecyclerAdapter(getContext(),list,this);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }
}