package com.example.WasteFoodManagement;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;


public class DonorAdapter extends FirebaseRecyclerAdapter<DonorList, DonorAdapter.DonorViewHolder> {
    @RequiresApi(api = Build.VERSION_CODES.M)

    public DonorAdapter(@NonNull FirebaseRecyclerOptions<DonorList> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull DonorViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull DonorList model) {


        String key = getRef(position).getKey();

        holder.title.setText(model.getFoodName());
        holder.description.setText(model.getQuantity());
        holder.author.setText(model.getUserName());
        holder.author2.setText(model.getNumber());
        Double x = model.getX();
        Double y = model.getY();








        holder.delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                FirebaseDatabase.getInstance().getReference()

                        .child("Donor")
                        .child(getRef(position).getKey())
//                        .child(getRef(i).getKey())
                        .removeValue()

                        .addOnCompleteListener(new OnCompleteListener<Void>() {

                            @Override
                            public void onComplete(@NonNull Task<Void> task) {





                            }


                        });
            }
        });

    }

    @NonNull
    @Override
    public DonorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.donor, parent, false);
        return new DonorViewHolder(view);
    }

    class DonorViewHolder extends RecyclerView.ViewHolder {

        TextView title,description,author,author2;
        ImageView delete,edit;




        public DonorViewHolder(@NonNull View itemView) {

            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            author = itemView.findViewById(R.id.author);
            author2 = itemView.findViewById(R.id.author2);
            delete = itemView.findViewById(R.id.delete);


//            edit = itemView.findViewById(R.id.edit);



        }
    }




}
