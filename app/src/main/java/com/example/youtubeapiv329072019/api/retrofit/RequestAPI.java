package com.example.youtubeapiv329072019.api.retrofit;

import com.example.youtubeapiv329072019.model.Videoyoutube;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestAPI {

    @GET("search")
    Call<Videoyoutube> searchYoutubeVideo(@Query("part") String part,
                                          @Query("q") String q,
                                          @Query("maxResults") String maxResults,
                                          @Query("type") String type,
                                          @Query("key") String key);
}
