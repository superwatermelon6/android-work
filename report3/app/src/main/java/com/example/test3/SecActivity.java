package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SecActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout loginForm = (ConstraintLayout) getLayoutInflater().inflate(R.layout.alert_rpp, null);
        new AlertDialog.Builder(this)
                .setView(loginForm)
                .show();
    }
}
