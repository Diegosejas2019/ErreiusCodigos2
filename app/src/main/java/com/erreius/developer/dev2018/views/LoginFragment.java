package com.erreius.developer.dev2018.views;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.Toast;

import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.CodigosResponse;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;
import com.erreius.developer.dev2018.R;
import com.erreius.developer.dev2018.interfaces.MainContract;
import com.erreius.developer.dev2018.presenters.MainPresenter;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static android.content.Context.MODE_PRIVATE;
import static com.erreius.developer.dev2018.views.RegistrarP1Fragment.MY_PREFS_NAME;
import static com.facebook.FacebookSdk.getApplicationContext;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class LoginFragment extends Fragment implements  MainContract.View ,GoogleApiClient.OnConnectionFailedListener{
    private static final String TAG = "info hash";
    @BindView(R.id.btnContinuarCorreo) Button mCompreCodigo;
    @BindView(R.id.btnGoogle) Button mGoggle;
    @BindView(R.id.btnFacebook) Button mFaceebook;
    public User mUser;
    public CallbackManager mCallbackManager;
    public MainPresenter mPresenter;
    private Context mCtx;
    //Google Login
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInOptions gso;
    private GoogleApiClient mGoogleApiClient;
    private int SIGN_IN = 30;
    public static View mview;
    static Activity activity = new Activity();
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(getApplicationContext());
        activity = getActivity();
        mPresenter = new MainPresenter(this);
        setHasOptionsMenu(false);

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                Intent intent = new Intent(getActivity(), LoginView.class);
                //intent.putExtra("Opcion","Suscriptor");
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    public static void onBackPressed(){
        FragmentActivity activity = (FragmentActivity)mview.getContext();
        Intent intent = new Intent(activity, LoginView.class);
        //intent.putExtra("Opcion","Suscriptor");
        activity.startActivity(intent);
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void onPrepareOptionsMenu(Menu menu){
        super.onPrepareOptionsMenu(menu);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        mview = view;
        ButterKnife.bind(this,view);
        mCtx = view.getContext();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Erreius");
        FacebookSdk.sdkInitialize(getApplicationContext());
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setOverflowIcon(null);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        setHasOptionsMenu(false);
        mCallbackManager = CallbackManager.Factory.create();

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(mCtx)
                .enableAutoManage(getActivity() /* FragmentActivity */, this/* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        mCompreCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarP1Fragment nextFrag= new RegistrarP1Fragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        mGoggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, SIGN_IN);
            }
        });

        //mFaceebook.setFragment(this);
        mFaceebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().setLoginBehavior(LoginBehavior.WEB_ONLY);
                LoginManager.getInstance().logOut();
                mCallbackManager = CallbackManager.Factory.create();
                LoginManager.getInstance().logInWithReadPermissions(LoginFragment.this, Arrays.asList("email", "public_profile"));

                LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject json, GraphResponse response) {
                                // Application code
                                if (response.getError() != null) {
                                    Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                                } else {

                                    String jsonresult = String.valueOf(json);

                                    String fbUserId = json.optString("id");
                                    String fbUserFirstName = json.optString("name");
                                    String fbUserEmail = json.optString("email");
                                    String fbUserProfilePics = "https://graph.facebook.com/" + fbUserId + "/picture?type=large";
                                    mUser = new User();
                                    mUser.setFullUserName(fbUserFirstName);
                                    mUser.setEmail(fbUserEmail);
                                    mUser.setPassword(fbUserId);
                                    mUser.setUrlFoto(fbUserProfilePics);
                                    mUser.setTelefono("999999");
                                    mUser.setUserName(fbUserFirstName);
                                    mUser.setTipoRed("FB");

                                    mPresenter.createNewPlayer(mUser);

                                }
                                Log.v("FaceBook Response :", response.toString());
                            }
                        });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,name,email");
                        request.setParameters(parameters);
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {
                        Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        printHashKey(getContext());
        return view;
    }

    public void printHashKey(Context pContext) {
        try {
            PackageInfo info = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), PackageManager.GET_SIGNATURES);
            for (android.content.pm.Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i(TAG, "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "printHashKey()", e);
        } catch (Exception e) {
            Log.e(TAG, "printHashKey()", e);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mGoogleApiClient.stopAutoManage(getActivity());
        mGoogleApiClient.disconnect();
    }

    @Override
    public void onResume() {
        super.onResume();
        setHasOptionsMenu(false);
    }
    @Override
    public void onStop() {
        super.onStop();
        setHasOptionsMenu(false);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            //get user's email
            String mEmail = acct.getEmail();
            String mFamilyName = acct.getFamilyName();
            //get user's full name
            String mFullName = acct.getDisplayName();

            String gPlusID = acct.getId();
            Uri photo = acct.getPhotoUrl();

            mUser = new User();
            mUser.setFullUserName(mFullName);
            mUser.setEmail(mEmail);
            mUser.setPassword(gPlusID);
            mUser.setUrlFoto(photo.toString());
            mUser.setTelefono("999999");
            mUser.setUserName(mFamilyName);
            mUser.setTipoRed("G");

            mPresenter.createNewPlayer(mUser);

        }
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
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putInt("idUser", user.getIdUser());
        editor.putInt("idUserRedsocial", user.getIdUserRedSocial());
        editor.putString("Password", user.getPassword());
        editor.apply();

        Log.println(Log.INFO,"Opcion", String.valueOf(user.getIdUserRedSocial()));

        CodesFragment nextFrag= new CodesFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onEncryptData(EncryptData encryptData) {

    }

    @Override
    public void onGuardarNota(Codigo codigo) {

    }

    @Override
    public void onObtenerNotas(CodigosResponse codigos) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}