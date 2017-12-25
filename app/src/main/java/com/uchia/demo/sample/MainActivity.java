package com.uchia.demo.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upvdemo);

        intent = new Intent();
        intent.setClass(this, PagerActivity.class);
    }

    public void clickHorizontal(View view) {
        intent.putExtra("style", 1);
        startActivity(intent);
    }

    public void clickVertical(View view) {
        intent.putExtra("style", 2);
        startActivity(intent);
    }

    public void clickMultiScrHorizontal(View view) {
        intent.putExtra("style", 3);
        startActivity(intent);
    }

    public void clickMultiScrVertical(View view) {
        intent.putExtra("style", 4);
        startActivity(intent);
    }

    public void clickScaleTransformer(View view) {
        intent.putExtra("style", 5);
        startActivity(intent);
    }

    public void clickDepthTransformer(View view) {
        intent.putExtra("style", 6);
        startActivity(intent);
    }
}
