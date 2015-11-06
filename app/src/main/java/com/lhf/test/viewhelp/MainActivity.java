package com.lhf.test.viewhelp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends Activity {

    private int lsatX;
    private int lsatY;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (View) findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_MOVE:
                        int dx = x - lsatX;
                        int dy = y - lsatY;
                        Log.i("LHF", "dx:" + dx + ",dy:" + dy);
                        int tx = (int) ViewHelper.getTranslationX(view) + dx;
                        int ty = (int) ViewHelper.getTranslationY(view) + dy;

                        ViewHelper.setTranslationX(view, tx);
                        ViewHelper.setTranslationY(view, ty);

                        break;
                    case MotionEvent.ACTION_UP:

                        break;

                    default:
                        break;

                }
                lsatX = x;
                lsatY = y;

                return true;
            }
        });

    }

}
