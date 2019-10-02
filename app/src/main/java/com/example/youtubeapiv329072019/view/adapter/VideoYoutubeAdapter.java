package com.example.youtubeapiv329072019.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeapiv329072019.R;
import com.example.youtubeapiv329072019.api.modelapi.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoYoutubeAdapter extends RecyclerView.Adapter<VideoYoutubeAdapter.VideoYoutubeHolder> {

    ArrayList<Item> arrayVideo;
    OnItemClickListener listener;
    public interface OnItemClickListener{
        void onItemClick(View itemView, int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public VideoYoutubeAdapter(ArrayList<Item> arrayVideo) {
        this.arrayVideo = arrayVideo;
    }

    @NonNull
    @Override
    public VideoYoutubeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_video,null);
        return new  VideoYoutubeHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoYoutubeHolder holder, int position) {
        Item video = arrayVideo.get(position);
        holder.txtVideoTitle.setText(video.getSnippet().getTitle());
        Picasso.get().load(video.getSnippet().getThumbnails().getHigh().getUrl()).into(holder.imgVideo);
    }

    @Override
    public int getItemCount() {
        return arrayVideo.size();
    }


    public class VideoYoutubeHolder extends RecyclerView.ViewHolder{
        TextView txtVideoTitle;
        ImageView imgVideo;

        public VideoYoutubeHolder(@NonNull final View itemView) {
            super(itemView);
            txtVideoTitle = itemView.findViewById(R.id.txt_video);
            imgVideo = itemView.findViewById(R.id.img_video);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        listener.onItemClick(itemView,getLayoutPosition());
                    }
                }
            });

        }

    }

    public void updateList(ArrayList<Item> newVideo){
        arrayVideo = new ArrayList<>();
        arrayVideo.addAll(newVideo);
        notifyDataSetChanged();
    }
}
