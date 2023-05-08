package com.example.cameraglrender;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.Manifest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


/** 动态请求权限的Activity */
public class PermissionActivity extends AppCompatActivity {
    /** 在线激活所需的权限 */
    public static String[] NEEDED_PERMISSIONS = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private static final int ACTION_REQUEST_PERMISSIONS = 0x001;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.simple_list_item_1);

        if (ContextCompat.checkSelfPermission(this,NEEDED_PERMISSIONS[0]) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,NEEDED_PERMISSIONS[1]) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,NEEDED_PERMISSIONS[2]) == PackageManager.PERMISSION_GRANTED) {
            finish();
        } else {
            ActivityCompat.requestPermissions(this,NEEDED_PERMISSIONS,ACTION_REQUEST_PERMISSIONS);
        }

    }
}
