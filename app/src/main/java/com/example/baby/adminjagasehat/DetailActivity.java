package com.example.baby.adminjagasehat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private String userID, emailUser, jkUser, kerjaUser, tpUser, usiaUser;
    private TextView tvEmail, tvJK, tvKerja, tvPendidikan, tvUmur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvKerja = findViewById(R.id.kerja);
        tvPendidikan = findViewById(R.id.pendidikan);
        tvEmail = findViewById(R.id.email);
        tvJK = findViewById(R.id.jk);
        tvUmur = findViewById(R.id.umur);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            userID = extras.getString(IntentKeys.USER_ID);
            kerjaUser = extras.getString(IntentKeys.USER_KERJA);
            emailUser = extras.getString(IntentKeys.USER_EMAIL);
            usiaUser = extras.getString(IntentKeys.USER_UMUR);
            jkUser = extras.getString(IntentKeys.USER_JK);
            tpUser = extras.getString(IntentKeys.USER_PENDIDIKAN);
           
            updateUI(emailUser, jkUser, kerjaUser, tpUser, usiaUser);

        }
    }

    private void updateUI(String email, String jk, String kerja,
                          String pendidikan, String umur) {
        tvUmur.setText(umur + " tahun");
        tvJK.setText(jk);
        tvEmail.setText(email);
        tvKerja.setText(kerja);
        tvPendidikan.setText(pendidikan);
    }
}
