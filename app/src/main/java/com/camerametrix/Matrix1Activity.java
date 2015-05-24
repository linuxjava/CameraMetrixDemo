package com.camerametrix;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class Matrix1Activity extends Activity {
    private ImageView mImg, mTransfmationImg;
    private Bitmap mSrcBitmap;
    private EditText mEdit1, mEdit2, mEdit3, mEdit4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);

        mImg = (ImageView) findViewById(R.id.img);
        mTransfmationImg = (ImageView) findViewById(R.id.transfmation_img);
        mEdit1 = (EditText) findViewById(R.id.translation_edt);
        mEdit2 = (EditText) findViewById(R.id.scale_edt);
        mEdit3 = (EditText) findViewById(R.id.rotate_edt);
        mEdit4 = (EditText) findViewById(R.id.skew_edt);

        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);

        mImg.setImageBitmap(mSrcBitmap);
    }


    public void onClickTest(View v) {
        Matrix matrix = new Matrix();
        Bitmap transfmationBitmap = null;

        switch (v.getId()) {
            case R.id.translation_btn:
                matrix.postTranslate(mSrcBitmap.getWidth(), mSrcBitmap.getHeight());
                //平移bitmap似乎是有问题的，日后解决
//                transfmationBitmap = Bitmap.createBitmap(mSrcBitmap, 0, 0, mSrcBitmap.getWidth(),
//                        mSrcBitmap.getHeight(), matrix, false);
//                mTransfmationImg.setImageBitmap(transfmationBitmap);

                //注意设置img的android:scaleType="matrix"，否者不起作用
                mImg.setImageMatrix(matrix);
                break;
            case R.id.scale_btn:
                matrix.setScale(getValues(mEdit2), getValues(mEdit2));
                transfmationBitmap = Bitmap.createBitmap(mSrcBitmap, 0, 0, mSrcBitmap.getWidth(),
                        mSrcBitmap.getHeight(), matrix, true);
                mTransfmationImg.setImageBitmap(transfmationBitmap);
                break;
            case R.id.rotate_btn:
                matrix.setRotate(getValues(mEdit3));
                transfmationBitmap = Bitmap.createBitmap(mSrcBitmap, 0, 0, mSrcBitmap.getWidth(),
                        mSrcBitmap.getHeight(), matrix, true);
                mTransfmationImg.setImageBitmap(transfmationBitmap);
                break;
            case R.id.skew_btn:
                matrix.setSkew(getValues(mEdit4), 0);
                matrix.postScale(1.5f, 1.5f);
                transfmationBitmap = Bitmap.createBitmap(mSrcBitmap, 0, 0, mSrcBitmap.getWidth(),
                        mSrcBitmap.getHeight(), matrix, true);
                mTransfmationImg.setImageBitmap(transfmationBitmap);
                break;
            case R.id.src_btn:
                mTransfmationImg.setImageBitmap(mSrcBitmap);
                break;
        }
    }

    private float getValues(EditText et) {
        return Float.parseFloat(et.getText().toString());
    }
}
