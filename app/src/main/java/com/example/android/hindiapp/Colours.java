package com.example.android.hindiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Colours extends AppCompatActivity {

    ArrayList<Word> colour=new ArrayList<>();
    WordAdapter itemsAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);
        itemsAdapter= new WordAdapter(this,createList(),R.color.Yellow);

        listView=findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
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
    private ArrayList<Word> createList(){
        colour.add(new Word("Red","Laal",R.drawable.red,R.raw.color_red));
        colour.add(new Word("Blue","Neela",R.drawable.blue,R.raw.color_red));
        colour.add(new Word("Yellow","Peela",R.drawable.yellow,R.raw.color_red));
        colour.add(new Word("Green","Hara",R.drawable.green,R.raw.color_red));
        colour.add(new Word("Purple","Baingani",R.drawable.purple,R.raw.color_red));
        colour.add(new Word("Brown","Bhura",R.drawable.brown,R.raw.color_red));
        colour.add(new Word("Pink","Gulabi",R.drawable.pink,R.raw.color_red));
        colour.add(new Word("Orange","Narangi",R.drawable.orange,R.raw.color_red));
        colour.add(new Word("Black","Kala",R.drawable.black,R.raw.color_red));
        colour.add(new Word("White","Ujjla",R.drawable.white,R.raw.color_red));
        return colour;
    }
}
