package com.hamza.motion;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hamza Fetuga on 12/22/2016.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    Item[] items;
    Context context;

    public MainRecyclerAdapter(Context context, Item[] items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.generic_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Item item = getItemAt(position);
        holder.textView_title.setText(item.getTitle());
        holder.textView_subtitle.setText(item.getDescripition());

    }

    public Item getItemAt(int position){
        return items[position];
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView_title;
        TextView textView_subtitle;
        LinearLayout root;

        public ViewHolder(View itemView) {
            super(itemView);
            textView_title = (TextView) itemView.findViewById(R.id.textView_title);
            textView_subtitle = (TextView) itemView.findViewById(R.id.textView_subtitle);
            root = (LinearLayout) itemView.findViewById(R.id.root);

            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int index = getAdapterPosition();

                    switch (index){

                        case 0:
                            Intent intent_tfb = new Intent(context, TouchFeedbackActivity.class);
                            context.startActivity(intent_tfb);
                            break;

                        case 1:
                            Intent intent_vpa = new Intent(context, ViewPropertyAnimationActivity.class);
                            context.startActivity(intent_vpa);
                            break;

                        case 2:
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                ((MainActivity) context).slideTransition();
                            }
                            Intent intent_slide = new Intent(context, GenericActivity.class);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                context.startActivity(intent_slide,
                                        ActivityOptions
                                                .makeSceneTransitionAnimation(((MainActivity) context))
                                                .toBundle());
                            }
                            else{
                                context.startActivity(intent_slide);
                            }
                            break;

                        case 3:
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                ((MainActivity) context).explodeTransition();
                            }
                            Intent intent_explode = new Intent(context, GenericActivity.class);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                context.startActivity(intent_explode,
                                        ActivityOptions
                                                .makeSceneTransitionAnimation(((MainActivity) context))
                                                .toBundle());
                            }
                            else{
                                context.startActivity(intent_explode);
                            }
                            break;

                        case 4:
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                ((MainActivity) context).fadeTransition();
                            }
                            Intent intent_fade = new Intent(context, GenericActivity.class);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                context.startActivity(intent_fade,
                                        ActivityOptions
                                                .makeSceneTransitionAnimation(((MainActivity) context))
                                                .toBundle());
                            }
                            else{
                                context.startActivity(intent_fade);
                            }
                            break;

                        case 5:
                            Intent intent_se = new Intent(context, SharedElementActivity.class);
                            context.startActivity(intent_se);
                            break;

                        default:
                            break;

                    }


                }
            });
        }


    }
}
