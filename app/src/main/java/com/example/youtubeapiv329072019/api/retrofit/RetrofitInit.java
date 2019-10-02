package com.example.youtubeapiv329072019.api.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Time;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Tao ra 1 singleTon tranh viec khoi tao qua nhieu retrofit
public class RetrofitInit {
    private static Retrofit mretrofit = null;
    private RetrofitInit(){

    }
    public static RequestAPI initApi(){
        if (mretrofit == null){
            mretrofit = getInstance("https://www.googleapis.com/youtube/v3/");
        }
        return mretrofit.create(RequestAPI.class);
    }
    private static Retrofit getInstance(String base_url){
        if (mretrofit == null){

            Gson gson  = new GsonBuilder().setLenient().create();
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(10 , TimeUnit.SECONDS)
                    .writeTimeout(10 , TimeUnit.SECONDS)
                    .connectTimeout(10,TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .protocols(Arrays.asList(Protocol.HTTP_1_1))
                    .build();
            mretrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(base_url)
                    .build();

        }
        return  mretrofit;
    }
}