package com.example.travelin.Adapters;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.travelin.R;
import com.example.travelin.activity.DetailActivity;
import com.example.travelin.domains.popularDomain;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class popularAdapter extends RecyclerView.Adapter<popularAdapter.ViewHolder> {

    ArrayList<popularDomain> items;
//    DecimalFormat formatter;

    public popularAdapter(ArrayList<popularDomain> items) {
        this.items = items;
//        formatter=new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public popularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull popularAdapter.ViewHolder holder, int position) {
    holder.titleTxt.setText(items.get(position).getTitle());
    holder.locationTxt.setText(items.get(position).getLocation());
    holder.scoretxt.setText("" + items.get(position).getScore());


    int drawableResId=holder.itemView.getResources().getIdentifier(items.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResId)
                .transform(new CenterCrop(),new GranularRoundedCorners(40,40,40,40))
                .into(holder.pic);

        holder.itemView.setOnClickListener(view -> {
            Intent intent=new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object",items.get(position));
            holder.itemView.getContext().startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTxt,locationTxt,scoretxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTxt=itemView.findViewById(R.id.titleTxt2);
            locationTxt=itemView.findViewById(R.id.locationTxt);
            scoretxt=itemView.findViewById(R.id.scoretxt);
            pic=itemView.findViewById(R.id.picImg);
        }
    }
}
