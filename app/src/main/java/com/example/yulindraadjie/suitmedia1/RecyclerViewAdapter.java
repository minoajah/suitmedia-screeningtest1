package com.example.yulindraadjie.suitmedia1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<GuestModel> guestModels;

    public RecyclerViewAdapter(Context context, List<GuestModel> guestModels) {
        this.context = context;
        this.guestModels = guestModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_guest,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameGuest.setText(guestModels.get(position).getName());
        holder.birthdayGuest.setText(guestModels.get(position).getBirthdate());
        holder.imgGuest.setImageResource(guestModels.get(position).getImgs());
    }

    @Override
    public int getItemCount() {
        return guestModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameGuest;
        TextView birthdayGuest;
        ImageView imgGuest;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameGuest = itemView.findViewById(R.id.nameGuest);
            birthdayGuest = itemView.findViewById(R.id.birthdayGuest);
            imgGuest = itemView.findViewById(R.id.imgGuest);
        }
    }
}
