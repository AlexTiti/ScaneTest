package com.example.administrator.scaneexample;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ChangeTransformActivity extends AppCompatActivity {

    private ViewGroup mViewGroup;
    private Scene mScene_one,mScene_two;
    private Button button4;
    private boolean b = true;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_transform);
        mViewGroup = (ViewGroup) findViewById(R.id.layout_trans);
        button4 = (Button) findViewById(R.id.button4);

        mScene_one = Scene.getSceneForLayout(mViewGroup,R.layout.scene_rotasion_one,this);
        mScene_two = Scene.getSceneForLayout(mViewGroup,R.layout.scene_rotasion_two,this);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b)
                    TransitionManager.go(mScene_two,new ChangeTransform());
                else
                    TransitionManager.go(mScene_one,new ChangeTransform());
                b= !b;


            }
        });
    }


}
