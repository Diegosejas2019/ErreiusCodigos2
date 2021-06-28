package com.erreius.developer.dev2018.utils;

import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.messaging.FirebaseMessaging;

public class MyFirebaseInstanceIDService  {

    private static final String TAG = "MyFirebaseIIDService";

    /*@Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        storeToken(refreshedToken);
        FirebaseMessaging.getInstance().subscribeToTopic("news").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                //Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_LONG).show();
            }
        });
    }*/

    private void storeToken(String token) {
        //saving the token on shared preferences
       // SharedPreference.getInstance(getApplicationContext()).saveDeviceToken(token);
    }
}
