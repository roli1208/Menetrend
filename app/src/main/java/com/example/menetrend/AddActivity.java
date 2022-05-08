package com.example.menetrend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class AddActivity extends AppCompatActivity {
    FirebaseFirestore db;

    EditText indvarosET;
    EditText indidoET;
    EditText erkvarosET;
    EditText erkidoET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        db = FirebaseFirestore.getInstance();
        indvarosET = findViewById(R.id.et_indvaros);
        indidoET = findViewById(R.id.et_indido);
        erkvarosET = findViewById(R.id.et_erkvaros);
        erkidoET = findViewById(R.id.et_erkido);
    }

    public void add(View view) {
        String indvaros = indvarosET.getText().toString();
        String indido = indidoET.getText().toString();
        String erkvaros = erkvarosET.getText().toString();
        String erkido = erkidoET.getText().toString();
        Menetrend m = new Menetrend(indvaros,indido,erkvaros,erkido);
        Map<String,Object> menetrend = new HashMap<>();
        menetrend.put("indvaros",m.getIndVaros());
        menetrend.put("indido",m.getIndIdo());
        menetrend.put("erkvaros",m.getErkVaros());
        menetrend.put("erkido",m.getErkIdo());
        Log.println(Log.ASSERT,"1",m.getErkIdo());
        db.collection("menetrend")
                .add(menetrend)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.println(Log.ASSERT,"1","siekres feltoltes");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });

    }
}