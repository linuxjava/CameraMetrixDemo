package com.camerametrix;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by guochang on 2015/5/24.
 */
public class ViewAnimationCamera extends Animation{
    private float pivatX;
    private float pivatY;
    private Camera camera;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        camera = new Camera();
        pivatX = width / 2;
        pivatY = height / 2;
        setDuration(2500);
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());

    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        Matrix matrix = t.getMatrix();
        camera.save();
        //camera.translate(0, 0, 1300*(1 - interpolatedTime));
        camera.rotateY(180*interpolatedTime);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-pivatX, -pivatY);
        matrix.postTranslate(pivatX, pivatY);
    }
}
