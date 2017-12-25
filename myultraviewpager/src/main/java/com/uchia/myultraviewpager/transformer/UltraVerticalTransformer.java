package com.uchia.myultraviewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by uchia on 2017/12/25.
 */

public class UltraVerticalTransformer implements ViewPager.PageTransformer {
    private float yPosition;

    @Override
    public void transformPage(View view, float position) {
        view.setTranslationX(view.getWidth() * -position);
        yPosition = position * view.getHeight();
        view.setTranslationY(yPosition);
    }

    public float getPosition() {
        return yPosition;
    }
}