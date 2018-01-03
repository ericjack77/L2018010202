package com.example.student.l2018010202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cb;
    Switch sw;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb=findViewById(R.id.checkBox);
        sw=(Switch)findViewById(R.id.switch1);
        pb=findViewById(R.id.progressBar);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Toast.makeText(MainActivity.this,"已勾選",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"取消勾選",Toast.LENGTH_SHORT).show();
                }
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    pb.setVisibility(View.VISIBLE);
                }
                else
                {
                    pb.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void click1(View v)
    {
        RadioGroup rg=findViewById(R.id.radiogroup);


        switch(rg.getCheckedRadioButtonId())
        {


            case R.id.radioButton:
                Toast.makeText(MainActivity.this,"3rd Option",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                Toast.makeText(MainActivity.this,"2nd Option",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton3:
                Toast.makeText(MainActivity.this,"1st Option",Toast.LENGTH_SHORT).show();
                break;

        }

    }

    public void click2(View v) {

        pb.setVisibility(View.VISIBLE);
        new Thread(){
          public void run(){
              super.run();
              try {
                  Thread.sleep(3000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }

              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      pb.setVisibility(View.INVISIBLE);
                  }
              });

          }

        };

    }
}
