package com.example.WasteFoodManagement;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;


public class DonorAdapter extends FirebaseRecyclerAdapter<DonorList, DonorAdapter.DonorViewHolder> {



    Context context;
    protected GoogleMap mGoogleMap;
    protected LatLng mMapLocation;




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
//        holder.check.setText(String.valueOf(model.getX())+","+String.valueOf(model.getY()));

//retrieving google map co-ordinates :(
        final String address = "geo:" + String.valueOf(model.getX()) + "," + String.valueOf(model.getY());
//


        context = holder.location.getContext();

        holder.location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                updateMapContents();
                Uri gmmIntentUri = Uri.parse(address);

                Intent i = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                i.setPackage("com.google.android.apps.maps");


                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(address));
                context.startActivity(intent);
//                context.startActivity(i);

//                mGoogleMap.addMarker(new MarkerOptions().position(address));
//                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(address, 10f);
//                mGoogleMap.moveCamera(cameraUpdate);
//                if (model.getX() != null && model.getY() != null)
//                {
//
//                    mGoogleMap2.addMarker(new MarkerOptions()
//                            .position(new LatLng(model.getX(), model.getY())));
//                    mGoogleMap2.moveCamera(CameraUpdateFactory.newLatLngZoom(
//                            new LatLng(model.getX(), model.getY()), 10));
//                }


//



            }


        });







        holder.receive.setOnClickListener(new View.OnClickListener() {

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

    private void updateMapContents() {


        mGoogleMap.clear();
        // Update the mapView feature data and camera position.
        mGoogleMap.addMarker(new MarkerOptions().position(mMapLocation));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(mMapLocation, 10f);
        mGoogleMap.moveCamera(cameraUpdate);


    }


    @NonNull
    @Override
    public DonorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.donor, parent, false);
        return new DonorViewHolder(view);


    }

    class DonorViewHolder extends RecyclerView.ViewHolder {


        TextView title, description, author, author2, check;
        ImageView delete, location;
        CardView receive;


        public DonorViewHolder(@NonNull View itemView) {


            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            author = itemView.findViewById(R.id.author);
            author2 = itemView.findViewById(R.id.author2);
            location = itemView.findViewById(R.id.location);
//            delete = itemView.findViewById(R.id.delete);
            receive = itemView.findViewById(R.id.receive);


//            edit = itemView.findViewById(R.id.edit);


        }


        public void setMapLocation(Double x, Double y) {

            mMapLocation = new LatLng(x, y);

            if (mGoogleMap != null) {
                updateMapContents();

            }
        }
    }




}