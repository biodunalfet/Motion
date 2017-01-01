package com.hamza.motion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.transition.TransitionSet;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.ArcMotion;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;

public class SharedUnveiledActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        setContentView(R.layout.activity_shared_unveiled);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBar);

        Slide slide = new Slide();
        slide.addTarget(appBarLayout);
        slide.setSlideEdge(Gravity.BOTTOM);
        slide.setDuration(300);
        getWindow().setEnterTransition(slide);

        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final Pair participants = new Pair<>(fab, ViewCompat.getTransitionName(fab));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SharedUnveiledActivity.this, ArcMotionActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(SharedUnveiledActivity.this,
                                participants);

                ActivityCompat.startActivity(SharedUnveiledActivity.this, intent, options.toBundle());
//                AlertDialog.Builder builder = new AlertDialog.Builder(SharedUnveiledActivity.this);
//                builder.setMessage("Nothing here");
//                builder.setPositiveButton("CLOSE", null);
//                AlertDialog dialog = builder.create();
//                dialog.show();
//                dialog.anim
            }
        });


    }

}
