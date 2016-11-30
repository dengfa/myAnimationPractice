package com.example.dengfa.myanimator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int PERIOD = 1000;
    private ImageView mMIvChampion1;
    private ImageView mMIvChampion2;
    private ImageView mMIvChampion3;
    private ImageView mMIvChampion4;
    private ImageView mMIvChampion5;
    private ImageView mMIvChampion6;
    private ImageView mMIvChampion7;
    private ImageView mMIvChampion8;
    private TextView  mTvSuper;

    long interval = PERIOD / 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);
        mTvSuper = (TextView) findViewById(R.id.tv_super);
        mMIvChampion1 = (ImageView) findViewById(R.id.champion1);
        mMIvChampion2 = (ImageView) findViewById(R.id.champion2);
        mMIvChampion3 = (ImageView) findViewById(R.id.champion3);
        mMIvChampion4 = (ImageView) findViewById(R.id.champion4);
        mMIvChampion5 = (ImageView) findViewById(R.id.champion5);
        mMIvChampion6 = (ImageView) findViewById(R.id.champion6);
        mMIvChampion7 = (ImageView) findViewById(R.id.champion7);
        mMIvChampion8 = (ImageView) findViewById(R.id.champion8);

        showAnimation();
    }

    private void showAnimation() {
        //白色菱形
        AnimatorSet animatorSet1 = new AnimatorSet();
        ObjectAnimator scaleX1 = ObjectAnimator.ofFloat(mMIvChampion1, "scaleX", 0, 1);
        ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(mMIvChampion1, "scaleY", 0, 1);
        animatorSet1.playTogether(scaleX1, scaleY1);
        animatorSet1.setDuration(10 * interval);

        //绿色菱形
        AnimatorSet animatorSet2 = new AnimatorSet();
        ObjectAnimator scaleX2 = ObjectAnimator.ofFloat(mMIvChampion2, "scaleX", 0, 1);
        ObjectAnimator scaleY2 = ObjectAnimator.ofFloat(mMIvChampion2, "scaleY", 0, 1);
        animatorSet2.playTogether(scaleX2, scaleY2);
        animatorSet2.setDuration(7 * interval);
        animatorSet2.setStartDelay(5 * interval);

        //右半菱形
        AnimatorSet animatorSet3 = new AnimatorSet();
        ObjectAnimator rotationY = ObjectAnimator.ofFloat(mMIvChampion3, "rotationY", 45, 1);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mMIvChampion3, "alpha", 0.2f, 1);
        animatorSet3.playTogether(rotationY, alpha);
        animatorSet3.setDuration(4 * interval);
        animatorSet3.setStartDelay(7 * interval);

        //绿色长方形
        AnimatorSet animatorSet4 = new AnimatorSet();
        ObjectAnimator scaleX4 = ObjectAnimator.ofFloat(mMIvChampion4, "scaleX", 0, 1);
        ObjectAnimator scaleY4 = ObjectAnimator.ofFloat(mMIvChampion4, "scaleY", 0, 1);
        animatorSet4.playTogether(scaleX4, scaleY4);
        animatorSet4.setDuration(8 * interval);
        animatorSet4.setStartDelay(7 * interval);

        //半透明栏杆
        AnimatorSet animatorSet5 = new AnimatorSet();
        ObjectAnimator scaleX5 = ObjectAnimator.ofFloat(mMIvChampion5, "scaleX", 0.3f, 1);
        ObjectAnimator scaleY5 = ObjectAnimator.ofFloat(mMIvChampion5, "scaleY", 0.3f, 1);
        animatorSet5.playTogether(scaleX5, scaleY5);
        animatorSet5.setDuration(6 * interval);
        animatorSet5.setStartDelay(8 * interval);

        AnimatorSet animatorSet6 = new AnimatorSet();
        //学士帽
        ObjectAnimator scaleX6 = ObjectAnimator.ofFloat(mMIvChampion6, "scaleX", 0, 1);
        ObjectAnimator scaleY6 = ObjectAnimator.ofFloat(mMIvChampion6, "scaleY", 0, 1);
        //彩带尾巴
        ObjectAnimator scaleX7 = ObjectAnimator.ofFloat(mMIvChampion7, "scaleX", 0, 1);
        ObjectAnimator scaleX8 = ObjectAnimator.ofFloat(mMIvChampion8, "scaleX", 0, 1);
        animatorSet6.playTogether(scaleX6, scaleY6, scaleX7, scaleX8);
        animatorSet6.setDuration(6 * interval);
        animatorSet6.setStartDelay(5 * interval);

        //彩带上的字
        AnimatorSet animatorSet7 = new AnimatorSet();
        ObjectAnimator scaleXTv = ObjectAnimator.ofFloat(mTvSuper, "scaleX", 0, 1);
        ObjectAnimator scaleYTv = ObjectAnimator.ofFloat(mTvSuper, "scaleY", 0, 1);
        animatorSet7.playTogether(scaleXTv, scaleYTv);
        animatorSet7.setDuration(11 * interval);
        animatorSet7.setStartDelay(5 * interval);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorSet1, animatorSet2, animatorSet3, animatorSet4, animatorSet5);
        animatorSet.play(animatorSet6).after(animatorSet1);
        animatorSet.play(animatorSet7).after(animatorSet1);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
