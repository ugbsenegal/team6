package com.example.projet_dev_moibile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Button btn_s=findViewById(R.id.btn_start);
        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itchoice=new Intent(getApplicationContext(),choiceActivity.class);
                startActivity(itchoice);
            }
        });

        Button btn_op=findViewById(R.id.btn_option);
        btn_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_op=new Intent(getApplicationContext(),optionActivity.class);
                startActivity(it_op);
            }
        });
    }
}
