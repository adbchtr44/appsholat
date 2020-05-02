package com.example.bismillahbisa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bismillahbisa.R;
import com.example.bismillahbisa.database.AppDatabase;
import com.example.bismillahbisa.database.DataList;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private AppDatabase appDatabase;
    private DataList item = new DataList();
    private Context context;

    public ListAdapter(Context context) {
        this.context = context;
    }

    public void setDataList(ArrayList<DataList> dataList){
        this.dataList = dataList;
    }
    public ArrayList<DataList> getDataList() {
        return dataList;
    }
    private ArrayList<DataList> dataList = new ArrayList<DataList>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.tvTanggal.setText(getDataList().get(position).getTanggal());
holder.tvNama.setText(getDataList().get(position).getNama());
holder.tvNamapenceramah.setText(getDataList().get(position).getNamapenceramah());
holder.tvJudul.setText(getDataList().get(position).getJudul());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama, tvNamapenceramah,tvTanggal,tvJudul;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.itemdata_tanggal);
            tvNama = itemView.findViewById(R.id.itemdata_nama);
            tvNamapenceramah = itemView.findViewById(R.id.itemdata_namapenceramah);
            tvJudul = itemView.findViewById(R.id.itemdata_judul);
        }
    }
}
