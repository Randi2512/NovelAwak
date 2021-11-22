package com.example.novelawak;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private final String TAG = "LoginActivity";

    EditText user ,pass;
    TextView daftar;
    Button login;
    RequestQueue requestQueue;
    String nameUser, passUser;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        daftar = findViewById(R.id.txtDaftar);
        login = findViewById(R.id.login);
        requestQueue = Volley.newRequestQueue(LoginActivity.this);
        progressDialog = new ProgressDialog(LoginActivity.this);
        getSupportActionBar().hide();

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, DaftarActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String URL_SIGNIN = "http://192.168.43.225/enovel/loginClient.php";
                progressDialog.setMessage("Silakan tunggu, cek data ke server sedang berlangsung");
                progressDialog.show();
                nameUser = user.getText().toString().trim();
                passUser = pass.getText().toString().trim();

                StringRequest sr = new StringRequest(Request.Method.POST, URL_SIGNIN, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_LONG).show();
                        if (response.equalsIgnoreCase("Login Berhasil!")){
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("name", user.getText().toString());
                            startActivity(intent);
                            nameUser = "";
                            passUser = "";
                        } else{
                            clearData();
                            startActivity(new Intent(LoginActivity.this, LoginActivity.class));
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, error.toString());
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("username", nameUser);
                        params.put("password", passUser);
                        return params;
                    }
                };
                requestQueue.add(sr);
            }
        });
    }

    private void clearData() {
        user.setText("");
        pass.setText("");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LoginActivity.this, SplashScreenActivity.class));
    }

}