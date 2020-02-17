package com.example.finalcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email_text; EditText password_text; Button login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email_text=findViewById(R.id.email_text);
        password_text=findViewById(R.id.password_text);
        login_button=findViewById(R.id.login_button);

        login_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:
                Intent intent=new Intent(MainActivity.this,product_details.class);
                MainActivity.this.startActivity(intent);
                break;

        }

    }
}
