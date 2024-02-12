package com.example.reservation_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.reservation_app.Domain.ItemsDomain;
import com.example.reservation_app.R;

import java.util.ArrayList;

public class SimilarAdapter extends RecyclerView.Adapter<SimilarAdapter.ViewHolder> {
    ArrayList<ItemsDomain> items;
    Context context;

    public SimilarAdapter(ArrayList<ItemsDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public SimilarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate=LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarAdapter.ViewHolder holder, int position) {

        int drawableResourceId = holder.itemView.getResources()
        .getIdentifier(items.get(position).getImgPath(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        pic=itemView.findViewById(R.id.img);
    }
}
}
