package com.example.bismillahbisa.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bismillahbisa.R;
import com.example.bismillahbisa.adapter.SholatDiscoverAdapter;
import com.example.bismillahbisa.model.sholat.DataItem;
import com.example.bismillahbisa.view.viewmodel.JadwalViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SholatFragment extends Fragment {

    private SholatDiscoverAdapter sholatDiscoverAdapter;
    private RecyclerView rvJadwalSholat;
    private JadwalViewModel jadwalViewModel;

    public SholatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sholat, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        sholatDiscoverAdapter = new SholatDiscoverAdapter(getContext());
        sholatDiscoverAdapter.notifyDataSetChanged();
    rvJadwalSholat = view.findViewById(R.id.fragment_sholat_rv);
    rvJadwalSholat.setLayoutManager(new GridLayoutManager(getContext(),1));

    jadwalViewModel = new ViewModelProvider(this).get(JadwalViewModel.class);
    jadwalViewModel.setListJadwalSholat();
    jadwalViewModel.getJadwaSholat().observe(this,getJadwalSholat);

    rvJadwalSholat.setAdapter(sholatDiscoverAdapter);
    }

    private Observer<ArrayList<DataItem>> getJadwalSholat = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> dataItems) {
            if(dataItems!=null){
                sholatDiscoverAdapter.setData(dataItems);
            }
        }
    };
}
