package com.example.finalcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class payment extends AppCompatActivity implements View.OnClickListener {

    EditText customer_name;
    EditText card_number;
    EditText pin;
    EditText card_expiry;
    EditText price;
    Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        customer_name = findViewById(R.id.customer_name);
        card_number = findViewById(R.id.card_number);
        pin = findViewById(R.id.pin);
        card_expiry = findViewById(R.id.card_expiry);
        price = findViewById(R.id.price);
        confirm = findViewById(R.id.confirm);

        confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirm:
                Intent intent = new Intent(payment.this, finish.class);
                payment.this.startActivity(intent);
                break;
        }


    }
}
