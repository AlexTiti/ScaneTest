package com.example.administrator.scaneexample;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button ,button2;
    private Scene mScene ,mScene_two;
    private ViewGroup mViewGroup;
    private ImageView imageView;
    private boolean b = true;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.slide_right));
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        mViewGroup = (ViewGroup) findViewById(R.id.layout_fragment_main);
        mScene = Scene.getSceneForLayout(mViewGroup,R.layout.sence_pic_one,this);
        mScene_two = Scene.getSceneForLayout(mViewGroup,R.layout.sence_pic_two,this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TestSenceActivity.class));
                overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_bottom);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b)
                    TransitionManager.go(mScene_two,new ChangeBounds());
                else
                    TransitionManager.go(mScene,new ChangeBounds());

                b = !b;

            }
        });
    }

    public void trans(View view){
        startActivity(new Intent(this,ChangeTransformActivity.class));
        overridePendingTransition(R.anim.abc_slide_in_top,R.anim.abc_slide_out_top);
    }

    public void button5(View view){
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair<View, String>(imageView,"img_"));
        startActivity(new Intent(this,ImageActivity.class),compat.toBundle());

    }

    public void button6(View view){
        startActivity(new Intent(this,FadeSideActivity.class));

    }
    public void button7(View view){
        startActivity(new Intent(this,ExplodeActivity.class));

    }
}
