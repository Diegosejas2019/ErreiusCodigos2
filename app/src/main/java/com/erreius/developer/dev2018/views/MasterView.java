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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.erreius.developer.dev2018.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MasterView extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        /*FirebaseMessaging.getInstance().subscribeToTopic("news").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_LONG).show();
            }
        });*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Erreius");
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_registrarme, R.id.nav_activar, R.id.nav_terminos, R.id.nav_contactanos)
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
                        Intent mainIntent = new Intent(MasterView.this,
                                LoginView.class);
                        startActivity(mainIntent);
                        MasterView.this.finish();
                        overridePendingTransition(R.anim.nav_default_enter_anim,R.anim.nav_default_exit_anim);
                        break;
                    case R.id.nav_activar:
                        nextFrag= new ActivarFragment();
                        break;
                    case R.id.nav_contactanos:
                        nextFrag= new ContactFragment();
                        break;
                    case R.id.nav_home:
                        nextFrag= new CodesFragment();
                        break;
                    case R.id.nav_terminos:
                        nextFrag= new TermsAndConditionsFragment();
                        break;
                    case R.id.nav_registrarme:
                        nextFrag= new RegisterFragment();
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
            Fragment nextFrag= new Fragment();
            if (Opcion.equals("Suscriptor"))
            {
                nextFrag = new RegisterFragment();
            }
            else{
                nextFrag = new LoginFragment();
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
                    .addToBackStack(null)

                    .setMaxLifecycle(nextFrag, Lifecycle.State.RESUMED)
                    .commit();
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStackImmediate();
        }
        else{
            super.onBackPressed();
        }
    }

}