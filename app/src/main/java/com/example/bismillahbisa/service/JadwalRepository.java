package com.example.bismillahbisa.service;
import com.example.bismillahbisa.model.sholat.SholatDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JadwalRepository {
    @GET("v1/calendarByAddress?address=yogyakarta&method=2&month=4&year=2020")
    Call<SholatDiscoverResponse> getJadwalSholat();
}
