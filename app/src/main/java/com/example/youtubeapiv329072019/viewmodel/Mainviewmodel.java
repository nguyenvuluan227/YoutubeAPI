package com.example.youtubeapiv329072019.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youtubeapiv329072019.model.Videoyoutube;
import com.example.youtubeapiv329072019.model.repository.VideoYoutubeRespo;

public class Mainviewmodel extends ViewModel {

    public Mainviewmodel() {

    }

    public MutableLiveData<Videoyoutube> dataVideo = VideoYoutubeRespo.getInstance().getAPIVideoYoutube();

}
