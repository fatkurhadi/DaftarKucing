package com.example.daftarkucing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridKucingAdapter extends RecyclerView.Adapter<GridKucingAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Kucing> listKucing;

    private ArrayList<Kucing> getListKucing() {
        return listKucing;
    }

    public void setListKucing(ArrayList<Kucing> listKucing) {
        this.listKucing = listKucing;
    }

    public GridKucingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_kucing, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListKucing().get(position).getPhoto())
                .apply(new RequestOptions().override(350,250))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListKucing().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        GridViewHolder(View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
