package com.hamza.motion;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        setContentView(R.layout.activity_main);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setAdapter(new MainRecyclerAdapter(this, Data.mainListItems));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void slideTransition() {
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.END);
        slide.setDuration(250);
        getWindow().setExitTransition(slide);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void explodeTransition() {
        Explode explode = new Explode();
        explode.setDuration(300);
        getWindow().setExitTransition(explode);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void fadeTransition() {
        Fade fade = new Fade();
        fade.setDuration(300);
        getWindow().setExitTransition(fade);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void explodeExcludeToolbar() {
        Explode explode = new Explode();
        explode.setDuration(300);
        try {
            explode.excludeTarget(getSupportActionBar().getClass(), true);
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        getWindow().setExitTransition(explode);
    }
}
