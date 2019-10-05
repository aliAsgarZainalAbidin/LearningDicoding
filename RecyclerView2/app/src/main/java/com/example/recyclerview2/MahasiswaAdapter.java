package com.example.recyclerview2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ListMahasiwaHolder> {

    private ArrayList<Mahasiswa> dataList;

    public MahasiswaAdapter(ArrayList<Mahasiswa> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ListMahasiwaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_mahasiswa, viewGroup, false);
        return new ListMahasiwaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMahasiwaHolder listMahasiwaHolder, int i) {
        listMahasiwaHolder.tvNama.setText(dataList.get(i).getNama());
        listMahasiwaHolder.tvNim.setText(dataList.get(i).getNim());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ListMahasiwaHolder extends RecyclerView.ViewHolder {
        private TextView tvNama,tvNim;
        public ListMahasiwaHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.txt_nama_mahasiswa);
            tvNim = itemView.findViewById(R.id.txt_nim_mahasiswa);
        }
    }
}
