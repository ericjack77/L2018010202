package com.example.student.l2018010202;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    CheckBox cb;
    Switch sw;
    ProgressBar pb,pb2;
    SeekBar sb;
    TextView tv;
    Button bu4,bu3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb=findViewById(R.id.checkBox);
        sw=(Switch)findViewById(R.id.switch1);
        pb=findViewById(R.id.progressBar);
        pb2=findViewById(R.id.progressBar2);
        sb=(SeekBar)findViewById(R.id.seekBar);
        tv=findViewById(R.id.textView);
        bu4=findViewById(R.id.button4);
        bu3=findViewById(R.id.button3);
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

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        bu4.setOnClickListener(this);
        bu3.setOnClickListener(this);
    }

    /*
    public void click3(View v)
    {
        pb2.setProgress(pb2.getProgress()-10);
    }

    public void click4(View v)
    {
        pb2.setProgress(pb2.getProgress()+10);
    }
    */

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

        Toast.makeText(MainActivity.this,String.valueOf(sb.getProgress()),Toast.LENGTH_SHORT).show();

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

        }.start();

    }

    public void click5(View v)
    {
        Button b5=findViewById(R.id.button5);
        Intent in=new Intent();
        in.setClass(MainActivity.this,Main2Activity.class);
        startActivity(in);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button3:
                pb2.setProgress(pb2.getProgress()-10);
                break;
            case R.id.button4:
                pb2.setProgress(pb2.getProgress()+10);
                break;
        }



    }
}
