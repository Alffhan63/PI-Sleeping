package com.google.android.gms.location.sample.geofencing;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Setting extends AppCompatActivity {
    private Switch SS;
    private Switch SG;

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        SS = (Switch) findViewById(R.id.SwitchSuara);
        SG = (Switch) findViewById(R.id.SwitchGetar);


        SharedPreferences memsuara = getSharedPreferences("com.google.android.gms.location.sample.geofencing", MODE_PRIVATE);
        SS.setChecked(memsuara.getBoolean("suara", false));
        //attach a listener to check for changes in state

        SS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SS.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("com.google.android.gms.location.sample.geofencing", MODE_PRIVATE).edit();
                    editor.putBoolean("suara", true);
                    editor.commit();
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("com.google.android.gms.location.sample.geofencing", MODE_PRIVATE).edit();
                    editor.putBoolean("suara", false);
                    editor.commit();
                }
            }
        });
        SharedPreferences memgetar = getSharedPreferences("com.google.android.gms.location.sample.geofencing", MODE_PRIVATE);
        SG.setChecked(memgetar.getBoolean("getar", false));

        SG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SG.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("com.google.android.gms.location.sample.geofencing", MODE_PRIVATE).edit();
                    editor.putBoolean("getar", true);
                    editor.commit();
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("com.google.android.gms.location.sample.geofencing", MODE_PRIVATE).edit();
                    editor.putBoolean("getar", false);
                    editor.commit();
                }
            }
        });
    }
}


