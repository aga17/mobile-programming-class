package com.jibi.listviewdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private TextView hasilnya;
    private EditText txtinput;

    private ListView lv;
    private ArrayAdapter<String> kontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasilnya = findViewById(R.id.result);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(op);

        lv = findViewById(R.id.listView);
        String[] nama = new String[] {"agus","budi","cica","dani",
                "eka","fani","gina","hadi","indah",
                "jono","kana","Lina","Maya","Nanik","Opi"};
        ArrayList<String> listNama = new ArrayList<>(Arrays.asList(nama));

        kontak = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNama);
        lv.setAdapter(kontak);

    }

    View.OnClickListener op = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.button) {
                tampil_input();
            }
        }
    };

    private void tampil_input() {
        LayoutInflater li = LayoutInflater.from(this);
        View inputnya = li.inflate(R.layout.input_dialog, null);

        AlertDialog.Builder dialognya = new AlertDialog.Builder(this);
        dialognya.setView(inputnya);
        txtinput = inputnya.findViewById(R.id.edittext);

        dialognya
                .setCancelable(false)
                .setPositiveButton("Ok", oknya)
                .setNegativeButton("Batal", oknya);
        dialognya.show();
    }

    DialogInterface.OnClickListener oknya = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // positif -1 negatif -2
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    hasilnya.setText(txtinput.getText().toString());
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
            }
        }
    };
}
