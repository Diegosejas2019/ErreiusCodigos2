package com.erreius.developer.dev2018.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.erreius.developer.dev2018.R;
import com.erreius.developer.dev2018.utils.RoundedCornersTransform;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.squareup.picasso.Picasso;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.erreius.developer.dev2018.views.RegistrarP1Fragment.MY_PREFS_NAME;

public class MasterView extends AppCompatActivity {
    private static final String TAG = "info hash";
    private AppBarConfiguration mAppBarConfiguration;
    private AppUpdateManager mAppUpdateManager;
    private static final int RC_APP_UPDATE = 11;
    private InstallStateUpdatedListener mInstallStateUpdatedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        /*FirebaseMessaging.getInstance().subscribeToTopic("news").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                //Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_LONG).show();
            }
        });*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setBackgroundColor(Color.WHITE);
        toolbar.setOverflowIcon(null);
        setSupportActionBar(toolbar);

        checkUpdate();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        if (savedInstanceState == null) {
            /*
            return;
        }
        else{*/
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_home, R.id.nav_registrarme, R.id.nav_activar,R.id.nav_notas, R.id.nav_terminos, R.id.nav_contactanos)
                    .setDrawerLayout(drawer)
                    .build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment nextFrag= new Fragment();
                switch (menuItem.getItemId()) {
                    case R.id.nav_cerrar:

                        SharedPreferences spreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor spreferencesEditor = spreferences.edit();
                        spreferencesEditor.clear();
                        spreferencesEditor.commit();

                        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                        spreferencesEditor = prefs.edit();
                        spreferencesEditor.clear();
                        spreferencesEditor.commit();

                        Intent mainIntent = new Intent(MasterView.this,
                                LoginView.class);
                        startActivity(mainIntent);
                        MasterView.this.finish();
                        overridePendingTransition(R.anim.nav_default_enter_anim,R.anim.nav_default_exit_anim);
                        break;
                    case R.id.nav_activar:
                        nextFrag= new ActivarFragment();
                        break;
                    case R.id.nav_notas:
                        nextFrag= new NotasFragment();
                        break;
                    case R.id.nav_contactanos:
                        nextFrag= new ContactFragment();
                        break;
                    case R.id.nav_home:
                        nextFrag= new CodesFragment();
                        Bundle bundle=new Bundle();
                        bundle.putString("Ingreso", "Menu");
                        nextFrag.setArguments(bundle);
                        break;
                    case R.id.nav_terminos:
                        nextFrag= new TermsAndConditionsFragment();
                        break;
                    case R.id.nav_registrarme:
                        nextFrag= new OfflineFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
                drawer.closeDrawers();
                return true;
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new
         BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 Intent browserIntent = new Intent();

                 switch (item.getItemId()){
                     case R.id.navigation_store:
                         browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tiendaonline.errepar.com/18-ciencias-juridicas"));
                         startActivity(browserIntent);
                         return true;
                     case R.id.navigation_user:
                         browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.erreius.com/Suscripciones"));
                         startActivity(browserIntent);
                         return true;
                     case R.id.navigation_bell:
                         browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.erreius.com/"));
                         startActivity(browserIntent);
                         return true;
                 }
                 return true;
             }
         });
            Bundle b = getIntent().getExtras();
            if(b != null){
                String Opcion = b.getString("Opcion","");
                String UrlFoto = b.getString("UrlFoto","");
                String Name = b.getString("Name","");
                Fragment nextFrag= new Fragment();
                Log.println(Log.INFO,"Opcion",Opcion);
                if (Opcion.equals("Suscriptor"))
                {
                    nextFrag = new RegisterFragment();
                    Log.println(Log.INFO,"Login","Register");
                }
                else{
                    if (Opcion.equals("Logueado"))
                    {
                        nextFrag = new CodesFragment();
                        Log.println(Log.INFO,"Login","Codes");
                    }
                    else{
                        nextFrag = new LoginFragment();
                        Log.println(Log.INFO,"Login","Login");
                    }
                }

                if (!UrlFoto.equals(""))
                {
                    new GraphRequest(
                            AccessToken.getCurrentAccessToken(),
                            "/10215768115819638",
                            null,
                            HttpMethod.GET,
                            new GraphRequest.Callback() {
                                public void onCompleted(GraphResponse response) {
                                    /* handle the result */
                                    String algo= "a";
                                }
                            }
                    ).executeAsync();

                    View hView =  navigationView.getHeaderView(0);
                    TextView correo = (TextView)hView.findViewById(R.id.txtCorreo);
                    TextView bienvenido = (TextView)hView.findViewById(R.id.txtBienvenido);
                    bienvenido.setVisibility(View.VISIBLE);
                    correo.setText(Name);
                    ImageView nav_user = (ImageView)hView.findViewById(R.id.imageView);
                    Picasso.with(MasterView.this)
                            .load(UrlFoto)
                            //.resize(1400, 850)
                            .transform(new RoundedCornersTransform())
                            .into(nav_user);
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                        .addToBackStack(null)

                        .setMaxLifecycle(nextFrag, Lifecycle.State.RESUMED)
                        .commit();
            }
            return;
        }


        //printHashKey(MasterView.this);
    }

    private void checkUpdate() {
        mAppUpdateManager = AppUpdateManagerFactory.create(this);

        mInstallStateUpdatedListener = new
                InstallStateUpdatedListener() {
                    @Override
                    public void onStateUpdate(InstallState state) {
                        if (state.installStatus() == InstallStatus.DOWNLOADED){
                            //CHECK THIS if AppUpdateType.FLEXIBLE, otherwise you can skip
                            popupSnackbarForCompleteUpdate();
                        } else if (state.installStatus() == InstallStatus.INSTALLED){
                            if (mAppUpdateManager != null){
                                mAppUpdateManager.unregisterListener(mInstallStateUpdatedListener);
                            }

                        } else {
                            Log.i("TAG", "InstallStateUpdatedListener: state: " + state.installStatus());
                        }
                    }
                };

        mAppUpdateManager.registerListener(mInstallStateUpdatedListener);

        mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(appUpdateInfo -> {

            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE /*AppUpdateType.IMMEDIATE*/)){

                try {
                    mAppUpdateManager.startUpdateFlowForResult(
                            appUpdateInfo, AppUpdateType.FLEXIBLE /*AppUpdateType.IMMEDIATE*/, MasterView.this, RC_APP_UPDATE);

                } catch (IntentSender.SendIntentException e) {
                    e.printStackTrace();
                }

            } else if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED){
                //CHECK THIS if AppUpdateType.FLEXIBLE, otherwise you can skip
                popupSnackbarForCompleteUpdate();
            } else {
                Log.e("TAG2", "checkForAppUpdateAvailability: something else");
            }
        });
    }

    private void popupSnackbarForCompleteUpdate() {

        Snackbar snackbar =
                Snackbar.make(
                        findViewById(R.id.content),
                        "La nueva aplicación está lista!",
                        Snackbar.LENGTH_INDEFINITE);

        snackbar.setAction("Instalar", view -> {
            if (mAppUpdateManager != null){
                mAppUpdateManager.completeUpdate();
            }
        });


        snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));
        snackbar.show();
    }

    public void printHashKey(Context pContext) {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
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

    public void setName(String Name){
        NavigationView navigationView = findViewById(R.id.nav_view);
        View hView =  navigationView.getHeaderView(0);
        TextView correo = (TextView)hView.findViewById(R.id.txtCorreo);
        TextView bienvenido = (TextView)hView.findViewById(R.id.txtBienvenido);
        bienvenido.setVisibility(View.VISIBLE);
        correo.setText(Name);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStackImmediate();
        }
        else{
            super.onBackPressed();
        }

       // LoginFragment.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        /*if (id == R.id.action_settings) {
            showInfoAlert(0);
        }*/

        //showInfoAlert(0);
        return super.onOptionsItemSelected(item);
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
    private void showInfoAlert(int ids)
    {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.detalle, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setPositiveButton("Guardar Nota", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //mListener.onDialogPositiveClick(mNameEdit.getText().toString(), mPasswordEdit.getText().toString());
                TextView texto = findViewById(R.id.txtContenidoNota);
                Toast.makeText(MasterView.this,"algo",Toast.LENGTH_LONG).show();
            }
        });

        dialogBuilder.setNegativeButton("Cerrar",null );
        //dialogBuilder.setNegativeButton("Guardar Nota",null );
        //ImageView editText = (ImageView) dialogView.findViewById(R.id.ImageDetail);
        //ImageView imagen = findViewById(ids);
        //editText.setImageDrawable(imagen.getDrawable());
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
}