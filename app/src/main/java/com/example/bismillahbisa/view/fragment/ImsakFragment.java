package com.example.bismillahbisa.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bismillahbisa.R;
import com.example.bismillahbisa.database.AppDatabase;
import com.example.bismillahbisa.database.DataList;
import com.example.bismillahbisa.model.sholat.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImsakFragment extends Fragment {
    private AppDatabase appDatabase;
    private EditText etNama, etTanggal, etNamapenceramah, etJudul;
    private Button btnSubmit;

    public ImsakFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_imsak, container, false);
        etNama = root.findViewById(R.id.imsak_nama);
        etTanggal = root.findViewById(R.id.imsak_tanggal);
        etNamapenceramah = root.findViewById(R.id.imsak_namapenceramah);
        etJudul = root.findViewById(R.id.imsak_judul);
        btnSubmit = root.findViewById(R.id.imsak_submit);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appDatabase = appDatabase.initDB(getContext().getApplicationContext());
        String nama = etNama.getText().toString();
        String tanggal = etTanggal.getText().toString();
        String namapenceramah = etNamapenceramah.getText().toString();
        String judul = etJudul.getText().toString();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataList dataList = new DataList();
                dataList.setNama(nama);
                dataList.setTanggal(tanggal);
                dataList.setNamapenceramah(namapenceramah);
                dataList.setJudul(judul);
                appDatabase.dao().insertData(dataList);
                Toast.makeText(getContext(),"Data Berhasil Input",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
