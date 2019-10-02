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

import java.text.BreakIterator;
import java.util.ArrayList;

public class CardViewKucingAdapter extends RecyclerView.Adapter<CardViewKucingAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<Kucing> listKucing;

    private ArrayList<Kucing> getListKucing() {
        return listKucing;
    }

    public void setListKucing(ArrayList<Kucing> listKucing) {
        this.listKucing = listKucing;
    }

    public CardViewKucingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_kucing, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int i) {
        Kucing k = getListKucing().get(i);

        Glide.with(context)
                .load(k.getPhoto())
                .apply(new RequestOptions().override(350,250))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvName.setText(k.getName());
        cardViewViewHolder.tvRemarks.setText(k.getRemarks());
    }

    @Override
    public int getItemCount() {
        return getListKucing().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;

        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
        }
    }
}
