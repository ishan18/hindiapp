package com.example.android.hindiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Family extends AppCompatActivity {

    WordAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);

         final ArrayList<Word> family=new ArrayList<>();
        family.add(new Word("Father","Papa",R.drawable.father,R.raw.family_father));
        family.add(new Word("Mother","Maa",R.drawable.mother,R.raw.family_mother));
        family.add(new Word("Brother","Bhai",R.drawable.brother,R.raw.family_older_brother));
        family.add(new Word("Sister","Behen",R.drawable.sister,R.raw.family_younger_sister));
        family.add(new Word("Son","Beta",R.drawable.son,R.raw.family_son));
        family.add(new Word("Daughter","Beti",R.drawable.daughter,R.raw.family_daughter));
        family.add(new Word("Grand Father","Dada",R.drawable.grandfather,R.raw.family_grandfather));
        family.add(new Word("Grand Mother","Dadi",R.drawable.grandmother,R.raw.family_grandmother));

        itemsAdapter = new WordAdapter(this,family,R.color.Blue);

        ListView listView =(ListView)findViewById(R.id.list);
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
}
