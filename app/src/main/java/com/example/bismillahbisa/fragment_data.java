package com.example.bismillahbisa;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bismillahbisa.database.AppDatabase;
import com.example.bismillahbisa.database.DataList;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_data extends Fragment {

    private AppDatabase appDatabase;
    private RecyclerView recyclerView;
    private DataList listramadhan[];
    private ArrayList<DataList> dataLists = new ArrayList<>();
    private ListAdapter listAdapter;

    public fragment_data() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        appDatabase = appDatabase.initDB(getContext().getApplicationContext());
        listramadhan = appDatabase.dao().getData();
        recyclerView = view.findViewById(R.id.rvdata);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        for (int i=0;i<listramadhan.length;i++)
        {
            dataLists.add(listramadhan[i]);
        }
        /*ListAdapter Adapter = new ListAdapter(getContext());
        Adapter.setDataList(dataLists);
        */
        listAdapter = new ListAdapter();
        recyclerView.setAdapter(Adapter);
    }
}
