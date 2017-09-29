package com.example.administrator.scaneexample;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TestSenceActivity extends AppCompatActivity {

    ViewGroup viewGroup;
    Scene scene;
    Scene mSence;
    Button button;
    boolean b = true;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sence);

        viewGroup = (ViewGroup) findViewById(R.id.scene_root);
        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b)
                TransitionManager.go(mSence,new ChangeBounds());
                else
                    TransitionManager.go(scene,new ChangeBounds());

                b = !b;
            }
        });

        scene = Scene.getSceneForLayout(viewGroup,R.layout.a_scene,this);
        mSence = Scene.getSceneForLayout(viewGroup,R.layout.another,this);









    }
}
