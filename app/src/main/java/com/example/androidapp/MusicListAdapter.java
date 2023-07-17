package com.example.androidapp;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder>{
    ArrayList<AudioModel> songsList;
    Context context;

    public MusicListAdapter(ArrayList<AudioModel> songsList, Context context) {
        this.songsList = songsList;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup child, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_item,child,false);
        return new MusicListAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MusicListAdapter.ViewHolder holder,int position) {

        AudioModel songData =songsList.get(position);
        holder.titleTextView.setText(songData.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                MyMediaPlayer.getInstance().reset();
               MyMediaPlayer.currentIndex = position;
                Intent intent = new Intent(context,MusicPlayerActivity.class);
               intent.putExtra("LIST",songsList);
               intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        ImageView iconImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView=itemView.findViewById(R.id.music_title_text);
            iconImageView=itemView.findViewById(R.id.icon_view);
        }
    }
}
