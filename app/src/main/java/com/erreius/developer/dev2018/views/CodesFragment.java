package com.erreius.developer.dev2018.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.preference.PreferenceManager;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.widget.SearchView;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.erreius.developer.dev2018.MainActivity;
import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.CodigosResponse;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;
import com.erreius.developer.dev2018.R;
import com.erreius.developer.dev2018.interfaces.MainContract;
import com.erreius.developer.dev2018.presenters.MainPresenter;
import com.erreius.developer.dev2018.utils.HtmlManager;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;
import static android.content.Context.CONNECTIVITY_SERVICE;
import static android.content.Context.MODE_PRIVATE;
import static android.content.Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP;
import static com.erreius.developer.dev2018.views.RegistrarP1Fragment.MY_PREFS_NAME;
import static com.facebook.FacebookSdk.getApplicationContext;

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
    //@BindView(R.id.txtContenidoNota) EditText nota;
    private HtmlManager htmlManager = new HtmlManager();
    private static String url_home = "http://appcodigos.erreius.com/Default.aspx?mobile=si";

    private static final String ARG_PARAM1 = "Ingreso";
    private static final String ARG_PARAM2 = "idUser";
    private static final String ARG_PARAM3 = "Password";
    private static final String ARG_PARAM4 = "Name";
    private Integer mIdUser;
    private Integer restoredText;
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;
    private String Password;
    public MainPresenter mPresenter;
    public View mView;
    public Toolbar toolbar;
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
            mParam4 = getArguments().getString(ARG_PARAM4);
        }
        else{
            mParam1 = "";
        }
        mPresenter = new MainPresenter(this);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                if (mWebView.getUrl() != null){
                // Handle the back button event
                if (!isConnected())
                {
                    mWebView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ONLY );
                }

                String url = PreferenceManager.getDefaultSharedPreferences(getContext()).getString("url", "defaultStringIfNothingFound");
                String content = "About.aspx";

                    if (url.contains("About"))
                    {
                        setHasOptionsMenu(true);
                        toolbar.setOverflowIcon(null);
                        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
                    }

                    if (url.contains("Default"))
                    {
                        setHasOptionsMenu(false);
                        toolbar.setOverflowIcon(null);
                        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
                    }

                Boolean flag = mWebView.getUrl().toLowerCase().contains(content.toLowerCase());
                if (flag){
                    if (!mWebView.getUrl().equals(url_home))
                    { 
                        CargarWebView(url_home);
                    }
                }
                else
                {
                    if (!url.contains("https://appcodigos.erreius.com/Login.aspx") &&
                            !url.contains("https://appcodigos.erreius.com/Default.aspx"))
                    {
                        if (!url.equals(url_home)) {
                            CargarWebView(url);
                        }
                    }
                }
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    public boolean isConnected(){
        /*ConnectivityManager cm =
                (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;*/
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService( CONNECTIVITY_SERVICE );
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_codes, container, false);

        ButterKnife.bind(this,mView);


        toolbar = getActivity().findViewById(R.id.toolbar);
        setHasOptionsMenu(false);
        toolbar.setOverflowIcon(null);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

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
            String userSuscriptor =  prefs.getString("idSuscriptor", "");
            if (userSuscriptor != "")
            {
                mIdUser = Integer.valueOf(userSuscriptor);
                Password = prefs.getString("Password", "");
                EncryptData encryptData = new EncryptData();
                encryptData.EUS = userSuscriptor;
                encryptData.EPS = Password;
                restoredText = 22;
                if(isConnected())
                {
                    mPresenter.encryptData(encryptData);
                }
                else{
                    OfflineFragment nextFrag= new OfflineFragment();

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }

            }

        }
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String Name = bundle.getString("Name", "");
            if (Name != "")
            {

                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                View hView =  navigationView.getHeaderView(0);
                TextView correo = (TextView)hView.findViewById(R.id.txtCorreo);
                TextView bienvenido = (TextView)hView.findViewById(R.id.txtBienvenido);
                bienvenido.setVisibility(View.VISIBLE);
                correo.setText(mParam4);
            }
        }

        return mView;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        setRetainInstance(true);

    }

    private static final int SELECTTEXT_MENU_ID = Menu.FIRST;
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) searchItem.getActionView();
        EditText txtSearch = ((EditText)searchView.findViewById(androidx.appcompat.R.id.search_src_text));
        txtSearch.setHintTextColor(Color.GRAY);
        txtSearch.setTextColor(Color.GRAY);
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
    PrintJob printJob;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_print:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //Calling createWebPrintJob()


                    // Creating  PrintManager instance
                    PrintManager printManager = (PrintManager) getContext()
                            .getSystemService(Context.PRINT_SERVICE);

                    //setting the name of job
                    String jobName = getString(R.string.app_name) + " webpage"+ mWebView.getUrl();

                    // Creating  PrintDocumentAdapter instance
                    PrintDocumentAdapter printAdapter = mWebView.createPrintDocumentAdapter(jobName);

                    // Create a print job with name and adapter instance
                    assert printManager != null;
                    printJob = printManager.print(jobName, printAdapter,
                            new PrintAttributes.Builder().build());
                }
                return true;
            case R.id.action_settings:
                showGuardarAlert();

                return true;

            default:
                break;
        }

        return false;
    }
    private  void showGuardarAlert(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.detalle, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setPositiveButton("Guardar Nota", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //mListener.onDialogPositiveClick(mNameEdit.getText().toString(), mPasswordEdit.getText().toString());
                TextView texto = dialogView.findViewById(R.id.txtContenidoNota);
                Codigo codigo = new Codigo();
                codigo.setIdUser(mIdUser);
                String url = PreferenceManager.getDefaultSharedPreferences(getContext()).getString("Lasturl", "defaultStringIfNothingFound");
                codigo.setTituloCodigo(url.substring(54));
                codigo.setNota(texto.getText().toString());
                mPresenter.guardarNota(codigo);
            }
        });

        dialogBuilder.setNegativeButton("Cerrar",null );
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
    private void showInfoAlert()
    {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.offline, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                OfflineFragment nextFrag= new OfflineFragment();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        dialogBuilder.setNegativeButton("Cerrar",null );
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    public void onPrepareOptionsMenu(Menu menu){
        MenuItem id = menu.getItem(0);


        super.onPrepareOptionsMenu(menu);
    }

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
        if ( !isConnected() ) { // loading offline
            if (18 < Build.VERSION.SDK_INT ){
                mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            }
        }
        //mWebView.loadUrl(url);
        CargarWebView(url);
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

        NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();

        nav_Menu.findItem(R.id.nav_activar).setVisible(true);
        nav_Menu.findItem(R.id.nav_notas).setVisible(true);

        if (restoredText == 22)
        {
            String mensaje =  "eus=" + encryptData.EUS + "&eps=" + encryptData.EPS + "&name=a&mobile=si";
            String url = "http://appcodigos.erreius.com/Login.aspx?" + mensaje;
            //mWebView.reload();
            CargarWebView(url);
            Log.println(Log.INFO,"CallUrl",url);
            //setHasOptionsMenu(true);
        }
        else{
            SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
            String tipored = prefs.getString("TipoRed", "F");

            String mensaje =  "eus=" + encryptData.EUS + "&eps=a&name=a&tipored=" + tipored +"&mobile=si";
            String url = "http://appcodigos.erreius.com/Login.aspx?" + mensaje;
            Log.println(Log.INFO,"CallUrl",url);
            //mWebView.reload();
            CargarWebView(url);

        }
    }

    @Override
    public void onGuardarNota(Codigo codigo) {
        Toast.makeText(getContext(),"Nota Guardada!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onObtenerNotas(CodigosResponse codigos) {

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

        mWebView.getSettings().setAppCachePath(getActivity().getCacheDir().getAbsolutePath());
        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.getSettings().setAppCacheEnabled(false);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog dialog = new AlertDialog.Builder(view.getContext()).
                        setTitle("Atención").
                        setMessage(message).
                        create();
                dialog.show();
                result.confirm();
                return true;
            } });
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE); // load online by default
        mWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                //Toast.makeText(getContext(), description, Toast.LENGTH_SHORT).show();
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
                if (url.contains("About"))
                {
                    setHasOptionsMenu(true);
                    toolbar.setOverflowIcon(null);
                    ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
                }

                if (url.contains("Default"))
                {
                    setHasOptionsMenu(false);
                    toolbar.setOverflowIcon(null);
                    ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
                }
                if (!isConnected()){
                    mWebView.stopLoading();
                    showInfoAlert();
                }
                //CargarWebView(url);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                pd.dismiss();
                String content = "DetalleArticulo";
                Boolean flag = url.toLowerCase().contains(content.toLowerCase());
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("Lasturl", url).apply();
                if (!flag){
                    PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("url", url).apply();
                }

                htmlManager.pathSaveFiles = String.valueOf(getContext().getFilesDir());
                htmlManager.webView = mWebView;
                if (url.contains("DetalleArticulo.aspx?id=")) {
                    htmlManager.save(url);
                }
                if (!isConnected()){
                    mWebView.stopLoading();
                }
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String content = "DetalleArticulo";
                Boolean flag = url.toLowerCase().contains(content.toLowerCase());
                if (!flag){
                    PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("url", url).apply();
                }
                if (url.contains("DetalleArticulo")){
                    toolbar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_baseline_note_add_24));
                    ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
                }
                if (url.contains("About"))
                {
                    setHasOptionsMenu(true);
                    toolbar.setOverflowIcon(null);
                    ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
                }

                if (url.contains("Default"))
                {
                    setHasOptionsMenu(false);
                    toolbar.setOverflowIcon(null);
                    ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
                }
                if (!isConnected()){
                    mWebView.stopLoading();
                }
                //CargarWebView(url);
                return false;
            }
        });
        /*Map<String, String> noCacheHeaders = new HashMap<String, String>(2);
        noCacheHeaders.put("Pragma", "cache");
        noCacheHeaders.put("Cache-Control", "cache");*/
        //mWebView.reload();
        if (isConnected()){
            mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
            mWebView.loadUrl(url);
        }
        /*else{
            mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            mWebView.loadUrl(url,noCacheHeaders);
        }*/

        //createPDF("test");

        Log.println(Log.INFO,"CallUrl",url);
        //setHasOptionsMenu(true);
        pd.dismiss();
    }

    private void createPDF (String pdfFilename){

        //path for the PDF file to be generated
        String path = "docs/" + "pdfname";
        File yourFile = new File("score.txt");
        try {
            yourFile.createNewFile(); // if file already exists will do nothing
        } catch (IOException e) {
            e.printStackTrace();
        }
        PdfWriter pdfWriter = null;

        //create a new document
        Document document = new Document();

        try {

            //get Instance of the PDFWriter
            pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(yourFile));

            //document header attributes
            document.addAuthor("betterThanZero");
            document.addCreationDate();
            document.addProducer();
            document.addCreator("MySampleCode.com");
            document.addTitle("Demo for iText XMLWorker");
            document.setPageSize(PageSize.LETTER);

            //open document
            document.open();

            //To convert a HTML file from the filesystem
            //String File_To_Convert = "docs/SamplePDF.html";
            //FileInputStream fis = new FileInputStream(File_To_Convert);

            //URL for HTML page
            URL myWebPage = new URL(mWebView.getUrl());
            InputStreamReader fis = new InputStreamReader(myWebPage.openStream());

            //get the XMLWorkerHelper Instance
            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            //convert to PDF
            worker.parseXHtml(pdfWriter, document, fis);

            //close the document
            document.close();
            //close the writer
            pdfWriter.close();

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}