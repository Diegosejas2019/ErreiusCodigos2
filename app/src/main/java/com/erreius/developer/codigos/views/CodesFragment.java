package com.erreius.developer.codigos.views;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import com.erreius.developer.codigos.R;


public class CodesFragment extends Fragment  {
    @BindView(R.id.webView) WebView mWebView;
    private static String url_home = "http://appcodigos.erreius.com/Default.aspx";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CodesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CodesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CodesFragment newInstance(String param1, String param2) {
        CodesFragment fragment = new CodesFragment();
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

        mWebView.setWebViewClient(new MyWebViewClient());

        //mWebView.loadUrl("http://www.bcra.gob.ar/BCRAyVos/Situacion_Crediticia.asp");
        String mensaje =  "eus=bvhxROGO7QtNfbVj&eps=a&name=a&tipored=F&mobile=si";
        String url = "http://appcodigos.erreius.com/Login.aspx?" + mensaje;
        //String url = "http://appcodigos.erreius.com/Default.aspx?mobile=si";
        //mWebView.loadUrl(url);
        CargarWebView(url);

        setHasOptionsMenu(true);

        return view;
    }

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