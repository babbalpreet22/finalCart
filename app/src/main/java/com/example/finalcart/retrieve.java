package com.example.finalcart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class retrieve extends AppCompatActivity implements View.OnClickListener {
    TextView text1; Button retrieve_button; Button proceed_further;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        text1=findViewById(R.id.text1);
        retrieve_button=findViewById(R.id.retrieve_button);
        proceed_further=findViewById(R.id.proceed_further);

        retrieve_button.setOnClickListener(this);
        proceed_further.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getData();
        switch (v.getId()){
            case R.id.proceed_further:
                Intent intent=new Intent(retrieve.this,payment.class);
                retrieve.this.startActivity(intent);
                break;
        }

    }

    private void getData() {
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("Orders")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document:task.getResult()){
                                System.out.println(document.getString("Price"));
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(retrieve.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
    }

}
