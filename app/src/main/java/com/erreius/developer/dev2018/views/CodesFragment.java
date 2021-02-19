package com.erreius.developer.dev2018.views;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;
import com.erreius.developer.dev2018.R;
import com.erreius.developer.dev2018.interfaces.MainContract;
import com.erreius.developer.dev2018.presenters.MainPresenter;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;
import static com.erreius.developer.dev2018.views.RegistrarP1Fragment.MY_PREFS_NAME;

class WebAppInterface
{
    @JavascriptInterface
    public void callback(String value)
    {
        Log.v(TAG, "SELECTION:" + value);
    }
}

public class CodesFragment extends Fragment implements  MainContract.View {
    @BindView(R.id.webView) WebView mWebView;
    private static String url_home = "http://appcodigos.erreius.com/Default.aspx";

    private static final String ARG_PARAM1 = "Ingreso";
    private static final String ARG_PARAM2 = "idUser";
    private static final String ARG_PARAM3 = "Password";
    private Integer mIdUser;
    private Integer restoredText;
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String Password;
    public MainPresenter mPresenter;

    public CodesFragment() {
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
        else{
            mParam1 = "";
        }
        mPresenter = new MainPresenter(this);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                if (!isConnected())
                {
                    mWebView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
                }

                String url = PreferenceManager.getDefaultSharedPreferences(getContext()).getString("url", "defaultStringIfNothingFound");
                String content = "About.aspx";

                Boolean flag = mWebView.getUrl().toLowerCase().contains(content.toLowerCase());
                if (flag){
                    if (!mWebView.getUrl().equals(url_home))
                    { 
                        mWebView.loadUrl(url_home);
                    }
                }
                else
                {
                    if (!url.contains("https://appcodigos.erreius.com/Login.aspx") &&
                            !url.contains("https://appcodigos.erreius.com/Default.aspx"))
                    {
                        if (!url.equals(url_home)) {
                            mWebView.loadUrl(url);
                        }
                    }
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    public boolean isConnected(){
        ConnectivityManager cm =
                (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_codes, container, false);

        ButterKnife.bind(this,view);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        mWebView.addJavascriptInterface(new WebAppInterface(), "js");
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.evaluateJavascript("(function(){return window.getSelection().toString()})()",
                new ValueCallback<String>()
                {
                    @Override
                    public void onReceiveValue(String value)
                    {
                        Log.v(TAG, "SELECTION:" + value);
                    }
                });

        SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        restoredText = prefs.getInt("idUser", 0);
        if (restoredText != 0) {

            mIdUser = prefs.getInt("idUser", 0);
            Password = prefs.getString("Password", "");
            EncryptData encryptData = new EncryptData();
            encryptData.EUS = mIdUser.toString();
            encryptData.EPS = Password.toString();

            mPresenter.encryptData(encryptData);
        }
        else{
            if(mParam2 != null){
                EncryptData encryptData = new EncryptData();
                encryptData.EUS = mParam2;
                encryptData.EPS = mParam3;
                restoredText = 22;
                mPresenter.encryptData(encryptData);
            }
            else{
                if(mParam1.equals("Menu")){
                    if (restoredText == 0)
                    {
                        Intent mainIntent = new Intent(getContext(),
                                LoginView.class);
                        startActivity(mainIntent);
                        getActivity().finish();
                        getActivity().overridePendingTransition(R.anim.nav_default_enter_anim,R.anim.nav_default_exit_anim);
                        return null;
                    }
                }
            }
        }
        return view;
    }

    private static final int SELECTTEXT_MENU_ID = Menu.FIRST;
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    searchItem.collapseActionView();
                    searchView.setQuery("", false);
                }
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                showResults(query);
                searchView.setQuery("", false);
                searchView.clearFocus();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        searchView.setSearchableInfo( searchManager.getSearchableInfo(getActivity().getComponentName()) );
        searchView.setQueryHint("Buscar..");
       // menu.add(0, SELECTTEXT_MENU_ID, 0, "Select Text");
    }

    public void onPrepareOptionsMenu(Menu menu){
        super.onPrepareOptionsMenu(menu);
    }

//    public boolean onOptionsItemSelected(MenuItem item){
//        switch(item.getItemId()){
//            case SELECTTEXT_MENU_ID:
//                SelectText();
//                return true;
//        }
//        super.onOptionsItemSelected(item);
//        return true;
//    }

    public void SelectText(){
        try{
            KeyEvent shiftPressEvent =
                    new KeyEvent(0, 0, KeyEvent.ACTION_DOWN,
                            KeyEvent.KEYCODE_SHIFT_LEFT, 0, 0);
            shiftPressEvent.dispatch(mWebView);
        }catch(Exception e){
            throw new AssertionError(e);
        }
    }

    private void showResults(String query) {
        String url = PreferenceManager.getDefaultSharedPreferences(getContext()).getString("url", "defaultStringIfNothingFound");
        Integer indice = url.indexOf("&buscador");
        if (indice > -1)
        {
            url = url.substring(0, indice);
        }
        url = url + "&buscador=" + query;
        mWebView.loadUrl(url);
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
    public void onEncryptData(EncryptData encryptData) {
        if (restoredText == 22)
        {
            String mensaje =  "eus=" + encryptData.EUS + "&eps=" + encryptData.EPS + "&name=a&mobile=si";
            String url = "http://appcodigos.erreius.com/Login.aspx?" + mensaje;

            CargarWebView(url);
            setHasOptionsMenu(true);
        }
        else{
            String mensaje =  "eus=" + encryptData.EUS + "&eps=a&name=a&tipored=F&mobile=si";
            String url = "http://appcodigos.erreius.com/Login.aspx?" + mensaje;

            CargarWebView(url);
            setHasOptionsMenu(true);
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //mProgressBar.setVisibility(View.VISIBLE);
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            //mProgressBar.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

    private void CargarWebView(String url) {
        final ProgressDialog pd = ProgressDialog.show(getContext(), "", "Cargando..", true);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getContext(), description, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon)
            {
                pd.show();
                String content = "DetalleArticulo";
                Boolean flag = url.toLowerCase().contains(content.toLowerCase());
                if (!flag){
                    PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("url", url).apply();
                }
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                pd.dismiss();
                String content = "DetalleArticulo";
                Boolean flag = url.toLowerCase().contains(content.toLowerCase());
                if (!flag){
                    PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("url", url).apply();
                }
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String content = "DetalleArticulo";
                Boolean flag = url.toLowerCase().contains(content.toLowerCase());
                if (!flag){
                    PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("url", url).apply();
                }
                return false;
            }
        });

        if (!isConnected())
        {
            mWebView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
        }
        mWebView.loadUrl(url);
    }
}