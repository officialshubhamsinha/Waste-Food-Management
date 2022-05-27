package com.example.WasteFoodManagement;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RetrieveListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private DonorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_list);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<DonorList> options =
                new FirebaseRecyclerOptions.Builder<DonorList>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Donor"), DonorList.class)
                        .build();


        adapter = new DonorAdapter(options);
        recyclerView.setAdapter(adapter);





    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}