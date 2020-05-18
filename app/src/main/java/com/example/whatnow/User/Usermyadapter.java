package com.example.whatnow.User;


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
public class Usermyadapter extends RecyclerView.Adapter<Usermyadapter.MyViewHolder> {

    Context context;
    private List<User> data4;

    public Usermyadapter(Context ct, List<User> data4){
        context = ct;

        this.data4 = data4;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.user_row,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.user_name.setText(data4.get(position).getName());
        holder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,Ping.class);
                intent.putExtra("id",data4.get(position).getId());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {

        return data4.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView user_name;
        LinearLayout view_container;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.mycontainer);
            user_name= itemView.findViewById(R.id.user_name);

        }
    }





}

