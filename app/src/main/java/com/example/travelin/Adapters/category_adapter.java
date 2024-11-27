package com.example.travelin.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travelin.R;
import com.example.travelin.domains.categoryDomain;

import java.util.ArrayList;

public class category_adapter extends RecyclerView.Adapter<category_adapter.viewHolder> {

    public category_adapter(ArrayList<categoryDomain> items) {
        this.items = items;
    }

    ArrayList<categoryDomain> items;



    @NonNull
    @Override
    public category_adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull category_adapter.viewHolder holder, int position) {
holder.titleTxt.setText(items.get(position).getTitle());
int drawableResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPicpath(),"drawable",holder.itemView.getContext().getPackageName());


        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.picImg);

    }

    @Override
    public int getItemCount() {
        return items.size() ;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt;
        ImageView picImg;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.titleTxt);
            picImg=itemView.findViewById(R.id.catImg);
        }
    }
}
