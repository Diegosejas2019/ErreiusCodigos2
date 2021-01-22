package com.erreius.developer.codigos.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erreius.developer.codigos.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrarPFFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrarPFFragment extends Fragment {


    public RegistrarPFFragment() {
        // Required empty public constructor
    }

    public static RegistrarPFFragment newInstance(String param1, String param2) {
        RegistrarPFFragment fragment = new RegistrarPFFragment();
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
        return inflater.inflate(R.layout.fragment_registrar_p_f, container, false);
    }
}