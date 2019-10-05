package com.example.recyclerview;

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

import java.util.ArrayList;

public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<President> listPresident;

    //pengambilan data listPresiden yang sudah di isi sebelumnya melalui setListPresident
    public ArrayList<President> getListPresident() {
        return listPresident;
    }

    //Pengisian data listPresiden Melalui ArrayList<> ke dalam class ini sendiri
    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    public ListPresidentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    //pembuatan layout baru pada Adapter
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_president, viewGroup, false);

        return new CategoryViewHolder(itemRow);
    }

    //method Pengambilan data dari PresidentData kemudian di Implementasikan langsung dalam itemRowPresident
    //melalui pembuatan LayoutInflanter di onCreateViewHolder kemudian view dideklarasikan ulang di CategoryViewHolder

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvName.setText(getListPresident().get(i).getName());
        categoryViewHolder.tvRemarks.setText(getListPresident().get(i).getRemarks());
        Glide.with(context)
                .load(getListPresident().get(i).getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(categoryViewHolder.imgPhoto);
    }

    //method perhitungan jumlah item dalam RecyclerView
    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    //method pendeklarasian view dalam RecyclerView
    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView  tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
