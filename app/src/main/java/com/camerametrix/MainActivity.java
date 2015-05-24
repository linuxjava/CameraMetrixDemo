package com.camerametrix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by guochang on 2015/5/24.
 */
public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onTest(View v){
        switch (v.getId()){
            case R.id.test1:
                startActivity(new Intent(this, Matrix1Activity.class));
                break;
            case R.id.test2:
                startActivity(new Intent(this, Matrix2Activity.class));
                break;

        }
    }
}
