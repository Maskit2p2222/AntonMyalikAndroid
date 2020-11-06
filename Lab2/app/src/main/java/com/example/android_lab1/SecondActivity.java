package com.example.android_lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Integer numberInt = Integer.parseInt(intent.getStringExtra("numToSend"));
        Integer textInt = Integer.parseInt(intent.getStringExtra("textToSend"));
        Integer finalInt = numberInt + textInt;

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(finalInt.toString());

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toReturn = new Intent();
                toReturn.putExtra("textToSend", textView.getText().toString());
                EditText editText = (EditText) findViewById(R.id.editText2);
                toReturn.putExtra("numToSend", editText.getText().toString());
                setResult(Activity.RESULT_OK, toReturn);
                finish();
            }
        });
    }
}