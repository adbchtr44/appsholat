package com.example.bismillahbisa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bismillahbisa.R;
import com.example.bismillahbisa.model.sholat.DataItem;

import java.util.ArrayList;

public class SholatDiscoverAdapter extends RecyclerView.Adapter<SholatDiscoverAdapter.ViewHolder> {
private ArrayList<DataItem> data = new ArrayList<>();
private Context context;

    public SholatDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataItem> items){
data.clear();
data.addAll(items);
notifyDataSetChanged();
}
    @NonNull
    @Override
    public SholatDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SholatDiscoverAdapter.ViewHolder holder, int position) {
holder.tanggal.setText(data.get(position).getDate().getReadable());
holder.subuh.setText(data.get(position).getTimings().getFajr());
holder.zuhur.setText(data.get(position).getTimings().getDhuhr());
holder.ashar.setText(data.get(position).getTimings().getAsr());
holder.maghrib.setText(data.get(position).getTimings().getMaghrib());
holder.isya.setText(data.get(position).getTimings().getIsha());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tanggal, subuh,zuhur, ashar, maghrib, isya;
        CardView cvSholat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvSholat = itemView.findViewById(R.id.itemlist_cv);
            tanggal = itemView.findViewById(R.id.itemlist_tanggal);
            subuh = itemView.findViewById(R.id.itemlist_subuh);
            zuhur = itemView.findViewById(R.id.itemlist_zuhur);
            ashar = itemView.findViewById(R.id.itemlist_ashar);
            maghrib = itemView.findViewById(R.id.itemlist_Maghrib);
            isya = itemView.findViewById(R.id.itemlist_isya);
        }
    }
}
