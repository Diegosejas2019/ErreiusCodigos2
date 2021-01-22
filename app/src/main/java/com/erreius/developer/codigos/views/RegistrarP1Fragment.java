package com.erreius.developer.codigos.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erreius.developer.codigos.R;


public class RegistrarP1Fragment extends Fragment {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registrar_p1, container, false);
    }
}