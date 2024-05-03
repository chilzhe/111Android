package com.example.imageviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=(ImageView) findViewById(R.id.imgOutput);
        RadioGroup rg = (RadioGroup) findViewById(R.id.rgImages);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               //判斷選擇哪個RadioButton元件
               if (checkedId == R.id.rdbDog) {
                   image.setImageResource(R.mipmap.dog);
               } else if (checkedId == R.id.rdbElephant) {
                   image.setImageResource(R.mipmap.elephant);
               } else if (checkedId == R.id.rdbMouse) {
                   image.setImageResource(R.mipmap.mouse);
               } else if (checkedId == R.id.rdbRabbit) {
                   image.setImageResource(R.mipmap.rabbit);
               }
            }
        });
    }
}