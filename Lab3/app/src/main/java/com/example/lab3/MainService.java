package com.example.lab3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;


public class MainService extends Service {

    public class MainServiceBinder extends Binder {
        public MainService getService(){
            return MainService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MainServiceBinder();
    }

    public int getFourthDegreeOfTheNumber(int number) {
        return (int) Math.pow(number,4);
    }

    public int getCubeOfTheNumber(int number) {
        return (int) Math.pow(number,3);
    }

    public int getSquareOfTheNumber(int number) {
        return number * number;
    }
}
