package com.aohuan.dodo.anim.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.aohuan.dodo.anim.R;
import com.aohuan.dodo.anim.utils.mrzk.controller.animationUtils.TransitionController;
import com.aohuan.dodo.anim.utils.mrzk.controller.animationUtils.ViewAnimationCompatUtils;
import com.aohuan.dodo.anim.utils.mrzk.controller.listener.TransitionCustomListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class T1StraActivity extends AppCompatActivity {

    @InjectView(R.id.iv_second)
    ImageView ivSecond;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.textView)
    TextView textView;
    @InjectView(R.id.cardview)
    CardView cardview;
    @InjectView(R.id.nsv)
    NestedScrollView nsv;
    @InjectView(R.id.fabbtn)
    FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t1_stra);
        ButterKnife.inject(this);
        doWork();
    }

    private void doWork() {
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        doFloatingButton();
    }

    private void doFloatingButton() {
        mFloatingActionButton.setScaleX(0);
        mFloatingActionButton.setScaleY(0);
        TransitionController.getInstance().setEnterListener(new TransitionCustomListener() {
            @Override
            public void onTransitionStart(Animator animator) {
            }

            @Override
            public void onTransitionEnd(Animator animator) {
                getSupportActionBar().show();
                mFloatingActionButton.animate().setDuration(500).scaleX(1).scaleY(1);

//                Animator mAnimator = ObjectAnimator.ofFloat(nsv, "translationY", nsv.getHeight(), 0);
////                Animator mAnimator = ViewAnimationCompatUtils.createCircularReveal( nsv, 0, 0, nsv.getWidth() / 2, nsv.getHeight());

                Animator mAnimator = getTypeAnimator();

                mAnimator.setDuration(300);
                mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                mAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }

                    @Override
                    public void onAnimationStart(Animator animation) {
                        nsv.setVisibility(View.VISIBLE);
                        super.onAnimationStart(animation);
                    }
                });
                mAnimator.start();
            }

            @Override
            public void onTransitionCancel(Animator animator) {
            }
        });
        TransitionController.getInstance().show(this, getIntent());
    }


    public Animator getTypeAnimator() {
        Log.e("type", ConstantsT.getAnimType().toString()+" -- ");
        switch (ConstantsT.getAnimType()) {
            case ANIM_TYPE_STRAIGHT:
//                return ObjectAnimator.ofFloat(nsv, "translationY", nsv.getHeight(), 0);
                return ObjectAnimator.ofFloat(nsv, "translationX", nsv.getHeight(), 0);
            case ANIM_TYPE_CIRCULAR_REVEAL:
                return ViewAnimationCompatUtils.createCircularReveal(cardview, 0, 0, cardview.getWidth() / 2, cardview.getHeight());

            case ANIM_TYPE_RECT_REVEAL:
                return ViewAnimationCompatUtils.createRectReveal(cardview, 0, cardview.getHeight(), ViewAnimationCompatUtils.RECT_TOP);

            default:
                return ObjectAnimator.ofFloat(nsv, "translationY", nsv.getHeight(), 0);
        }
    }


    @Override
    public void onBackPressed() {

        mFloatingActionButton.animate().scaleX(0).scaleY(0).setListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                TransitionController.getInstance().exitActivity(T1StraActivity.this);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
