package com.example.administrator.scaneexample;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ExplodeActivity extends AppCompatActivity {

    private ViewGroup mViewGroup;
    private Scene mScene_one;
    boolean isImageBigger = false;
    ImageView imageView4,imageView5,imageView6,imageView7;
    int primarySize = 0;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explode);
        //mScene_one = Scene.getSceneForLayout(mViewGroup,R.layout.expo,this);
        mViewGroup = (ViewGroup) findViewById(R.id.layout_trans);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        ViewGroup.LayoutParams layoutParams = imageView4.getLayoutParams();
        primarySize = layoutParams.width;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void click(View view) {
        TransitionManager.beginDelayedTransition(mViewGroup, TransitionInflater.from(this).inflateTransition(R.transition.change_explode));

        changeSize(view);
        changeVisibility(imageView4,imageView5,imageView6,imageView7);
        view.setVisibility(View.VISIBLE);
    }

    /**
     * view的宽高1.5倍和原尺寸大小切换 * 配合ChangeBounds实现缩放效果 * @param view
     */
    private void changeSize(View view) {
        isImageBigger=!isImageBigger;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

        if(isImageBigger){
            layoutParams.width=(int)(1.5*primarySize);
            layoutParams.height=(int)(1.5*primarySize);
        }else {
            layoutParams.width=primarySize;
            layoutParams.height=primarySize;
        }
        view.setLayoutParams(layoutParams);
    }

    /**
     * VISIBLE和INVISIBLE状态切换 * @param views
     */
    private void changeVisibility(View ...views){
        for (View view:views){
            view.setVisibility(view.getVisibility()==View.VISIBLE?View.INVISIBLE:View.VISIBLE);
        }
    }
}
