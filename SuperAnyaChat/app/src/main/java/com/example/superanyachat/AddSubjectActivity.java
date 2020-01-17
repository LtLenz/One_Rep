package com.example.superanyachat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.superanyachat.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class AddSubjectActivity extends AppCompatActivity {

    Spinner nameSelector;

    DatabaseReference reference;
    FirebaseUser fuser;
    String course;
    EditText teachersel;
    Button btn_add;

    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        nameSelector = findViewById(R.id.nameSelector);
        btn_add = findViewById(R.id.btn_add);
        teachersel = findViewById(R.id.teacherName);
        Bundle arguments = getIntent().getExtras();
        final String courses = arguments.get("course").toString();
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Subjects").child(fuser.getUid());

        if (courses != null) {
            switch (courses) {
                case ("1"):
                    adapter = ArrayAdapter.createFromResource(this, R.array.ISiT1, android.R.layout.simple_spinner_item);
                    break;
                case ("2"):
                    adapter = ArrayAdapter.createFromResource(this, R.array.ISiT2, android.R.layout.simple_spinner_item);
                    break;
                case ("3"):
                    adapter = ArrayAdapter.createFromResource(this, R.array.ISiT3, android.R.layout.simple_spinner_item);
                    break;
                case ("4"):
                    adapter = ArrayAdapter.createFromResource(this, R.array.ISiT4, android.R.layout.simple_spinner_item);
                    break;
            }
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            nameSelector.setAdapter(adapter);
        }

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSubject(nameSelector.getSelectedItem().toString(), courses, teachersel.getText().toString());
            }
        });
    }

    private void addSubject(final String title, final String course, final String teacher) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("title", title);
        hashMap.put("course", course);
        hashMap.put("teacher", teacher);
        reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(AddSubjectActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }



}
