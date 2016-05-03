package auroratech.traber.util;

import android.app.Activity;
import android.util.TypedValue;

public class ScreenInfoUtil {
    public static int getCorrectAnimationHeight(Activity activity, int desiredDp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, desiredDp, activity.getResources().getDisplayMetrics());
    }
}