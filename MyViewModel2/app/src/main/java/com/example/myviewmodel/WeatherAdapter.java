package com.example.myviewmodel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private ArrayList<WeatherItems> mData = new ArrayList<>();

    public void setData(ArrayList<WeatherItems> weatherItems){
        mData.clear();
        mData.addAll(weatherItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_items, viewGroup, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
        weatherViewHolder.bind(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaKota;
        TextView tvTemperature;
        TextView tvDesckription;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaKota = itemView.findViewById(R.id.textKota);
            tvDesckription = itemView.findViewById(R.id.textDesc);
            tvTemperature = itemView.findViewById(R.id.textTemp);
        }

        void bind(WeatherItems weatherItems){
            tvNamaKota.setText(weatherItems.getName());
            tvDesckription.setText(weatherItems.getDescription());
            tvTemperature.setText(weatherItems.getTemperature());
        }
    }
}
