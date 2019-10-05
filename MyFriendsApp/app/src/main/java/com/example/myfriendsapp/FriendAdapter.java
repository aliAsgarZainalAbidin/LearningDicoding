package com.example.myfriendsapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {

    private Context context;
    private ArrayList<ModelFriend> listFriend;

    public FriendAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FriendViewHolder friendViewHolder, int i) {

    friendViewHolder.imgPhoto.setImageResource(listFriend.get(i).getPhoto());
    friendViewHolder.tvNama.setText(listFriend.get(i).getNama());
    friendViewHolder.tvDesc.setText(listFriend.get(i).getDesc());

    friendViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final ModelFriend modelFriend = new ModelFriend();
            int position = friendViewHolder.getAdapterPosition();
            modelFriend.setNama(listFriend.get(position).getNama());
            modelFriend.setDesc(listFriend.get(position).getDesc());
            modelFriend.setHobi(listFriend.get(position).getHobi());
            modelFriend.setTtl(listFriend.get(position).getTtl());
            modelFriend.setPhoto(listFriend.get(position).getPhoto());

            Intent intent  = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_DATA, modelFriend);
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return listFriend.size();
    }

    public void setListFriend(ArrayList<ModelFriend> listFriend) {
        this.listFriend = listFriend;
    }

    public class FriendViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvNama;
        TextView tvDesc;
        RelativeLayout relativeLayout;

        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            relativeLayout = itemView.findViewById(R.id.relative_layout);
        }
    }
}
