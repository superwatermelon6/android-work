package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ThirdActivity extends AppCompatActivity {

    private TextView text;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text = findViewById(R.id.text_content);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        Toast toast;
        if(mi.isCheckable()){
            mi.setCheckable(true);
        }
        int id = mi.getItemId();
        if(id == R.id.font_10)
            text.setTextSize(10);
        else if(id == R.id.font_16)
            text.setTextSize(16);
        else if(id == R.id.font_20)
            text.setTextSize(20);
        else if(id == R.id.red_font)
            text.setTextColor(getResources().getColor(R.color.red));
        else if(id == R.id.black_font)
            text.setTextColor(getResources().getColor(R.color.black));
        else if(id == R.id.plain_item){
            toast = Toast.makeText(this, "普通菜单项", Toast.LENGTH_SHORT);
            toast.show();
        }
        return true;
    }
}
