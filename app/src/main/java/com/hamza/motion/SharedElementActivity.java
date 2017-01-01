package com.hamza.motion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SharedElementActivity extends AppCompatActivity {

    private android.widget.ImageView sharedImage;
    private android.widget.LinearLayout activitysharedelement;
    private TextView sharedtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);
        this.sharedtextView = (TextView) findViewById(R.id.shared_textView);
        this.activitysharedelement = (LinearLayout) findViewById(R.id.activity_shared_element);
        this.sharedImage = (ImageView) findViewById(R.id.sharedImage);

        final Pair participants = new Pair<>(sharedImage, ViewCompat.getTransitionName(sharedtextView));

        activitysharedelement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SharedElementActivity.this, SharedUnveiledActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(SharedElementActivity.this,
                                participants);



                ActivityCompat.startActivity(SharedElementActivity.this, intent, options.toBundle());
            }
        });

    }
}
