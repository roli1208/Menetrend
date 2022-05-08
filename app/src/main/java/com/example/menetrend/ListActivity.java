package com.example.menetrend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ListActivity extends AppCompatActivity {

    FirebaseFirestore fstore;
    RecyclerView rview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        fstore = FirebaseFirestore.getInstance();
        rview = findViewById(R.id.r_view);
        fstore.collection("menetrend")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.println(Log.ASSERT,"d", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.println(Log.ASSERT,"d", "sikertelen");

                        }
                    }
                });

    }

    public void addAct(View view) {
        Intent intent = new Intent(this,AddActivity.class);
        startActivity(intent);
    }
}