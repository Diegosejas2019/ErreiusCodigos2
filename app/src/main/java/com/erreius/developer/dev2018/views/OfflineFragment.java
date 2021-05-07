package com.erreius.developer.dev2018.views;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import butterknife.BindView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.erreius.developer.dev2018.R;
import com.erreius.developer.dev2018.utils.BuildMenu;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import static android.content.Context.CONNECTIVITY_SERVICE;


public class OfflineFragment extends Fragment {
    public int mCurCheckPosition;
    @BindView(R.id.webView) WebView mWebView;
    public static OfflineFragment newInstance(String param1, String param2) {
        OfflineFragment fragment = new OfflineFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                if (isConnected()){
                    CodesFragment nextFrag= new CodesFragment();

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    public boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService( CONNECTIVITY_SERVICE );
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("curChoice", mCurCheckPosition);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offline, container, false);

        mWebView = (WebView) view.findViewById(R.id.webview);
        System.out.println("---------------CREATE MAIN--------------");
        mWebView.getSettings().setJavaScriptEnabled(true);

        AndroidTreeView tView = new AndroidTreeView(getContext(), BuildMenu.getMenu(mWebView, String.valueOf(getContext().getFilesDir()),getActivity(),getActivity().getSupportFragmentManager()));
        LinearLayout parentLayout = (LinearLayout) view.findViewById(R.id.parent);
        parentLayout.addView(tView.getView());
        return view;
    }
}