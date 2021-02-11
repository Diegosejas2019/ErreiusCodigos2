package com.erreius.developer.dev2018.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.erreius.developer.dev2018.R;

public class EncontrarCodigoFragment extends Fragment {
    @BindView(R.id.btnContactanos) Button mContactanos;

    public EncontrarCodigoFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_encontrar_codigo, container, false);

        ButterKnife.bind(this,view);

        mContactanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivarFragment nextFrag= new ActivarFragment();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}