package com.example.bismillahbisa.view.viewmodel;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bismillahbisa.model.sholat.DataItem;
import com.example.bismillahbisa.model.sholat.SholatDiscoverResponse;
import com.example.bismillahbisa.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalViewModel extends ViewModel{
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<DataItem>> listJadwalSholat = new MutableLiveData<ArrayList<DataItem>>();
public void setListJadwalSholat(){
if (this.apiMain==null) {
    apiMain = new ApiMain();
}
apiMain.getApiJadwal().getJadwalSholat().enqueue(new Callback<SholatDiscoverResponse>() {
    @Override
    public void onResponse(Call<SholatDiscoverResponse> call, Response<SholatDiscoverResponse> response) {
SholatDiscoverResponse sholatDiscoverResponse = response.body();
if(sholatDiscoverResponse != null && sholatDiscoverResponse.getData() != null){
    ArrayList<DataItem> data = sholatDiscoverResponse.getData();
    listJadwalSholat.postValue(data);
    Log.d("JadwalViewModel", "onSuccess: "+response.body());
}
    }

    @Override
    public void onFailure(Call<SholatDiscoverResponse> call, Throwable t) {
        Log.e("JadwalViewModel", "onFailure: "+t.getMessage());
    }
});
}
    public LiveData<ArrayList<DataItem>> getJadwaSholat(){
        return listJadwalSholat;
    }
}
