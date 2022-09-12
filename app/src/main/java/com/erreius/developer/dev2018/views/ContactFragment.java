package com.erreius.developer.dev2018.views;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.erreius.developer.dev2018.R;

public class ContactFragment extends Fragment {

    @BindView(R.id.imageView3) ImageView fbImage;
    @BindView(R.id.imageView4) ImageView twImage;
    /*@BindView(R.id.imageView5) ImageView lkImage;*/
    @BindView(R.id.imageView6) ImageView igImage;
    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                getFragmentManager().beginTransaction().
                        remove(ContactFragment.this).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this,view);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("");
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setOverflowIcon(null);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        fbImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openFacebookIntent(getContext());


            }
        });

        twImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openTwiterIntent(getContext());

            }
        });

        igImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openInstagramIntent(getContext());

            }
        });

        /*lkImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openLinkedinIntent(getContext());

            }
        });*/

        return view;
    }

    public void openFacebookIntent(Context context) {

        Intent intent;

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/Errepar"));
        } catch (Exception e) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Errepar"));
        }

        context.startActivity(intent);
    }

    public static void openTwiterIntent(Context context) {

        Intent intent;

        try {
            context.getPackageManager().getPackageInfo("com.twitter.android", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=errepar"));
        } catch (Exception e) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/errepar"));
        }

        context.startActivity(intent);
    }

    public void openInstagramIntent(Context context) {

        Uri uri = Uri.parse("http://instagram.com/_u/errepar_editorial");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        intent.setPackage("com.instagram.android");

        try {
            //if (isAppInstalled("com.instagram.android"))
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/errepar_editorial")));
        }
    }

    public void openLinkedinIntent(Context context) {

        Uri uri = Uri.parse("https://www.linkedin.com/company/errepar");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        intent.setPackage("com.linkedin.android");

        try {
            //if (isAppInstalled("com.instagram.android"))
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/company/errepar")));
        }
    }
/*
    private boolean isAppInstalled(String uri)
    {
        PackageManager pm = getActivity().getPackageManager();
        boolean app_installed = false;
        try
        {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e)
        {
            app_installed = false;
        }
        return app_installed ;
    }

    boolean appInstalled = isAppInstalled("com.facebook.katana");*/
}