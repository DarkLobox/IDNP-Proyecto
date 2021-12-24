package com.example.idnp_proyecto.Base;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<Presenter extends BasePresenter> extends AppCompatActivity{
    protected Presenter mPresenter;
    @NonNull
    protected abstract  Presenter createPresenter(@NonNull final Context context);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mPresenter=createPresenter(this);
        mPresenter.onCreate(savedInstanceState);
    }
    @Override
    protected void onResume(){
        super.onResume();
        mPresenter.onResume();
    }
    @Override
    protected void onPause(){
        super.onPause();
        mPresenter.onPause();
    }
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState){
        super.onSaveInstanceState(outState,outPersistentState);
        mPresenter.onSaveInstanceState(outState);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mPresenter.onDestroy();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        mPresenter.onActivityResult(requestCode,resultCode,data);
    }
    public void onRequestPermissionResult(int requestCode,@NonNull String []permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        mPresenter.onRequestPermissionResult(requestCode,permissions,grantResults);
    }

}
