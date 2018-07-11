package com.example.baby.adminjagasehat;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Activity_Login extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rellay1;

    Button btnLogin;
    EditText input_email, input_password;
    private FirebaseAuth auth;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash

        //View
        btnLogin = (Button) findViewById(R.id.login_btn_login);
        input_email = (EditText) findViewById(R.id.login_email);
        input_password = (EditText) findViewById(R.id.login_password);


        btnLogin.setOnClickListener(this);

        //init firebase auth
        auth = FirebaseAuth.getInstance();

        //check already session, if yes -> dashboard
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(Activity_Login.this, MainActivity.class));
        }
    }

        @Override
        public void onClick (View view){
            loginUser(input_email.getText().toString(), input_password.getText().toString());
        }

        private void loginUser (String email,final String password) {
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                           startActivity(new Intent(Activity_Login.this, MainActivity.class));
                           finish();
                        }
                    });
        }
}