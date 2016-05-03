package auroratech.traber.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import auroratech.traber.common.ui.IHeaderBackPressed;
import auroratech.traber.common.ui.IItemPressed;
import auroratech.traber.common.ui.TBUIBindingObj;

/**
 * Created by E on 4/5/2016.
 */
public class TBActivityBase extends Activity implements IItemPressed, IHeaderBackPressed {
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        // try to hide
        hideNavigation();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // try to hide
        hideNavigation();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove top title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // try to hide
        hideNavigation();
    }

    private void hideNavigation() {

        if (Build.VERSION.SDK_INT < 19) { //19 or above api
            this.getWindow().getDecorView().setSystemUiVisibility(View.GONE);
        } else {
            //for lower api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    @Override
    public void BackPressed() {
        // for back press from header
    }

    @Override
    public void addButtonPressed() {
        // for pressing on add button
    }

    @Override
    public void itemPressed(TBUIBindingObj data) {
        // for pressing a particular item on page
    }

    @Override
    public void chatArrowPressed(TBUIBindingObj data) {

    }
}
