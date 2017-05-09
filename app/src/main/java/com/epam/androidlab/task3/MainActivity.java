package com.epam.androidlab.task3;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends FragmentActivity {

    int[] colorArray = new int[]{Color.RED, Color.BLUE, Color.CYAN, Color.DKGRAY, Color.GRAY,
            Color.GREEN, Color.MAGENTA, Color.WHITE, Color.YELLOW, Color.LTGRAY};
    Button buttonFirst;
    Button buttonSecond;
    Button buttonThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFirst = (Button) findViewById(R.id.button);
        buttonFirst.setBackgroundColor(Color.LTGRAY);
        buttonSecond = (Button) findViewById(R.id.button2);
        buttonSecond.setBackgroundColor(Color.LTGRAY);
        buttonThird = (Button) findViewById(R.id.button3);
        buttonThird.setBackgroundColor(Color.LTGRAY);
        //getFragmentManager().getFragment(savedInstanceState,"button_fragment").setRetainInstance(true);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        Random random = new Random();
        int buttonColorIndex = random.nextInt(9);
        button.setBackgroundColor(colorArray[buttonColorIndex]);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        ColorDrawable buttonColor = (ColorDrawable) buttonFirst.getBackground();
        outState.putInt("buttonFirstColor", buttonColor.getColor());
        buttonColor = (ColorDrawable) buttonSecond.getBackground();
        outState.putInt("buttonSecondColor", buttonColor.getColor());
        buttonColor = (ColorDrawable) buttonThird.getBackground();
        outState.putInt("buttonThirdColor", buttonColor.getColor());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        buttonFirst= (Button) findViewById(R.id.button);
        buttonSecond= (Button) findViewById(R.id.button2);
        buttonThird= (Button) findViewById(R.id.button3);
        buttonFirst.setBackgroundColor(savedInstanceState.getInt("buttonFirstColor"));
        buttonSecond.setBackgroundColor(savedInstanceState.getInt("buttonSecondColor"));
        buttonThird.setBackgroundColor(savedInstanceState.getInt("buttonThirdColor"));
    }
}
