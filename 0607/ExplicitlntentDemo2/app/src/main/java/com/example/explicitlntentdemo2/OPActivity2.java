package com.example.explicitlntentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class OPActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opactivity2);

        CheckBox chkDivide = (CheckBox) findViewById(R.id.chkDivide);
        chkDivide.setEnabled(false);

        Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opd1, opd2;
                double result = 0.0;
                RadioButton rdbAdd, rdbSubtract, rdbMulitiply, rdbDivide;

                //取得傳遞的資料
                Bundle bundle = OPActivity2.this.getIntent().getExtras();
                if (bundle == null) return;
                //取得運算元
                opd1 = Integer.parseInt(bundle.getString("OPERAND01"));
                opd2 = Integer.parseInt(bundle.getString("OPERAND02"));
                // 取得選取的運算子
                rdbAdd = (RadioButton) findViewById(R.id.rdbAdd);
                if (rdbAdd.isChecked()) {
                    chkDivide.setEnabled(false);
                    result = opd1 + opd2; //加
                }
                rdbSubtract = (RadioButton) findViewById(R.id.rdbSubtract);
                if (rdbSubtract.isChecked()) {
                    chkDivide.setEnabled(false);
                    result = opd1 - opd2; //減
                }
                rdbMulitiply = (RadioButton) findViewById(R.id.rdbMultiply);
                if (rdbMulitiply.isChecked()) {
                    chkDivide.setEnabled(false);
                    result = opd1 * opd2; //乘
                }
                rdbDivide = (RadioButton) findViewById(R.id.rdbDivide);
                //checkBox chkDivide = (CheckBox) findViewById(R.id.chkDivide);
                if (rdbDivide.isChecked()){
                    chkDivide.setEnabled(true);
                    if (chkDivide.isChecked())
                        result = opd1 / opd2;
                    else
                        result = opd1 / (double)opd2;
                }
                Intent rIntent = new Intent();
                Bundle rbundle = new Bundle();
                rbundle.putDouble("RESULT", result);
                rIntent.putExtras(rbundle);
                setResult(RESULT_OK, rIntent);
                finish();
            }
        });
    }
}