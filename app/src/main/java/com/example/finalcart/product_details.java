package com.example.finalcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class product_details extends AppCompatActivity implements View.OnClickListener {

    EditText product_name;EditText product_description; EditText product_price;
    Button add_to_cart_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        product_name=findViewById(R.id.product_name);
       product_description=findViewById(R.id.product_description);
       product_price=findViewById(R.id.product_price);
       add_to_cart_button=findViewById(R.id.add_to_cart_button);

        add_to_cart_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_to_cart_button:
                sendData();
                Intent intent=new Intent(product_details.this,retrieve.class);
                product_details.this.startActivity(intent);
                break;
        }
    }

    private void sendData() {

    }
}
