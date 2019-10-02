package com.example.youtubeapiv329072019.model.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.youtubeapiv329072019.api.retrofit.RequestAPI;
import com.example.youtubeapiv329072019.api.retrofit.RetrofitInit;
import com.example.youtubeapiv329072019.model.Videoyoutube;
import com.example.youtubeapiv329072019.view.adapter.VideoYoutubeAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoYoutubeRespo {

    private static VideoYoutubeRespo videorespo = null;
    private RequestAPI requestAPI;
    private VideoYoutubeRespo(){
        requestAPI = RetrofitInit.initApi();
    }
    public static VideoYoutubeRespo getInstance(){
        if (videorespo == null){
            videorespo = new VideoYoutubeRespo();
        }
        return videorespo;
    }

    public MutableLiveData<Videoyoutube> getAPIVideoYoutube() {
        final MutableLiveData<Videoyoutube> data = new MutableLiveData<>();
        Call<Videoyoutube> callbackvideo = requestAPI
                .searchYoutubeVideo("snippet",
                        "android",
                        "50",
                        "video",
                        "AIzaSyDw1xWgw-tzAEnKhPUpCPEpNXTwbs3e6hY");

        callbackvideo.enqueue(new Callback<Videoyoutube>() {
            @Override
            public void onResponse(Call<Videoyoutube> call, Response<Videoyoutube> response) {
                Videoyoutube videoyoutube = response.body();
                data.postValue(videoyoutube);

            }

            @Override
            public void onFailure(Call<Videoyoutube> call, Throwable t) {

            }
        });
        return data;
    }
}
