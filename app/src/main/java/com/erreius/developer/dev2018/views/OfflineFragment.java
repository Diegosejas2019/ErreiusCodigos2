package com.erreius.developer.dev2018.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.erreius.developer.dev2018.R;
import com.erreius.developer.dev2018.utils.BuildMenu;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;


public class OfflineFragment extends Fragment {

    WebView wv = null;
    public static OfflineFragment newInstance(String param1, String param2) {
        OfflineFragment fragment = new OfflineFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offline, container, false);

        wv = (WebView) view.findViewById(R.id.webview);
        System.out.println("---------------CREATE MAIN--------------");
        wv.getSettings().setJavaScriptEnabled(true);

        AndroidTreeView tView = new AndroidTreeView(getContext(), BuildMenu.getMenu(wv, String.valueOf(getContext().getFilesDir()),getActivity()));
        LinearLayout parentLayout = (LinearLayout) view.findViewById(R.id.parent);
        parentLayout.addView(tView.getView());
        return view;
    }
}