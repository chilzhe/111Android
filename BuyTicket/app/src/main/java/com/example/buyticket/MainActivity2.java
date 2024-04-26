package com.example.buyticket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 獲取從 MainActivity 傳遞過來的數據
        Intent intent = getIntent();
        String gender = intent.getStringExtra("gender");
        String type = intent.getStringExtra("type");
        int numTickets = intent.getIntExtra("numTickets", 0);
 //       int totalPrice = intent.getIntExtra("totalPrice", 0);

        // 將數據顯示在 UI 上
        TextView lblOutput = findViewById(R.id.lblOutput);
        String output = "性別: " + gender + "\n票種: " + type + "\n購買張數: " + numTickets ;
        lblOutput.setText(output);
    }
}
