package com.sawankumarsingh.notesforeveryone.activities;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sawankumarsingh.notesforeveryone.adapters.FetchNotesAdapter;
import com.sawankumarsingh.notesforeveryone.R;

import java.util.ArrayList;

public class FetchNotesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private String subjectName;
    private ImageView imaage_error;

    private DatabaseReference databaseReference;
    private DatabaseReference rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_notes);

        progressBar = findViewById(R.id.progress_bar);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        rootRef = FirebaseDatabase.getInstance().getReference();

        imaage_error = findViewById(R.id.image_error_message);
        recyclerView = findViewById(R.id.recyclerView_fetch_notes_activity1);
        imaage_error.setVisibility(View.GONE);

        subjectName = getIntent().getExtras().getString("SubjectName");

        getSupportActionBar().setTitle(subjectName);

        rootRef.child("Uploaded Files").child(subjectName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.child("fileExist").getValue().equals("true")) {
                    Toast.makeText(FetchNotesActivity.this, "File Exist", Toast.LENGTH_SHORT).show();
                    sendToRetrieveDataMethod();
                    progressBar.setVisibility(View.GONE);

                } else {

                    Toast.makeText(FetchNotesActivity.this, "File not Exist", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                    imaage_error.setVisibility(View.VISIBLE);
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(FetchNotesActivity.this));

                FetchNotesAdapter myAdapter = new FetchNotesAdapter(recyclerView, FetchNotesActivity.this, new ArrayList<String>(), new ArrayList<String>());
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void sendToRetrieveDataMethod() {
        databaseReference.child("Uploaded Files").child(subjectName).child("All Units").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String fileName = dataSnapshot.getKey();
                String fileUrl = dataSnapshot.getValue(String.class);

                ((FetchNotesAdapter) recyclerView.getAdapter()).update(fileName, fileUrl);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

