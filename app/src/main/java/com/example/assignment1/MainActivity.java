package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText komentarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        komentarText = findViewById(R.id.komentar_text);
    }
    public MainActivity() {
        super();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Mengambil Data Komentar dari User
        String dataKomentar = ambilDataKomentar();
        komentarText.setText(dataKomentar);
        Toast.makeText(this,"onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Menyimpan Data Komentar dari User
        saveDataKomentar(komentarText.getText().toString());

        Toast.makeText(this,"onStop", Toast.LENGTH_SHORT).show();
    }

    private void saveDataKomentar (String value) {
        SharedPreferences.Editor editor = this.getSharedPreferences("komentar", Context.MODE_PRIVATE).edit();
        editor.putString("keyKomentar", value);
        editor.commit();
    }

    private String ambilDataKomentar () {
        String hasil = this.getSharedPreferences("komentar", Context.MODE_PRIVATE).getString("keyKomentar", null);
        return hasil;
    }
}