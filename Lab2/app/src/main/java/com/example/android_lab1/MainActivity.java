package com.example.android_lab1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText1);
                TextView textView = (TextView) findViewById(R.id.textView1);
                Intent intentToSend = new Intent(MainActivity.this, SecondActivity.class);
                intentToSend.putExtra("numToSend", editText.getText().toString());
                intentToSend.putExtra("textToSend", textView.getText().toString());
                startActivityForResult(intentToSend, 5);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 5) {
            if(resultCode == Activity.RESULT_OK) {
                Integer resText = Integer.parseInt(data.getStringExtra("numToSend"));
                Integer resNum = Integer.parseInt(data.getStringExtra("textToSend"));
                Integer finalText = resText + resNum;
                TextView textView = (TextView) findViewById(R.id.textView1);

                textView.setText(finalText.toString());
            }
        }
    }
}