package com.example.dengfa.myanimator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mMIvChampion1;
    private ImageView mMIvChampion2;
    private ImageView mMIvChampion3;
    private ImageView mMIvChampion4;
    private ImageView mMIvChampion5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);
        mMIvChampion1 = (ImageView) findViewById(R.id.champion1);
        mMIvChampion2 = (ImageView) findViewById(R.id.champion2);
        mMIvChampion3 = (ImageView) findViewById(R.id.champion3);
        mMIvChampion4 = (ImageView) findViewById(R.id.champion4);
        mMIvChampion5 = (ImageView) findViewById(R.id.champion5);

        showAnimation();
    }

    private void showAnimation() {
        AnimatorSet animatorSet1 = new AnimatorSet();
        ObjectAnimator scaleX1 = ObjectAnimator.ofFloat(mMIvChampion1, "scaleX", 0, 1);
        ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(mMIvChampion1, "scaleY", 0, 1);
        animatorSet1.playTogether(scaleX1, scaleY1);
        animatorSet1.setDuration(4000);

        AnimatorSet animatorSet2 = new AnimatorSet();
        ObjectAnimator scaleX2 = ObjectAnimator.ofFloat(mMIvChampion2, "scaleX", 0, 1);
        ObjectAnimator scaleY2 = ObjectAnimator.ofFloat(mMIvChampion2, "scaleY", 0, 1);
        animatorSet2.playTogether(scaleX2, scaleY2);
        animatorSet2.setDuration(3200);
        animatorSet2.setStartDelay(800);

        AnimatorSet animatorSet3 = new AnimatorSet();
        ObjectAnimator rotationY = ObjectAnimator.ofFloat(mMIvChampion3, "rotationY", 300, 359);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mMIvChampion3, "alpha", 0, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1);
        animatorSet3.playTogether(rotationY, alpha);
        animatorSet3.setDuration(1000);
        animatorSet3.setStartDelay(3000);

        AnimatorSet animatorSet4 = new AnimatorSet();
        ObjectAnimator scaleX4 = ObjectAnimator.ofFloat(mMIvChampion4, "scaleX", 0, 1);
        ObjectAnimator scaleY4 = ObjectAnimator.ofFloat(mMIvChampion4, "scaleY", 0, 1);
        animatorSet4.playTogether(scaleX4, scaleY4);
        animatorSet4.setDuration(500);

        AnimatorSet animatorSet5 = new AnimatorSet();
        ObjectAnimator scaleX5 = ObjectAnimator.ofFloat(mMIvChampion5, "scaleX", 0.3f, 1);
        ObjectAnimator scaleY5 = ObjectAnimator.ofFloat(mMIvChampion5, "scaleY", 0.3f, 1);
        animatorSet5.playTogether(scaleX5, scaleY5);
        animatorSet5.setDuration(500);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorSet1, animatorSet2, animatorSet3);
        animatorSet.play(animatorSet4).after(animatorSet1);
        animatorSet.play(animatorSet5).after(animatorSet1);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
