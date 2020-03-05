package com.example.android.hindiapp;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    int colour_id;
    ArrayList<Word> pWords;
    Context context;
    MediaPlayer mediaPlayer;
    public WordAdapter(Context context, ArrayList<Word> pWords,int colour) {
        super(context, 0, pWords);
        colour_id = colour;
        this.context = context;
        this.pWords = pWords;
    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.simple_text, parent, false);
        }
        Word local_word = getItem(position);

        RelativeLayout relativeLayout=(RelativeLayout) listItemView.findViewById(R.id.container);
        relativeLayout.setBackgroundResource(colour_id);

        TextView hindiTextView = (TextView) listItemView.findViewById(R.id.hindi_text);
        hindiTextView.setText(local_word.getHindiTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text);
        defaultTextView.setText(local_word.getDefaultTranslation());


        Button play=(Button) listItemView.findViewById(R.id.play);
        listItemView.setTag(pWords.get(position));
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=pWords.get(position).getPlay_id();
                releaseMediaPlayer();
                mediaPlayer=MediaPlayer.create(context,id);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });

            }
        });

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if(local_word.getImage_id()!=-1)
            {
                imageView.setImageResource(local_word.getImage_id());
                imageView.setVisibility(View.VISIBLE);
            }
        else
            imageView.setVisibility(View.GONE);

        return listItemView;
    }
    public void releaseMediaPlayer()
    {
        if(mediaPlayer!=null)
                mediaPlayer.release();
        mediaPlayer=null;
    }
}
