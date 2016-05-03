package auroratech.traber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.common.ui.IHeaderBackPressed;
import auroratech.traber.common.ui.IItemPressed;
import auroratech.traber.common.ui.TBCarItem;
import auroratech.traber.common.ui.TBUIBindingObj;
import auroratech.traber.util.AnimatorUtil;
import auroratech.traber.util.ITBViewAnimator;


public class TBMyCarActivity extends TBActivityBase implements IItemPressed, ITBViewAnimator, IHeaderBackPressed {

    /*
    *
    *   ! OBSOLETE ! - BASE TEST WITH ANIMATION (IS NOW SPLITTED)
    *
    * */
    TBActivityBase current;
    ITBViewAnimator iTBViewAnimator;

    auroratech.traber.common.ui.TBHeader profileHeaderSection;
    RelativeLayout myCarViewListItemsContent;
    LinearLayout my_car_list;
    auroratech.traber.common.ui.TBCarItem my_car_add_btn;
    RelativeLayout myCarAddNewItemsContent;
    ImageView car_picture;
    LinearLayout plate_number_content;
    EditText plate_number;
    LinearLayout insurance_section;
    TextView insurance_section_title;
    EditText insurance_company;
    EditText insurance_number;
    EditText insurance_expiry_date;
    ImageButton insurance_expiry_date_button;
    LinearLayout car_info_section;
    TextView car_info_section_title;
    EditText car_info_sticker_expiry_date;
    ImageButton car_info_sticker_expiry_date_button;
    EditText sticker_info_car_info_insurance_number;
    RelativeLayout myCarStickerReviewContent;
    LinearLayout sticker_renewal_car_info_section;
    TextView sticker_renewal_car_info_section_title;
    EditText sticker_renewal_car_info_model;
    EditText sticker_renewal_car_info_sticker_expiry_date;
    ImageButton sticker_renewal_car_info_sticker_expiry_date_button;
    EditText sticker_renewal_car_info_plate_number;
    EditText sticker_renewal_car_info_miles;
    EditText sticker_renewal_car_info_insurance_number;
    LinearLayout sticker_renewal_renew_sticker_section;
    RadioButton radioButtonOptionOne;
    RadioButton radioButtonOptionTwo;
    LinearLayout sticker_renewal_privacy_section;
    TextView sticker_renewal_privacy_policy_link;
    Button sticker_renewal_pay_button;
    auroratech.traber.common.ui.TBFooter profileFooterSection;


    /*
MyCarListPage
AddCarPage
StickerRenewalPage
    * */

    boolean MyCarListPage;
    boolean AddCarPage;
    boolean StickerRenewalPage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        current = this;
        iTBViewAnimator = this;

        setContentView(R.layout.activity_my_car);



        profileHeaderSection = (auroratech.traber.common.ui.TBHeader) findViewById(R.id.profileHeaderSection);
        myCarViewListItemsContent = (RelativeLayout) findViewById(R.id.myCarViewListItemsContent);
        my_car_list = (LinearLayout) findViewById(R.id.my_car_list);
        my_car_add_btn = (auroratech.traber.common.ui.TBCarItem) findViewById(R.id.my_car_add_btn);
        myCarAddNewItemsContent = (RelativeLayout) findViewById(R.id.myCarAddNewItemsContent);
        car_picture = (ImageView) findViewById(R.id.car_picture);
        plate_number_content = (LinearLayout) findViewById(R.id.plate_number_content);
        plate_number = (EditText) findViewById(R.id.plate_number);
        insurance_section = (LinearLayout) findViewById(R.id.insurance_section);
        insurance_section_title = (TextView) findViewById(R.id.insurance_section_title);
        insurance_company = (EditText) findViewById(R.id.insurance_company);
        insurance_number = (EditText) findViewById(R.id.insurance_number);
        insurance_expiry_date = (EditText) findViewById(R.id.insurance_expiry_date);
        insurance_expiry_date_button = (ImageButton) findViewById(R.id.insurance_expiry_date_button);
        car_info_section = (LinearLayout) findViewById(R.id.car_info_section);
        car_info_section_title = (TextView) findViewById(R.id.car_info_section_title);
        car_info_sticker_expiry_date = (EditText) findViewById(R.id.car_info_sticker_expiry_date);
        car_info_sticker_expiry_date_button = (ImageButton) findViewById(R.id.car_info_sticker_expiry_date_button);
        sticker_info_car_info_insurance_number = (EditText) findViewById(R.id.sticker_info_car_info_insurance_number);
        myCarStickerReviewContent = (RelativeLayout) findViewById(R.id.myCarStickerReviewContent);
        sticker_renewal_car_info_section = (LinearLayout) findViewById(R.id.sticker_renewal_car_info_section);
        sticker_renewal_car_info_section_title = (TextView) findViewById(R.id.sticker_renewal_car_info_section_title);
        sticker_renewal_car_info_model = (EditText) findViewById(R.id.sticker_renewal_car_info_model);
        sticker_renewal_car_info_sticker_expiry_date = (EditText) findViewById(R.id.sticker_renewal_car_info_sticker_expiry_date);
        sticker_renewal_car_info_sticker_expiry_date_button = (ImageButton) findViewById(R.id.sticker_renewal_car_info_sticker_expiry_date_button);
        sticker_renewal_car_info_plate_number = (EditText) findViewById(R.id.sticker_renewal_car_info_plate_number);
        sticker_renewal_car_info_miles = (EditText) findViewById(R.id.sticker_renewal_car_info_miles);
        sticker_renewal_car_info_insurance_number = (EditText) findViewById(R.id.sticker_renewal_car_info_insurance_number);
        sticker_renewal_renew_sticker_section = (LinearLayout) findViewById(R.id.sticker_renewal_renew_sticker_section);
        radioButtonOptionOne = (RadioButton) findViewById(R.id.radioButtonOptionOne);
        radioButtonOptionTwo = (RadioButton) findViewById(R.id.radioButtonOptionTwo);
        sticker_renewal_privacy_section = (LinearLayout) findViewById(R.id.sticker_renewal_privacy_section);
        sticker_renewal_privacy_policy_link = (TextView) findViewById(R.id.sticker_renewal_privacy_policy_link);
        sticker_renewal_pay_button = (Button) findViewById(R.id.sticker_renewal_pay_button);
        profileFooterSection = (auroratech.traber.common.ui.TBFooter) findViewById(R.id.profileFooterSection);



        // need reference
        my_car_add_btn.setActivityReference(current);
        profileFooterSection.setActivityReference(current);


        // load initial state of the page
        loadInitialState();
    }


    private void loadInitialState() {

        // state resets
        ResetStates();
        SetState_MyCarListPage();


        // request server for info

        // when back, if there's no data, then show good driver

        // otherwise, populate the list of cars (for now, just populate)

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
    public void addButtonPressed() {

        AnimatorUtil.defaultTransitionAnimation(iTBViewAnimator, myCarViewListItemsContent, myCarAddNewItemsContent);

        // now we are in add car page
        SetState_AddCarPage();

    }

    @Override
    public void itemPressed(TBUIBindingObj data) {
        // hide item list, show individual item edit
    }

    @Override
    public void onAnimationStart(View fromView, View toView) {

    }

    @Override
    public void onAnimationEnd(View fromView, View toView) {

    }



    public void ResetStates() {
        MyCarListPage = false;
        AddCarPage = false;
        StickerRenewalPage = false;
    }


    public void SetState_MyCarListPage() {
        MyCarListPage = true;
        AddCarPage = false;
        StickerRenewalPage = false;
    }

    public void SetState_AddCarPage() {
        MyCarListPage = false;
        AddCarPage = true;
        StickerRenewalPage = false;
    }

    public void SetState_StickerRenewalPage() {
        MyCarListPage = false;
        AddCarPage = false;
        StickerRenewalPage = true;
    }

    private void StateChanged() {
        if (MyCarListPage){


        }
        if (AddCarPage){


        }
        if (StickerRenewalPage){


        }
    }

    @Override
    public void BackPressed() {

    }

/*    public void destroy(){

profileHeaderSection = null;
myCarViewListItemsContent = null;
my_car_list = null;
my_car_add_btn = null;
myCarAddNewItemsContent = null;
car_picture = null;
plate_number_content = null;
plate_number = null;
insurance_section = null;
insurance_section_title = null;
insurance_company = null;
insurance_number = null;
insurance_expiry_date = null;
insurance_expiry_date_button = null;
car_info_section = null;
car_info_section_title = null;
car_info_sticker_expiry_date = null;
car_info_sticker_expiry_date_button = null;
sticker_info_car_info_insurance_number = null;
myCarStickerReviewContent = null;
sticker_renewal_car_info_section = null;
sticker_renewal_car_info_section_title = null;
sticker_renewal_car_info_model = null;
sticker_renewal_car_info_sticker_expiry_date = null;
sticker_renewal_car_info_sticker_expiry_date_button = null;
sticker_renewal_car_info_plate_number = null;
sticker_renewal_car_info_miles = null;
sticker_renewal_car_info_insurance_number = null;
sticker_renewal_renew_sticker_section = null;
radioButtonOptionOne = null;
radioButtonOptionTwo = null;
sticker_renewal_privacy_section = null;
sticker_renewal_privacy_policy_link = null;
sticker_renewal_pay_button = null;
profileFooterSection = null;




    }*/
}
