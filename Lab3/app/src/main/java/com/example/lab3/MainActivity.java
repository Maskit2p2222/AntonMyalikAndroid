package com.example.lab3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    private MainService mainService;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MainService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            MainService.MainServiceBinder binder = (MainService.MainServiceBinder) service;
            mainService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        EditText editTextForEnterNumber = findViewById(R.id.EditText_EnterNumber);
        int number = Integer.parseInt(editTextForEnterNumber.getText().toString());
        TextView textViewForOutNumber = findViewById(R.id.TextView_OutNumber);

        switch (item.getItemId()) {
            case R.id.menu_FourthDegree:
                textViewForOutNumber.setText(Integer.toString(mainService.getFourthDegreeOfTheNumber(number)));
                return true;
            case R.id.menu_Cube:
                textViewForOutNumber.setText(Integer.toString(mainService.getCubeOfTheNumber(number)));
                return true;
            case R.id.menu_Square:
                textViewForOutNumber.setText(Integer.toString(mainService.getSquareOfTheNumber(number)));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}