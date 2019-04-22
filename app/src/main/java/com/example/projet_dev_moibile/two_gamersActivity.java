package com.example.projet_dev_moibile;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class two_gamersActivity extends AppCompatActivity {
    private int random=0;
    private int attempts=0;
    private int modul=10;
    private int score;
    private Button validate1;
    private Button validate2;
    private EditText x1;
    private EditText x2;
    private int min;
    private int max;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_gamers);
        random=1+(int) (Math.random()*100) ;

        int max=(int) (Math.random()*10)+random;
        if(max<modul)   max=modul;
        int min=max-10;

        validate1=findViewById(R.id.btnv1);
        validate2=findViewById(R.id.btnv2);
        x1=findViewById(R.id.nb1);
        x2=findViewById(R.id.nb2);

        //x1.isEm;


        TextView interval=findViewById(R.id.inter);
        interval.setText("["+String.valueOf(min)+"-"+String.valueOf(max)+"]");
        int focus=(int)(Math.random()*100);
        if(focus>50){
            validate2.setEnabled(true);
            x2.requestFocus();
        }
        else{
            validate1.setEnabled(true);
            x1.requestFocus();
        }

        validate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val=x2.getText().toString();
                if(!val.equals("")){
                    if (Integer.parseInt(val) == random) {
                        x2.setEnabled(false);
                        validate2.setEnabled(false);
                        TextView state = findViewById(R.id.state2);
                        String congratulation = new String("Gamer Two you are the winner ");
                        state.setText(congratulation);
                    }
                    else{
                        validate1.setEnabled(true);
                    }
                    x2.setText("");
                    x1.requestFocus();
                    validate2.setEnabled(false);
                }
                else{
                    x2.setError("give your number");
                }
            }
        });

        validate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val=x1.getText().toString();
                if(!val.equals("")){
                    if (Integer.parseInt(val) == random) {
                        x1.setEnabled(false);
                        validate1.setEnabled(false);
                        TextView state = findViewById(R.id.state1);
                        String congratulation = new String("Gamer One you are the winner ");
                        state.setText(congratulation);
                    }
                    else{
                        validate2.setEnabled(true);
                    }
                    x1.setText("");
                    x2.requestFocus();
                    validate1.setEnabled(false);
                }
                else{
                    x1.setError("you don't give a number");
                }
            }
        });

    }
}
