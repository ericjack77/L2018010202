package com.example.student.l2018010202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb=findViewById(R.id.checkBox);
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
    }
}
