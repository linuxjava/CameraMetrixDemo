package com.camerametrix;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by guochang on 2015/5/24.
 */
public class ViewAnimation1 extends Animation{
    private float pivatX;
    private float pivatY;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        pivatX = width / 2;
        pivatY = height / 2;
        setDuration(2500);
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());

        Log.d("xiao1", width + ":" + height);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        Log.d("xiao1", "interpolatedTime=" + interpolatedTime);
        Matrix matrix = t.getMatrix();
        matrix.setScale(interpolatedTime * 2, interpolatedTime * 2);
        matrix.postRotate(180 * interpolatedTime);
        matrix.preTranslate(-pivatX, -pivatY);
        matrix.postTranslate(pivatX, pivatY);
    }
}
