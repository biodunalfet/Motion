package com.hamza.motion;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

public class TouchFeedbackActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_feedback);

        TextView textView_ripple_drawable = (TextView) findViewById(R.id.textView_ripple_drawable_java);

        int[][] states = new int[][] {
                new int[] { android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed
        };

        int[] colors = new int[] {
                Color.CYAN,
                Color.RED,
                Color.GREEN,
                Color.YELLOW
        };

        ColorStateList colorStateList = new ColorStateList(states, colors);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());

            //ColorDrawable contentColor = null;
            ColorDrawable contentColor = new ColorDrawable(ContextCompat.getColor(this,R.color.grey));
            RippleDrawable rippleDrawable = new RippleDrawable(colorStateList,
                    contentColor,
                    shapeDrawable);
            textView_ripple_drawable.setBackground(rippleDrawable);
        }
        else {
            Toast.makeText(this, "Requires API >= 21", Toast.LENGTH_SHORT).show();
        }



    }
}
