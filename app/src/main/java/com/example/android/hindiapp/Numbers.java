package com.example.android.hindiapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    WordAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);

        final ArrayList<Word> num=new ArrayList<>();
        num.add(new Word("One","Ek",R.drawable.one,R.raw.number_one));
        num.add(new Word("Two","Do",R.drawable.two,R.raw.number_one));
        num.add(new Word("Three","Teen",R.drawable.three,R.raw.number_one));
        num.add(new Word("Four","Chaar",R.drawable.four,R.raw.number_one));
        num.add(new Word("Five","Paanch",R.drawable.five,R.raw.number_one));
        num.add(new Word("Six","Che",R.drawable.six,R.raw.number_one));
        num.add(new Word("Seven","Saat",R.drawable.seven,R.raw.number_one));
        num.add(new Word("Eight","Aanth",R.drawable.eight,R.raw.number_one));
        num.add(new Word("Nine","Naw",R.drawable.nine,R.raw.number_one));
        num.add(new Word("Ten","Dus",R.drawable.ten,R.raw.number_one));

        itemsAdapter = new WordAdapter(this,num,R.color.Green);

        final ListView listView =findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word local_word=num.get(position);
                MediaPlayer mediaPlayer=MediaPlayer.create(Numbers.this,local_word.getPlay_id());
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
