package com.example.projet_dev_moibile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class oneGamerActivity extends AppCompatActivity {
    private int random=0;
    private int attempts=0;
    private int modul=10;
    private int score;
    private int min;
    private int max;
    private Button validate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_gamer);

        random=1+(int)(Math.random()*90);
        TextView att=findViewById(R.id.atempt);
        att.append(String.valueOf(attempts));

        fixInterval();

        TextView interval=findViewById(R.id.interval1);
        interval.setText("["+String.valueOf(min)+"-"+String.valueOf(max)+"]");

        validate=findViewById(R.id.button9);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText x=findViewById(R.id.x);
                String value=x.getText().toString();
                x.clearComposingText();
                if(value!=null) {

                    if (Integer.parseInt(value) == random) {
                        Button share = findViewById(R.id.share);
                        share.setEnabled(true);
                        x.setEnabled(false);
                        validate.setEnabled(false);
                        TextView state = findViewById(R.id.state);
                        String congratulation = new String("Congratulation you'are winner.whould you like to share your score");
                        state.setText(congratulation);
                    }

                    x.setText(String.valueOf(random));
                    attempts++;
                    TextView att = findViewById(R.id.atempt);
                    att.setText("Atempts :" + String.valueOf(attempts));

                    modul--;

                    fixInterval();
                }
            }
        });

        Button shr=findViewById(R.id.share);
        shr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itsh=new Intent(Intent.ACTION_SEND);
                itsh.setType("text/plain");
                itsh.putExtra(Intent.EXTRA_SUBJECT,"score");
                Intent intent = itsh.putExtra(Intent.EXTRA_TEXT, "I win in random game with score" + score + "Who anner defaite me");
                startActivity(Intent.createChooser(itsh,"it your round to share"));
            }
        });
    }

    private void fixInterval(){
        max=(int) (Math.random()*modul)+random;
        if(max<modul) max=modul;
        min=max-modul;

        score=(modul*100)/(attempts+1);
        TextView sc=findViewById(R.id.score);
        sc.setText("score:"+String.valueOf(score));

        TextView interval=findViewById(R.id.interval1);
        interval.setText("["+String.valueOf(min)+"-"+String.valueOf(max)+"]");
    }
}
