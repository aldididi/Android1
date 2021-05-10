package pnj.uts.aldy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import pnj.uts.aldy.R;


public class LoginActivity extends AppCompatActivity {
    EditText edtEmail,edtPassword;
    Button actionLogin;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("LatihanAndroid", MODE_PRIVATE);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        actionLogin = findViewById(R.id.actionLogin);

        actionLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtEmail.getText().toString().length() > 0 && edtPassword.getText().toString().length()>0) {
                    //cek login
                    if(edtEmail.getText().toString().equals("aldy@mail.com") && edtPassword.getText().toString().equals("123456")) {
                        //sukses login
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email","aldy@mail.com");
                        editor.putString("nim","4817090051");
                        editor.putString("nama","Aldy");
                        editor.putString("kelas","TI6");
                        editor.apply();
                        finish();
                    }else {
                        Toast.makeText(LoginActivity.this, "Mohon Maaf Email dan Password Salah", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(LoginActivity.this, "Mohon Lengkapi Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}