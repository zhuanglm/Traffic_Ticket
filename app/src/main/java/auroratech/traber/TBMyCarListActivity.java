package auroratech.traber;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.common.ui.IHeaderBackPressed;
import auroratech.traber.common.ui.IItemPressed;
import auroratech.traber.common.ui.TBCarItem;
import auroratech.traber.common.ui.TBUIBindingObj;
import auroratech.traber.managers.TBUIManager;
import auroratech.traber.util.ITBViewAnimator;


public class TBMyCarListActivity extends TBActivityBase implements IItemPressed, ITBViewAnimator, IHeaderBackPressed {

    TBActivityBase current;

    auroratech.traber.common.ui.TBHeader profileHeaderSection;
    RelativeLayout myCarViewListItemsContent;
    LinearLayout my_car_list;
    TextView profile_user_name;
    auroratech.traber.common.ui.TBCarItem my_car_add_btn;
    auroratech.traber.common.ui.TBFooter profileFooterSection;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_my_car_list);

        current = this;

        profileHeaderSection = (auroratech.traber.common.ui.TBHeader) findViewById(R.id.profileHeaderSection);
        myCarViewListItemsContent = (RelativeLayout) findViewById(R.id.myCarViewListItemsContent);
        my_car_list = (LinearLayout) findViewById(R.id.my_car_list);
        profile_user_name = (TextView) findViewById(R.id.profile_user_name);
        my_car_add_btn = (auroratech.traber.common.ui.TBCarItem) findViewById(R.id.my_car_add_btn);
        profileFooterSection = (auroratech.traber.common.ui.TBFooter) findViewById(R.id.profileFooterSection);

        // need reference
        my_car_add_btn.setActivityReference(current);
        profileFooterSection.setActivityReference(current);

        // hardware accelerate this... (apparently needed for quick fix)
        myCarViewListItemsContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        // load initial state of the page
        loadInitialState();
    }

    private void loadInitialState() {


         /*
        *   debug
        * */
        loadCarList();
    }

    public void loadCarList() {
        TBCarItem item = new TBCarItem(getBaseContext());
        item.setActivityReference(current);
        item.setIsAddCarButton(false);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item.setLayoutParams(params);

        item.initUI(null);



        TBCarItem itemt = new TBCarItem(getBaseContext());
        itemt.setActivityReference(current);
        itemt.setIsAddCarButton(false);

        itemt.setLayoutParams(params);

        itemt.initUI(null);


        my_car_list.addView(item);
        my_car_list.addView(itemt);
    }

    @Override
    public void BackPressed() {

    }

    @Override
    public void addButtonPressed() {
        TBUIManager.getInstance().ToPhotoActivity(current, TBPhotoActivity.CONST_FROM_CAR_LIST);
    }

    @Override
    public void itemPressed(TBUIBindingObj data) {

    }

    @Override
    public void onAnimationStart(View fromView, View toView) {

    }

    @Override
    public void onAnimationEnd(View fromView, View toView) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        profileHeaderSection.deReference();
        profileFooterSection.deReference();


        profileHeaderSection = null;
        myCarViewListItemsContent = null;
        my_car_list = null;
        profile_user_name = null;
        my_car_add_btn = null;
        profileFooterSection = null;


    }

}
