package com.example.youtubeapiv329072019.model;

import java.util.List;
import com.example.youtubeapiv329072019.api.modelapi.Item;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videoyoutube {

@SerializedName("items")
@Expose
private List<Item> items = null;

public List<Item> getItems() {
return items;
}

public void setItems(List<Item> items) {
this.items = items;
}

}