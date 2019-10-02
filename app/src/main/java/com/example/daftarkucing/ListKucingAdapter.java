package com.example.daftarkucing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListKucingAdapter extends RecyclerView.Adapter<ListKucingAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Kucing> listKucing;

    private ArrayList<Kucing> getListKucing() {
        return listKucing;
    }

    void setListKucing(ArrayList<Kucing> listKucing) {
        this.listKucing = listKucing;
    }

    ListKucingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_kucing, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tv_name.setText(getListKucing().get(position).getName());
        categoryViewHolder.tv_remarks.setText(getListKucing().get(position).getRemarks());

        Glide.with(context)
                .load(getListKucing().get(position).getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListKucing().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_remarks;
        ImageView imgPhoto;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_item_name);
            tv_remarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
