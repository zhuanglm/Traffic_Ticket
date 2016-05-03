package auroratech.traber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.common.ui.IHeaderBackPressed;
import auroratech.traber.managers.TBUIManager;


public class TBMyCarStickerRenewalActivity extends TBActivityBase implements IHeaderBackPressed {

    TBActivityBase current;


    auroratech.traber.common.ui.TBHeader profileHeaderSection;
    RelativeLayout myCarViewListItemsContent;
    LinearLayout myCarStickerReviewContent;
    LinearLayout sticker_renewal_car_info_section;
    TextView sticker_renewal_car_info_section_title;
    EditText sticker_renewal_car_info_model;
    EditText sticker_renewal_car_info_sticker_expiry_date;
    ImageButton sticker_renewal_car_info_sticker_expiry_date_button;
    EditText sticker_renewal_car_info_plate_number;
    EditText sticker_renewal_car_info_miles;
    EditText sticker_renewal_car_info_insurance_number;
    LinearLayout sticker_renewal_shipping_info_section;
    EditText sticker_renewal_shipping_info_section_name;
    EditText sticker_renewal_shipping_info_section_address;
    EditText sticker_renewal_shipping_info_section_city;
    EditText sticker_renewal_shipping_info_section_province;
    EditText sticker_renewal_shipping_info_section_postal_code;
    LinearLayout sticker_renewal_renew_sticker_section;
    RadioButton radioButtonOptionOne;
    RadioButton radioButtonOptionTwo;
    LinearLayout sticker_renewal_privacy_section;
    TextView sticker_renewal_privacy_policy_link;
    Button sticker_renewal_pay_button;
    auroratech.traber.common.ui.TBFooter profileFooterSection;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_my_car_sticker_renewal);

        current = this;




        profileHeaderSection = (auroratech.traber.common.ui.TBHeader) findViewById(R.id.profileHeaderSection);
        myCarViewListItemsContent = (RelativeLayout) findViewById(R.id.myCarViewListItemsContent);
        myCarStickerReviewContent = (LinearLayout) findViewById(R.id.myCarStickerReviewContent);
        sticker_renewal_car_info_section = (LinearLayout) findViewById(R.id.sticker_renewal_car_info_section);
        sticker_renewal_car_info_section_title = (TextView) findViewById(R.id.sticker_renewal_car_info_section_title);
        sticker_renewal_car_info_model = (EditText) findViewById(R.id.sticker_renewal_car_info_model);
        sticker_renewal_car_info_sticker_expiry_date = (EditText) findViewById(R.id.sticker_renewal_car_info_sticker_expiry_date);
        sticker_renewal_car_info_sticker_expiry_date_button = (ImageButton) findViewById(R.id.sticker_renewal_car_info_sticker_expiry_date_button);
        sticker_renewal_car_info_plate_number = (EditText) findViewById(R.id.sticker_renewal_car_info_plate_number);
        sticker_renewal_car_info_miles = (EditText) findViewById(R.id.sticker_renewal_car_info_miles);
        sticker_renewal_car_info_insurance_number = (EditText) findViewById(R.id.sticker_renewal_car_info_insurance_number);
        sticker_renewal_shipping_info_section = (LinearLayout) findViewById(R.id.sticker_renewal_shipping_info_section);
        sticker_renewal_shipping_info_section_name = (EditText) findViewById(R.id.sticker_renewal_shipping_info_section_name);
        sticker_renewal_shipping_info_section_address = (EditText) findViewById(R.id.sticker_renewal_shipping_info_section_address);
        sticker_renewal_shipping_info_section_city = (EditText) findViewById(R.id.sticker_renewal_shipping_info_section_city);
        sticker_renewal_shipping_info_section_province = (EditText) findViewById(R.id.sticker_renewal_shipping_info_section_province);
        sticker_renewal_shipping_info_section_postal_code = (EditText) findViewById(R.id.sticker_renewal_shipping_info_section_postal_code);
        sticker_renewal_renew_sticker_section = (LinearLayout) findViewById(R.id.sticker_renewal_renew_sticker_section);
        radioButtonOptionOne = (RadioButton) findViewById(R.id.radioButtonOptionOne);
        radioButtonOptionTwo = (RadioButton) findViewById(R.id.radioButtonOptionTwo);
        sticker_renewal_privacy_section = (LinearLayout) findViewById(R.id.sticker_renewal_privacy_section);
        sticker_renewal_privacy_policy_link = (TextView) findViewById(R.id.sticker_renewal_privacy_policy_link);
        sticker_renewal_pay_button = (Button) findViewById(R.id.sticker_renewal_pay_button);
        profileFooterSection = (auroratech.traber.common.ui.TBFooter) findViewById(R.id.profileFooterSection);




        // need reference
        profileHeaderSection.setActivityReference(current);
        profileFooterSection.setActivityReference(current);

        // hardware accelerate this... (apparently needed for quick fix)
        myCarViewListItemsContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);


        // load initial state of the page
        loadInitialState();
    }

    private void loadInitialState() {


    }

    @Override
    public void BackPressed() {
        TBUIManager.getInstance().ToMyCarList(current);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        profileHeaderSection.deReference();
        profileFooterSection.deReference();



        profileHeaderSection = null;
        myCarViewListItemsContent = null;
        myCarStickerReviewContent = null;
        sticker_renewal_car_info_section = null;
        sticker_renewal_car_info_section_title = null;
        sticker_renewal_car_info_model = null;
        sticker_renewal_car_info_sticker_expiry_date = null;
        sticker_renewal_car_info_sticker_expiry_date_button = null;
        sticker_renewal_car_info_plate_number = null;
        sticker_renewal_car_info_miles = null;
        sticker_renewal_car_info_insurance_number = null;
        sticker_renewal_shipping_info_section = null;
        sticker_renewal_shipping_info_section_name = null;
        sticker_renewal_shipping_info_section_address = null;
        sticker_renewal_shipping_info_section_city = null;
        sticker_renewal_shipping_info_section_province = null;
        sticker_renewal_shipping_info_section_postal_code = null;
        sticker_renewal_renew_sticker_section = null;
        radioButtonOptionOne = null;
        radioButtonOptionTwo = null;
        sticker_renewal_privacy_section = null;
        sticker_renewal_privacy_policy_link = null;
        sticker_renewal_pay_button = null;
        profileFooterSection = null;


    }


}
