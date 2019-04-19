package com.example.projet_dev_moibile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class two_gamersActivity extends AppCompatActivity {
    private int random=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_gamers);
        random=1+(int) (Math.random()*100) ;

        int max=(int) (Math.random()*10)+random;
        int min=max-10;
        EditText x1=findViewById(R.id.nb1);
        x1.setText(String.valueOf(random));
        TextView interval=findViewById(R.id.inter);
        interval.setText("["+String.valueOf(min)+"-"+String.valueOf(max)+"]");
    }
}
