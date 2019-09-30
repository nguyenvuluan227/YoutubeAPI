package com.example.youtubeapiv329072019.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.example.youtubeapiv329072019.R;
import com.example.youtubeapiv329072019.api.retrofit.RetrofitInit;
import com.example.youtubeapiv329072019.model.Demo1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setBackgroundColor(Color.BLUE);

        Call<Demo1> callback = RetrofitInit.initApi().apiDemo1();
        callback.enqueue(new Callback<Demo1>() {
                @Override
            public void onResponse(Call<Demo1> call, Response<Demo1> response) {
                Demo1 demo1 = response.body();
                Log.d("BBB",demo1.getLogo());
            }

            @Override
            public void onFailure(Call<Demo1> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);
        return true;
    }
}
