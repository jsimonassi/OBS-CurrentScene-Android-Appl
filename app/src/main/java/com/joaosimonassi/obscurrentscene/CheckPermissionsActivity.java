package com.joaosimonassi.obscurrentscene;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CheckPermissionsActivity extends AppCompatActivity {

    private Button requestPermissionsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_permissions);
        getSupportActionBar().hide();

        requestPermissionsBtn = findViewById(R.id.request_permission_btn);
        requestPermissionsBtn.setOnClickListener(v -> requestOverlayPermission());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(CheckPermissionsActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    public void requestOverlayPermission(){
        Intent myIntent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        startActivity(myIntent);
    }
}