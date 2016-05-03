package auroratech.traber;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.common.ui.TBUIBindingObj;
import auroratech.traber.managers.TBTransitionObjectManager;
import auroratech.traber.managers.TBUIManager;
import auroratech.traber.util.ITBViewAnimator;


public class TBMyCarAddCarActivity extends TBActivityBase implements ITBViewAnimator {

    TBActivityBase current;

    auroratech.traber.common.ui.TBHeader profileHeaderSection;
    RelativeLayout myCarViewListItemsContent;
    RelativeLayout myCarAddNewItemsContent;
    RelativeLayout car_picture_section;
    ImageView crossBox;
    ImageView car_picture;
    TextView my_ticket_press_to_take_picture;
    LinearLayout plate_number_content;
    EditText plate_number;
    LinearLayout insurance_section;
    TextView insurance_section_title;
    TextView add_car_company_text;
    EditText insurance_company;
    TextView add_car_number_text;
    EditText insurance_number;
    TextView add_car_exp_text;
    EditText insurance_expiry_date;
    ImageButton insurance_expiry_date_button;
    LinearLayout car_info_section;
    TextView car_info_section_title;
    TextView car_info_sticker_exp_date_text;
    EditText car_info_sticker_expiry_date;
    ImageButton car_info_sticker_expiry_date_button;
    TextView car_info_car_model_date_text;
    EditText car_info_car_model_date;
    TextView car_info_car_year_text;
    EditText car_info_car_year;
    Button car_info_add_car_btn;
    auroratech.traber.common.ui.TBFooter profileFooterSection;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_my_car_add_car);

        current = this;



        profileHeaderSection = (auroratech.traber.common.ui.TBHeader) findViewById(R.id.profileHeaderSection);
        myCarViewListItemsContent = (RelativeLayout) findViewById(R.id.myCarViewListItemsContent);
        myCarAddNewItemsContent = (RelativeLayout) findViewById(R.id.myCarAddNewItemsContent);
        car_picture_section = (RelativeLayout) findViewById(R.id.car_picture_section);
        crossBox = (ImageView) findViewById(R.id.crossBox);
        car_picture = (ImageView) findViewById(R.id.car_picture);
        my_ticket_press_to_take_picture = (TextView) findViewById(R.id.my_ticket_press_to_take_picture);
        plate_number_content = (LinearLayout) findViewById(R.id.plate_number_content);
        plate_number = (EditText) findViewById(R.id.plate_number);
        insurance_section = (LinearLayout) findViewById(R.id.insurance_section);
        insurance_section_title = (TextView) findViewById(R.id.insurance_section_title);
        add_car_company_text = (TextView) findViewById(R.id.add_car_company_text);
        insurance_company = (EditText) findViewById(R.id.insurance_company);
        add_car_number_text = (TextView) findViewById(R.id.add_car_number_text);
        insurance_number = (EditText) findViewById(R.id.insurance_number);
        add_car_exp_text = (TextView) findViewById(R.id.add_car_exp_text);
        insurance_expiry_date = (EditText) findViewById(R.id.insurance_expiry_date);
        insurance_expiry_date_button = (ImageButton) findViewById(R.id.insurance_expiry_date_button);
        car_info_section = (LinearLayout) findViewById(R.id.car_info_section);
        car_info_section_title = (TextView) findViewById(R.id.car_info_section_title);
        car_info_sticker_exp_date_text = (TextView) findViewById(R.id.car_info_sticker_exp_date_text);
        car_info_sticker_expiry_date = (EditText) findViewById(R.id.car_info_sticker_expiry_date);
        car_info_sticker_expiry_date_button = (ImageButton) findViewById(R.id.car_info_sticker_expiry_date_button);
        car_info_car_model_date_text = (TextView) findViewById(R.id.car_info_car_model_date_text);
        car_info_car_model_date = (EditText) findViewById(R.id.car_info_car_model_date);
        car_info_car_year_text = (TextView) findViewById(R.id.car_info_car_year_text);
        car_info_car_year = (EditText) findViewById(R.id.car_info_car_year);
        car_info_add_car_btn = (Button) findViewById(R.id.car_info_add_car_btn);
        profileFooterSection = (auroratech.traber.common.ui.TBFooter) findViewById(R.id.profileFooterSection);



        // need reference
        profileHeaderSection.setActivityReference(current);
        profileFooterSection.setActivityReference(current);

        // hardware accelerate this... (apparently needed for quick fix)
        myCarViewListItemsContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);


        car_picture_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TBUIManager.getInstance().ToPhotoActivity(current, TBPhotoActivity.CONST_FROM_ADD_CAR);
            }
        });

        // load initial state of the page
        loadInitialState();

        loadTakenImage();
    }

    private void loadInitialState() {


    }


    @Override
    public void BackPressed() {

        //
        TBTransitionObjectManager.getInstance().deleteAllImage();

        TBUIManager.getInstance().ToMyCarList(current);
    }

    @Override
    public void addButtonPressed() {

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

    private void loadTakenImage() {

        Uri fileUri = TBTransitionObjectManager.getInstance().acceptableFile;

        if(fileUri != null) {

            crossBox.setVisibility(View.GONE);
            my_ticket_press_to_take_picture.setVisibility(View.GONE);

            // bitmap factory
            BitmapFactory.Options options = new BitmapFactory.Options();

            // downsizing image as it throws OutOfMemory Exception for larger
            // images
            options.inSampleSize = 8;


            final Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(),
                    options);

            car_picture.setImageBitmap(bitmap);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        profileHeaderSection.deReference();
        profileFooterSection.deReference();


        profileHeaderSection = null;
        myCarViewListItemsContent = null;
        myCarAddNewItemsContent = null;
        car_picture_section = null;
        car_picture = null;
        my_ticket_press_to_take_picture = null;
        plate_number_content = null;
        plate_number = null;
        insurance_section = null;
        insurance_section_title = null;
        add_car_company_text = null;
        insurance_company = null;
        add_car_number_text = null;
        insurance_number = null;
        add_car_exp_text = null;
        insurance_expiry_date = null;
        insurance_expiry_date_button = null;
        car_info_section = null;
        car_info_section_title = null;
        car_info_sticker_exp_date_text = null;
        car_info_sticker_expiry_date = null;
        car_info_sticker_expiry_date_button = null;
        car_info_car_model_date_text = null;
        car_info_car_model_date = null;
        car_info_car_year_text = null;
        car_info_car_year = null;
        car_info_add_car_btn = null;
        profileFooterSection = null;


    }


}
