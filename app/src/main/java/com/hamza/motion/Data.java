package com.hamza.motion;

/**
 * Created by Hamza Fetuga on 12/22/2016.
 */

class Data {

    /**
     *  Main list items
     */
    static Item[] mainListItems = new Item[]{
            new Item("Touch Feedback", "Simple animations to signify view interactions"),
            new Item("Animations", "Using ViewPropertyAnimator"),
            new Item("Transitions", "Slide"),
            new Item("Transitions", "Explode"),
            new Item("Transitions", "Fade"),
            new Item("Transitions", "Shared Elements and ArcMotion")
    };

    /**
     *  Touch Feedback list items
     */
    static Item[] touchFeedBackListItems = new Item[]{
            new Item("Bounded Ripple", "Setting background as ?android:attr/selectableItemBackground"),
            new Item("Borderless Ripple", "Setting background as ?android:attr/selectableItemBackground")
    };

}
