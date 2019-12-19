package edu.upc.dsa.segonminim.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import edu.upc.dsa.segonminim.R;

public class LoginActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1;


    public static final String MyPREFERENCES = "file" ;
    String username;
    String password;

    SharedPreferences sharedpreferences;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed1=findViewById(R.id.editText);
        ed2=findViewById(R.id.editText2);

        b1=findViewById(R.id.button);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        enter(sharedpreferences);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = ed1.getText().toString();
                password = ed2.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(username, password);
                editor.apply();
                enter(sharedpreferences);
            }
        });
    }
    public void enter(SharedPreferences sharedpreferences) {
        if (sharedpreferences.contains(username)) {
            String pass = sharedpreferences.getString(username, "");
            if (pass.equals("dsamola")) {
                Toast.makeText(LoginActivity.this, "Logged In", Toast.LENGTH_LONG).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);
            }
            else {
                Toast.makeText(LoginActivity.this, "Wrong password", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(LoginActivity.this, "No stored preferences", Toast.LENGTH_LONG).show();
        }

    }
}
