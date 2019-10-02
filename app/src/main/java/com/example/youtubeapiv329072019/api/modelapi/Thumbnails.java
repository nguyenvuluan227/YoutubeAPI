package com.example.youtubeapiv329072019.api.modelapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnails {

@SerializedName("high")
@Expose
private High high;

public High getHigh() {
return high;
}

public void setHigh(High high) {
this.high = high;
}

}