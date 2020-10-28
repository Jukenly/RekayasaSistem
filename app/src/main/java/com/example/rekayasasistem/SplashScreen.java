package com.example.rekayasasistem;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import gr.net.maroulis.library.EasySplashScreen;


public class SplashScreen extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(TampilSemuaPgw.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#FFC0CB"))
                //.withHeaderText("Rekayasa Sistem")
                .withFooterText("5PSI - class Rekayasa Sistem")
                .withBeforeLogoText("UTS Rekayasa Sistem")
                .withAfterLogoText("Kelompok Pink")
                .withLogo(R.mipmap.ic_launcher_round);

        //config.getHeaderTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextColor(Color.WHITE);
        config.getBeforeLogoTextView().setTextColor(Color.WHITE);

        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
    }

    }

