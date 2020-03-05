package com.example.android.hindiapp;

import androidx.annotation.Nullable;

public class Word {
    protected String defaultTranslation,hindiTranslation;
    protected int image_id,play_id;
    public Word(String s1, String s2,int play)
    {
        defaultTranslation=s1;
        hindiTranslation=s2;
        image_id=-1;
        play_id=play;
    }
    public Word(String s1, String s2,int image,int play)
    {
        defaultTranslation=s1;
        hindiTranslation=s2;
        image_id=image;
        play_id=play;
    }
    public String getDefaultTranslation(){ return defaultTranslation;}
    public String getHindiTranslation() {return hindiTranslation; }
    public int getImage_id(){return image_id;}
    public int getPlay_id(){return play_id;}
}
