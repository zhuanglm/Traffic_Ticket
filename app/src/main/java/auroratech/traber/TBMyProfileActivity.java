package auroratech.traber;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.managers.TBTransitionObjectManager;
import auroratech.traber.managers.TBUIManager;
import auroratech.traber.util.AnimatorUtil;
import auroratech.traber.util.ITBViewAnimator;

/**
 * Created by E on 3/29/2016.
 */
public class TBMyProfileActivity extends TBActivityBase implements ITBViewAnimator {

    public static final String ToProfilePage = "TAG_PROFILE";

    private boolean toProfile;

    TBActivityBase current;
    ITBViewAnimator animator;


    auroratech.traber.common.ui.TBHeader profileHeaderSection;
    RelativeLayout myProfileSettingContent;
    TextView profile_user_name;
    TextView my_profile_logout;
    RelativeLayout profile_email_section;
    TextView profile_email;
    RelativeLayout profile_phone_section;
    TextView profile_phone;
    RelativeLayout profile_driver_license_section;
    ImageView profile_driver_license_button;
    RelativeLayout profile_privacy_and_term_section;
    ImageView profile_privacy_term_button;
    RelativeLayout profile_help_section;
    ImageView profile_help_button;
    RelativeLayout profile_setting_section;
    ImageView profile_setting_button;
    RelativeLayout profile_language_section;
    RelativeLayout profile_my_message_section;
    ImageView profile_my_message_button;
    RelativeLayout profile_share_this_app;
    RelativeLayout myProfileHelpSectionContent;
    RelativeLayout profile_help_about_us_link;
    RelativeLayout profile_help_call_us_link;
    RelativeLayout profile_help_faq_link;
    RelativeLayout myProfileSettingSectionContent;
    RelativeLayout profile_push_notification_section;
    ToggleButton profile_push_notification_toggle;
    RelativeLayout profile_case_update_notification_section;
    ToggleButton profile_case_update_notification_toggle;
    RelativeLayout myProfileChangeContent;
    RelativeLayout my_driver_license_picture_section;
    ImageView crossBox;
    ImageView my_driver_license_picture;
    TextView my_driver_license_picture_press_to_take_picture;
    TextView driver_licence_name_text;
    EditText driver_license_name;
    TextView driver_licence_name_address;
    EditText driver_license_address_text;
    TextView driver_licence_phone_number_text;
    EditText driver_licence_phone_number;
    TextView driver_license_iss_text;
    EditText driver_license_iss;
    ImageButton driver_license_iss_button;
    TextView driver_license_dob_text;
    EditText driver_license_dob;
    ImageButton driver_license_dob_button;
    TextView driver_license_expiry_text;
    EditText driver_license_expiry;
    ImageButton driver_license_expiry_button;
    TextView driver_license_height_text;
    EditText driver_license_height;
    TextView driver_license_height_label;
    TextView driver_license_sex_text;
    RadioGroup driver_license_sex_option;
    RadioButton driver_license_male;
    RadioButton driver_license_female;
    Spinner driver_license_class;
    EditText driver_license_rest;
    Button driver_license_save_button;
    auroratech.traber.common.ui.TBFooter profileFooterSection;


    /*
ProfileMain
ProfileHelp
ProfileSetting
ProfileDriverLicense
    * */
    boolean ProfileMain;
    boolean ProfileHelp;
    boolean ProfileSetting;
    boolean ProfileDriverLicense;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        current = this;
        animator = this;

        setContentView(R.layout.activity_my_profile);



        profileHeaderSection = (auroratech.traber.common.ui.TBHeader) findViewById(R.id.profileHeaderSection);
        myProfileSettingContent = (RelativeLayout) findViewById(R.id.myProfileSettingContent);
        profile_user_name = (TextView) findViewById(R.id.profile_user_name);
        my_profile_logout = (TextView) findViewById(R.id.my_profile_logout);
        profile_email_section = (RelativeLayout) findViewById(R.id.profile_email_section);
        profile_email = (TextView) findViewById(R.id.profile_email);
        profile_phone_section = (RelativeLayout) findViewById(R.id.profile_phone_section);
        profile_phone = (TextView) findViewById(R.id.profile_phone);
        profile_driver_license_section = (RelativeLayout) findViewById(R.id.profile_driver_license_section);
        profile_driver_license_button = (ImageView) findViewById(R.id.profile_driver_license_button);
        profile_privacy_and_term_section = (RelativeLayout) findViewById(R.id.profile_privacy_and_term_section);
        profile_privacy_term_button = (ImageView) findViewById(R.id.profile_privacy_term_button);
        profile_help_section = (RelativeLayout) findViewById(R.id.profile_help_section);
        profile_help_button = (ImageView) findViewById(R.id.profile_help_button);
        profile_setting_section = (RelativeLayout) findViewById(R.id.profile_setting_section);
        profile_setting_button = (ImageView) findViewById(R.id.profile_setting_button);
        profile_language_section = (RelativeLayout) findViewById(R.id.profile_language_section);
        profile_my_message_section = (RelativeLayout) findViewById(R.id.profile_my_message_section);
        profile_my_message_button = (ImageView) findViewById(R.id.profile_my_message_button);
        profile_share_this_app = (RelativeLayout) findViewById(R.id.profile_share_this_app);
        myProfileHelpSectionContent = (RelativeLayout) findViewById(R.id.myProfileHelpSectionContent);
        profile_help_about_us_link = (RelativeLayout) findViewById(R.id.profile_help_about_us_link);
        profile_help_call_us_link = (RelativeLayout) findViewById(R.id.profile_help_call_us_link);
        profile_help_faq_link = (RelativeLayout) findViewById(R.id.profile_help_faq_link);
        myProfileSettingSectionContent = (RelativeLayout) findViewById(R.id.myProfileSettingSectionContent);
        profile_push_notification_section = (RelativeLayout) findViewById(R.id.profile_push_notification_section);
        profile_push_notification_toggle = (ToggleButton) findViewById(R.id.profile_push_notification_toggle);
        profile_case_update_notification_section = (RelativeLayout) findViewById(R.id.profile_case_update_notification_section);
        profile_case_update_notification_toggle = (ToggleButton) findViewById(R.id.profile_case_update_notification_toggle);
        myProfileChangeContent = (RelativeLayout) findViewById(R.id.myProfileChangeContent);
        my_driver_license_picture_section = (RelativeLayout) findViewById(R.id.my_driver_license_picture_section);
        crossBox = (ImageView) findViewById(R.id.crossBox);
        my_driver_license_picture = (ImageView) findViewById(R.id.my_driver_license_picture);
        my_driver_license_picture_press_to_take_picture = (TextView) findViewById(R.id.my_driver_license_picture_press_to_take_picture);
        driver_licence_name_text = (TextView) findViewById(R.id.driver_licence_name_text);
        driver_license_name = (EditText) findViewById(R.id.driver_license_name);
        driver_licence_name_address = (TextView) findViewById(R.id.driver_licence_name_address);
        driver_license_address_text = (EditText) findViewById(R.id.driver_license_address_text);
        driver_licence_phone_number_text = (TextView) findViewById(R.id.driver_licence_phone_number_text);
        driver_licence_phone_number = (EditText) findViewById(R.id.driver_licence_phone_number);
        driver_license_iss_text = (TextView) findViewById(R.id.driver_license_iss_text);
        driver_license_iss = (EditText) findViewById(R.id.driver_license_iss);
        driver_license_iss_button = (ImageButton) findViewById(R.id.driver_license_iss_button);
        driver_license_dob_text = (TextView) findViewById(R.id.driver_license_dob_text);
        driver_license_dob = (EditText) findViewById(R.id.driver_license_dob);
        driver_license_dob_button = (ImageButton) findViewById(R.id.driver_license_dob_button);
        driver_license_expiry_text = (TextView) findViewById(R.id.driver_license_expiry_text);
        driver_license_expiry = (EditText) findViewById(R.id.driver_license_expiry);
        driver_license_expiry_button = (ImageButton) findViewById(R.id.driver_license_expiry_button);
        driver_license_height_text = (TextView) findViewById(R.id.driver_license_height_text);
        driver_license_height = (EditText) findViewById(R.id.driver_license_height);
        driver_license_height_label = (TextView) findViewById(R.id.driver_license_height_label);
        driver_license_sex_text = (TextView) findViewById(R.id.driver_license_sex_text);
        driver_license_sex_option = (RadioGroup) findViewById(R.id.driver_license_sex_option);
        driver_license_male = (RadioButton) findViewById(R.id.driver_license_male);
        driver_license_female = (RadioButton) findViewById(R.id.driver_license_female);
        driver_license_class = (Spinner) findViewById(R.id.driver_license_class);
        driver_license_rest = (EditText) findViewById(R.id.driver_license_rest);
        driver_license_save_button = (Button) findViewById(R.id.driver_license_save_button);
        profileFooterSection = (auroratech.traber.common.ui.TBFooter) findViewById(R.id.profileFooterSection);




        Intent intent = getIntent();
        toProfile = intent.getBooleanExtra(ToProfilePage, false);


        my_profile_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //
                TBTransitionObjectManager.getInstance().deleteAllImage();

                TBUIManager.getInstance().ToLogin(current);
            }
        });


        View.OnClickListener helpTransition = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorUtil.defaultTransitionAnimation(animator, myProfileSettingContent, myProfileHelpSectionContent);
                SetState_ProfileHelp();
            }
        };

        profile_help_button.setOnClickListener(helpTransition);
        profile_help_section.setOnClickListener(helpTransition);


        View.OnClickListener settingTransition = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorUtil.defaultTransitionAnimation(animator, myProfileSettingContent, myProfileSettingSectionContent);
                SetState_ProfileSetting();
            }
        };

        profile_setting_button.setOnClickListener(settingTransition);
        profile_setting_section.setOnClickListener(settingTransition);


        View.OnClickListener driverLicenseTransition = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorUtil.defaultTransitionAnimation(animator, myProfileSettingContent, myProfileChangeContent);
                SetState_ProfileDriverLicense();
            }
        };

        profile_driver_license_button.setOnClickListener(driverLicenseTransition);
        profile_driver_license_section.setOnClickListener(driverLicenseTransition);


        // need reference
        profileHeaderSection.setActivityReference(current);
        profileFooterSection.setActivityReference(current);


        myProfileSettingContent.setVisibility(View.GONE);
        myProfileSettingSectionContent.setVisibility(View.GONE);
        myProfileHelpSectionContent.setVisibility(View.GONE);
        myProfileChangeContent.setVisibility(View.GONE);


        if(toProfile) {
            myProfileChangeContent.setVisibility(View.VISIBLE);
        } else {
            myProfileSettingContent.setVisibility(View.VISIBLE);
        }


        // hardware accelerate this... (apparently needed for quick fix)
        myProfileSettingContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        myProfileSettingSectionContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        myProfileHelpSectionContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        myProfileChangeContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);


        my_driver_license_picture_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TBUIManager.getInstance().ToPhotoActivity(current, TBPhotoActivity.CONST_FROM_ADD_DRIVER_LICENSE);
            }
        });

        /*Button clickButton = (Button) findViewById(R.id.mainCancelBtn);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                TBUIManager.getInstance().ToSignUp(current);
            }
        });*/

        // load initial state of the page
        loadInitialState();


        loadTakenImage();
    }


    private void loadInitialState() {

        ResetStates();

        if(toProfile) {
            SetState_ProfileDriverLicense();
        }
        else {
            //
            SetState_ProfileMain();
        }
    }

    private void ResetStates() {
        ProfileMain = false;
        ProfileHelp = false;
        ProfileSetting = false;
        ProfileDriverLicense = false;
    }



    private void SetState_ProfileMain() {
        ProfileMain = true;
        ProfileHelp = false;
        ProfileSetting = false;
        ProfileDriverLicense = false;
        StateChanged();

    }

    private void SetState_ProfileHelp() {
        ProfileMain = false;
        ProfileHelp = true;
        ProfileSetting = false;
        ProfileDriverLicense = false;
        StateChanged();

    }

    private void SetState_ProfileSetting() {
        ProfileMain = false;
        ProfileHelp = false;
        ProfileSetting = true;
        ProfileDriverLicense = false;
        StateChanged();

    }

    private void SetState_ProfileDriverLicense() {
        ProfileMain = false;
        ProfileHelp = false;
        ProfileSetting = false;
        ProfileDriverLicense = true;
        StateChanged();

    }


    private void StateChangedBackButtonStatusUpdate() {
        if (ProfileMain){
            profileHeaderSection.setBackButtonVisibility(false);

        }
        if (ProfileHelp){
            profileHeaderSection.setBackButtonVisibility(true);

        }
        if (ProfileSetting){
            profileHeaderSection.setBackButtonVisibility(true);

        }
        if (ProfileDriverLicense){
            profileHeaderSection.setBackButtonVisibility(true);

        }
    }

    private void StateChanged() {
        StateChangedBackButtonStatusUpdate();

    }

   /*
     private void StateChanged() {
        if (ProfileMain){


        }
        if (ProfileHelp){


        }
        if (ProfileSetting){


        }
        if (ProfileDriverLicense){


        }
    }*/



    @Override
    public void BackPressed() {
        // for back press from header

        /*
        *  TODO: should actually call web request here and transition when successful
        * */

         if (ProfileHelp){
            AnimatorUtil.defaultTransitionAnimation(this, myProfileHelpSectionContent, myProfileSettingContent);
            SetState_ProfileMain();

        } else  if (ProfileSetting){
            AnimatorUtil.defaultTransitionAnimation(this, myProfileSettingSectionContent, myProfileSettingContent);
            SetState_ProfileMain();

        } else if (ProfileDriverLicense){
            AnimatorUtil.defaultTransitionAnimation(this, myProfileChangeContent, myProfileSettingContent);
            SetState_ProfileMain();
        }

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
            my_driver_license_picture_press_to_take_picture.setVisibility(View.GONE);

            // bitmap factory
            BitmapFactory.Options options = new BitmapFactory.Options();

            // downsizing image as it throws OutOfMemory Exception for larger
            // images
            options.inSampleSize = 8;


            final Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(),
                    options);

            my_driver_license_picture.setImageBitmap(bitmap);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        profileHeaderSection.deReference();
        profileFooterSection.deReference();



/*

profileHeaderSection = null;
myProfileSettingContent = null;
profile_user_name = null;
my_profile_logout = null;
profile_email_section = null;
profile_email = null;
profile_phone_section = null;
profile_phone = null;
profile_driver_license_section = null;
profile_driver_license_button = null;
profile_privacy_and_term_section = null;
profile_privacy_term_button = null;
profile_help_section = null;
profile_help_button = null;
profile_setting_section = null;
profile_setting_button = null;
profile_language_section = null;
profile_my_message_section = null;
profile_my_message_button = null;
profile_share_this_app = null;
myProfileHelpSectionContent = null;
profile_help_about_us_link = null;
profile_help_call_us_link = null;
profile_help_faq_link = null;
myProfileSettingSectionContent = null;
profile_push_notification_section = null;
profile_push_notification_toggle = null;
profile_case_update_notification_section = null;
profile_case_update_notification_toggle = null;
myProfileChangeContent = null;
my_driver_license_picture_section = null;
crossBox = null;
my_driver_license_picture = null;
my_driver_license_picture_press_to_take_picture = null;
driver_licence_name_text = null;
driver_license_name = null;
driver_licence_name_address = null;
driver_license_address_text = null;
driver_licence_phone_number_text = null;
driver_licence_phone_number = null;
driver_license_iss_text = null;
driver_license_iss = null;
driver_license_iss_button = null;
driver_license_dob_text = null;
driver_license_dob = null;
driver_license_dob_button = null;
driver_license_expiry_text = null;
driver_license_expiry = null;
driver_license_expiry_button = null;
driver_license_height_text = null;
driver_license_height = null;
driver_license_height_label = null;
driver_license_sex_text = null;
driver_license_sex_option = null;
driver_license_male = null;
driver_license_female = null;
driver_license_class = null;
driver_license_rest = null;
driver_license_save_button = null;
profileFooterSection = null;


*/

}
    public void resetFields() {
        driver_license_name.setText("");
        driver_license_address_text.setText("");
        driver_licence_phone_number.setText("");
        driver_license_iss.setText("");
        driver_license_dob.setText("");
        driver_license_expiry.setText("");
        driver_license_height.setText("");
        driver_license_rest.setText("");
    }

}
