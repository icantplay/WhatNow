package com.example.whatnow.Spot;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatnow.R;

import java.util.List;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.MyViewHolder> {

        Context context;
        private List<SpotInfo> data5;

        public SpotAdapter(Context ct, List<SpotInfo> data5){
            context = ct;

            this.data5 = data5;

        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view =inflater.inflate(R.layout.spot_row,parent,false);


            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            holder.spot_contact.setText(data5.get(position).getContact());
            holder.spot_name.setText(data5.get(position).getSpotname());
            holder.view_container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context,SpotDetails.class);
                    context.startActivity(intent);

                }
            });
        }

        @Override
        public int getItemCount() {

            return data5.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView spot_name;
            TextView spot_contact;
            LinearLayout view_container;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                view_container = itemView.findViewById(R.id.spotcontainer);
                spot_name= itemView.findViewById(R.id.spot_name);
                spot_contact= itemView.findViewById(R.id.spot_contact);


            }
        }





    }


