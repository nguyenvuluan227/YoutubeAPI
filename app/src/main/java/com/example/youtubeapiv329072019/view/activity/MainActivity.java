package com.example.youtubeapiv329072019.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeapiv329072019.R;
import com.example.youtubeapiv329072019.api.modelapi.Item;
import com.example.youtubeapiv329072019.model.Videoyoutube;
import com.example.youtubeapiv329072019.view.adapter.VideoYoutubeAdapter;
import com.example.youtubeapiv329072019.viewmodel.Mainviewmodel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    VideoYoutubeAdapter adapter;
    ArrayList<Item> arrayVideo;
    Mainviewmodel mainviewmodel;
    SearchView searchView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerviewvideo);
        arrayVideo = new ArrayList<>();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setBackgroundColor(Color.BLUE);
        mainviewmodel = new Mainviewmodel();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new VideoYoutubeAdapter(arrayVideo);
        adapter.setOnItemClickListener(new VideoYoutubeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent intent = new Intent(MainActivity.this,LoadVideoActivity.class);
                intent.putExtra("idvideo",arrayVideo.get(position).getId().getVideoId());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        mainviewmodel.dataVideo.observe(this, new Observer<Videoyoutube>() {
            @Override
            public void onChanged(Videoyoutube videoyoutube) {
                if (videoyoutube != null){
                    arrayVideo.addAll(videoyoutube.getItems());
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);
        MenuItem menuItem = menu.findItem(R.id.item_search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                String userInput = newText.toLowerCase();
                ArrayList<Item> newList = new ArrayList<>();
                for (Item array : arrayVideo){
                    if (array.getSnippet().getTitle().toLowerCase().contains(userInput)){
                        newList.add(array);
                    }
                }
                adapter.updateList(newList);
                return true;
            }
        });
        return true;
    }

}
