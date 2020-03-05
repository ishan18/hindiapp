package com.example.android.hindiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button family=(Button) findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Family.class);
                startActivity(intent);
//                Navigation.findNavController(v).navigate(R.id.action_mainActivity_to_family3);
            }
        });
        Button numbers=(Button) findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Numbers.class);
                startActivity(intent);
            }
        });
        Button colour=(Button) findViewById(R.id.colours);
        colour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Colours.class);
                startActivity(intent);
            }
        });
        Button phrases=(Button) findViewById(R.id.animal);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Animal.class);
                startActivity(intent);
            }
        });
    }
}
