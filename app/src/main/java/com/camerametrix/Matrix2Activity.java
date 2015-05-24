package com.camerametrix;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class Matrix2Activity extends Activity {
    private ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);

        mImg = (ImageView) findViewById(R.id.img);
    }


    public void onStart(View v){
        switch (v.getId()){
            case R.id.d2_btn:
                mImg.startAnimation(new ViewAnimation1());
                break;
            case R.id.d3_btn:
                mImg.startAnimation(new ViewAnimationCamera());
                break;

        }

    }
}
