package auroratech.traber.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/**
 * Created by E on 4/12/2016.
 */
public class AnimatorUtil {

    static final int animationDuration = 300;

    public AnimatorUtil() {
    }

    public static void defaultTransitionAnimation(final ITBViewAnimator animatorReference, final View fromView, final View toView) {

//        animatorReference.onAnimationStart(fromView, toView);
//
//        fromView
//                .animate()
//                .alpha(0.0f)
//                .setDuration(animationDuration)
//                .setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
//
//                @Override
//                public void run() {
//                    fromView.setVisibility(View.GONE);
//
//                    toView
//                            .animate()
//                            .alpha(1.0f)
//                            .setDuration(animationDuration)
//                            .setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() {
//
//                            @Override
//                            public void run() {
//                                toView.setVisibility(View.VISIBLE);
//
//                                animatorReference.onAnimationEnd(fromView, toView);
//                            }
//                    });
//                }
//        });

        AnimatorSet mAnimationSet = new AnimatorSet();
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(fromView, View.ALPHA,  1f, 0f);
        fadeOut.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                animatorReference.onAnimationStart(fromView, toView);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                fromView.setVisibility(View.GONE);
            }

            @Override public void onAnimationCancel(Animator animation) {}
            @Override public void onAnimationRepeat(Animator animation) {}
        });
        fadeOut.setInterpolator(new LinearInterpolator());

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(toView, View.ALPHA, 0f, 1f);
        fadeIn.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // this needs to be first set to visible in order for fade in to work properly
                toView.setVisibility(View.VISIBLE);
            }
            @Override public void onAnimationEnd(Animator animation) {
                animatorReference.onAnimationEnd(fromView, toView);
            }

            @Override public void onAnimationCancel(Animator animation) {}
            @Override public void onAnimationRepeat(Animator animation) {}
        });
        fadeIn.setInterpolator(new LinearInterpolator());

        mAnimationSet.setDuration(animationDuration);
        mAnimationSet.playSequentially(fadeOut, fadeIn);
        mAnimationSet.start();
    }

    public static void expand(final View v, int duration, int targetHeight, AnimatorListenerAdapter onEnd) {

        int prevHeight  = v.getHeight();

        v.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                v.getLayoutParams().height = (int) animation.getAnimatedValue();
                v.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.addListener(onEnd);
        valueAnimator.start();
    }

    public static void collapse(final View v, int duration, int targetHeight) {
        int prevHeight  = v.getHeight();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                v.getLayoutParams().height = (int) animation.getAnimatedValue();
                v.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
    }
}
