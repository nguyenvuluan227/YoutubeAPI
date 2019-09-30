package com.example.youtubeapiv329072019.api.retrofit;

import com.example.youtubeapiv329072019.model.Demo1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestAPI {

    @GET("demo1.json")
    Call<Demo1> apiDemo1();
}
