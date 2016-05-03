package auroratech.traber.util;

import android.view.View;

/**
 * Created by E on 4/13/2016.
 */
public interface ITBViewAnimator {
    public void onAnimationStart(View fromView, View toView);
    public void onAnimationEnd(View fromView, View toView);
}
