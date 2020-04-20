package com.example.whatnow.Evento;

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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    private List<EventInfo> data3;

    public MyAdapter(Context ct, List<EventInfo> data3){
        context = ct;

       this.data3 = data3;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.my_row,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
    holder.events_name.setText(data3.get(position).getName());
    holder.events_hour.setText(data3.get(position).getDateEnd());
    holder.events_endhour.setText(data3.get(position).getDateStart());
    holder.view_container.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context,EventDetails.class);
            intent.putExtra("Name", data3.get(position).getName());
            intent.putExtra("Description",data3.get(position).getDescription());
            context.startActivity(intent);

        }
    });
    }

    @Override
    public int getItemCount() {

        return data3.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView events_name, events_hour, events_endhour;
        LinearLayout view_container;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.container);
            events_name = itemView.findViewById(R.id.events_name);
            events_hour = itemView.findViewById(R.id.events_hour);
            events_endhour = itemView.findViewById(R.id.events_endhour);
        }
    }



}
