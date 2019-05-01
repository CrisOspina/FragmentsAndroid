package com.example.fragments;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements YellowFragment.OnFragmentInteractionListener,
                                                               BlueFragment.OnFragmentInteractionListener {

    BlueFragment blueFragment;
    YellowFragment yellowFragment;
    Button btnYellowFragment, btnBlueFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blueFragment = new BlueFragment();
        yellowFragment = new YellowFragment();

        btnYellowFragment = findViewById(R.id.btnYellow);
        btnBlueFragment = findViewById(R.id.btnBlue);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayoutContainer,blueFragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void cambiarFragment(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btnYellow:
                fragmentTransaction.replace(R.id.frameLayoutContainer,yellowFragment).commit();
                break;
            case R.id.btnBlue:
                fragmentTransaction.replace(R.id.frameLayoutContainer,blueFragment).commit();
                break;
        }
    }
}
