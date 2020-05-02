package com.example.bismillahbisa.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.bismillahbisa.model.sholat.Date;

@Entity(tableName = "List_Ramadhan")
public class DataList {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNamapenceramah() {
        return namapenceramah;
    }

    public void setNamapenceramah(String namapenceramah) {
        this.namapenceramah = namapenceramah;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo(name = "tanggal")
    private String tanggal;

    @ColumnInfo(name = "namapencereamah")
    private String namapenceramah;

    @ColumnInfo(name = "judul")
    private String judul;
}
