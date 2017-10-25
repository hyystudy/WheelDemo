package com.jccy.numberpickdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {

    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        Log.d("MainActivity", "onValueChange");
    }
}
