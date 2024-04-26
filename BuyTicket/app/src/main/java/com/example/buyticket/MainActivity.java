package com.example.buyticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgGender, rgType;
    private TextView lblOutput;
    private EditText editTextNumber;
    private int ticketPrice = 0; // 声明 ticketPrice 变量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgGender = findViewById(R.id.rgGender);
        rgType = findViewById(R.id.rgType);
        lblOutput = findViewById(R.id.lblOutput);
        editTextNumber = findViewById(R.id.editTextNumber);

        // 添加 RadioButton 選擇事件的監聽器
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutput(); // 當性別選擇改變時更新結果
            }
        });

        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutput(); // 當票種選擇改變時更新結果
            }
        });
    }

    // 更新 TextView 的內容
    private void updateOutput() {
        RadioButton genderRadioButton = findViewById(rgGender.getCheckedRadioButtonId());
        RadioButton typeRadioButton = findViewById(rgType.getCheckedRadioButtonId());

        String gender = genderRadioButton.getText().toString();
        String type = typeRadioButton.getText().toString();

        // 根據票種選擇設定票價
        switch(type) {
            case "全票 $500":
                ticketPrice = 500;
                break;
            case "兒童票 $250":
                ticketPrice = 250;
                break;
            case "學生票 $400":
                ticketPrice = 400;
                break;
            default:
                ticketPrice = 0;
                break;
        }

        // 計算總價格
        int numTickets = Integer.parseInt(editTextNumber.getText().toString());
        int totalPrice = numTickets * ticketPrice;

        String output = "性別: " + gender + "\n票種: " + type + "\n購買張數: " + numTickets;
        lblOutput.setText(output);
    }

    // 確定按鈕的點擊事件
    public void button_Click(View view) {
        // 在這裡添加確定按鈕的點擊事件處理邏輯
        updateOutput(); // 更新 lblOutput 的內容
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }


}
