package com.example.projet_dev_moibile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;
public class choiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Button btn_one=findViewById(R.id.btn_one);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_one=new Intent(getApplicationContext(),oneGamerActivity.class);
                startActivity(it_one);
            }
        });
        Button btn_two=findViewById(R.id.btn_two);
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_two=new Intent(getApplicationContext(),two_gamersActivity.class);
                startActivity(it_two);
            }
        });
    }
}
