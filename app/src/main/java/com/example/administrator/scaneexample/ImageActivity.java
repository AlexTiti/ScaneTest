package com.example.administrator.scaneexample;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

public class ImageActivity extends AppCompatActivity {

    private ViewGroup viewGroup;
    private Scene mScene_one ,mScene_two;
    private boolean b = true;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

//        Slide slide=new Slide();
//        slide.setDuration(500);
//        slide.setSlideEdge(Gravity.LEFT);
      getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.slide));
        getWindow().setReenterTransition(new Explode().setDuration(600));


        viewGroup = (ViewGroup) findViewById(R.id.layout_trans);

        mScene_one = Scene.getSceneForLayout(viewGroup,R.layout.scene_image_one,this);
        mScene_two = Scene.getSceneForLayout(viewGroup,R.layout.scene_image_two,this);




    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public  void change(View view){
        if (b)
            TransitionManager.go(mScene_two,new ChangeImageTransform());
        else
            TransitionManager.go(mScene_one,new ChangeImageTransform());

        b= !b;

    }
}
