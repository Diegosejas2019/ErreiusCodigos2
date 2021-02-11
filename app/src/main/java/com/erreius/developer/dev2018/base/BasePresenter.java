package com.erreius.developer.dev2018.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BasePresenter {

    protected BasePresenter(){
    }

    @CallSuper
    void OnSaveInstanceState(@NonNull final Bundle outState){}

    @CallSuper
    void onCreate(@Nullable Bundle savedInstanceState) {
    }

    @CallSuper
    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    }

    @CallSuper
    public void onStart() {
    }

    @CallSuper
    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

    @CallSuper
    void onResume() {
    }

    @CallSuper
    void onSaveInstanceState(@NonNull Bundle outState) {
    }

    @CallSuper
    void onPause() {
    }

    @CallSuper
    void onStop() {
    }

    @CallSuper
    void onDestroy() {
    }
}
