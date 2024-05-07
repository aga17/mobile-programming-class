package com.jibi.numbercounter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPlus;
    private Button btnReset;
    private EditText etNumber;
    private TextView resultTv;
    private int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlus = findViewById(R.id.btn_plus);
        btnReset = findViewById(R.id.btn_reset);
        etNumber = findViewById(R.id.et_number);
        resultTv = findViewById(R.id.number);

        etNumber.setText("1");

        btnPlus.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int a = Integer.parseInt(etNumber.getText().toString());

        if (v.getId() == R.id.btn_plus) {
            result += a;
        } else if (v.getId() == R.id.btn_reset) {
            result = 0;
        }
        resultTv.setText(String.valueOf(result));
    }
}
