package com.hamza.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.util.Random;

public class ViewPropertyAnimationActivity extends AppCompatActivity {

    private android.widget.Button togglevisibilitybutton;
    private android.widget.RelativeLayout progressIndicator;
    private Button colorinterpolatebutton;
    int targetColor;
    private Button revealbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property_animation);
        this.revealbutton = (Button) findViewById(R.id.reveal_button);
        this.colorinterpolatebutton = (Button) findViewById(R.id.color_interpolate_button);
        this.progressIndicator = (RelativeLayout) findViewById(R.id.progressIndicator);
        this.togglevisibilitybutton = (Button) findViewById(R.id.toggle_visibility_button);

        targetColor = getRandomColor();
        colorinterpolatebutton.setTextColor(targetColor);

        colorinterpolatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (progressIndicator.getVisibility() == View.GONE) {
                    progressIndicator.setVisibility(View.VISIBLE);
                    progressIndicator.setAlpha(1.f);
                    progressIndicator.setScaleX(1.f);
                    progressIndicator.setScaleY(1.f);
                }


                int fromColor = Color.TRANSPARENT;
                Drawable background = progressIndicator.getBackground();
                if (background instanceof ColorDrawable) {
                    fromColor = ((ColorDrawable) background).getColor();
                }

                ObjectAnimator objectAnimator = ObjectAnimator.ofInt(progressIndicator,
                        "backgroundColor",
                        fromColor,
                        targetColor
                );
                objectAnimator.setInterpolator(new FastOutSlowInInterpolator());
                objectAnimator.setEvaluator(new ArgbEvaluator());
                objectAnimator.setDuration(500);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        targetColor = getRandomColor();
                        colorinterpolatebutton.setTextColor(targetColor);
                    }
                });
                objectAnimator.start();


            }
        });

        togglevisibilitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (progressIndicator.getVisibility() == View.GONE) {

                    progressIndicator.setVisibility(View.VISIBLE);
                    progressIndicator.setAlpha(0.f);
                    progressIndicator.setScaleX(0.f);
                    progressIndicator.setScaleY(0.f);

                    progressIndicator.animate().rotationBy(Float.parseFloat("360"))
                            .alpha(1.f)
                            .scaleX(1.f).scaleY(1.f)
                            .setDuration(250)
                            .setInterpolator(new FastOutSlowInInterpolator())
                            .start();

                } else {
                    progressIndicator.setAlpha(1.f);
                    progressIndicator.setScaleX(1.f);
                    progressIndicator.setScaleY(1.f);

                    progressIndicator.animate()
                            .alpha(0.f)
                            .scaleX(0.f).scaleY(0.f)
                            .setDuration(250)
                            .setInterpolator(new FastOutSlowInInterpolator())
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    progressIndicator.setVisibility(View.GONE);
                                }
                            })
                            .start();

                }

            }
        });

        revealbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progressIndicator.getVisibility() == View.GONE){

                    progressIndicator.setVisibility(View.VISIBLE);
                    progressIndicator.setAlpha(1.f);
                    progressIndicator.setScaleX(1.f);
                    progressIndicator.setScaleY(1.f);

                    int centerX = (progressIndicator.getLeft() + progressIndicator.getRight())/2;
                    int centerY = (progressIndicator.getTop() + progressIndicator.getBottom())/2;

                    float radius = (float) Math.hypot((double) centerX, (double) centerY);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Animator revealAnimator = ViewAnimationUtils.createCircularReveal(progressIndicator,
                                centerX,
                                centerY,
                                0,
                                radius);

                        revealAnimator.setDuration(400);
                        revealAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        revealAnimator.start();
                    }

                }
                else{
                    int centerX = (progressIndicator.getLeft() + progressIndicator.getRight())/2;
                    int centerY = (progressIndicator.getTop() + progressIndicator.getBottom())/2;

                    float radius = (float) Math.hypot((double) centerX, (double) centerY);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Animator revealAnimator = ViewAnimationUtils.createCircularReveal(progressIndicator,
                                centerX,
                                centerY,
                                radius,
                                0);

                        revealAnimator.setDuration(400);
                        revealAnimator.setInterpolator(new OvershootInterpolator());
                        revealAnimator.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                progressIndicator.setVisibility(View.GONE);
                            }
                        });
                        revealAnimator.start();
                    }
                }
            }
        });
    }


    public int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

}
