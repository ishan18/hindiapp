package com.example.android.hindiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Animal extends AppCompatActivity {

    WordAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);

        final ArrayList<Word> animal=new ArrayList<>();
        animal.add(new Word("Lion","Sher",R.drawable.lion,R.raw.color_white));
        animal.add(new Word("Horse","Ghora",R.drawable.horse,R.raw.color_white));
        animal.add(new Word("Cow","Guy",R.drawable.cow,R.raw.color_white));
        animal.add(new Word("Monkey","Bandar",R.drawable.monkey,R.raw.color_white));
        animal.add(new Word("Elephant","Haathi",R.drawable.elephant,R.raw.color_white));
        animal.add(new Word("Tiger","Baagh",R.drawable.tiger,R.raw.color_white));
        animal.add(new Word("Wolf","Bheriya",R.drawable.wolf,R.raw.color_white));
        animal.add(new Word("Dog","Kutta",R.drawable.dog,R.raw.color_white));
        animal.add(new Word("Fox","Lomri",R.drawable.fox,R.raw.color_white));
        animal.add(new Word("Cat","Billi",R.drawable.cat,R.raw.color_white));

        itemsAdapter = new WordAdapter(this,animal,R.color.Purple);

        ListView listView =(ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word local_word=animal.get(position);
                MediaPlayer mediaPlayer=MediaPlayer.create(Animal.this,local_word.getPlay_id());
                mediaPlayer.start();
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        itemsAdapter.releaseMediaPlayer();
    }

    @Override
    protected void onPause(){
        super.onPause();
        itemsAdapter.releaseMediaPlayer();
    }
}