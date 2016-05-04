package auroratech.traber;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.common.ui.TBUIBindingObj;
import auroratech.traber.managers.TBTransitionObjectManager;
import auroratech.traber.managers.TBUIManager;


public class TBMyTicketAddTicketActivity extends TBActivityBase {

    TBActivityBase current;

    auroratech.traber.common.ui.TBHeader profileHeaderSection;
    RelativeLayout myTicketAddItemsContent;
    RelativeLayout my_ticket_heading;
    TextView my_ticket_display;
    RelativeLayout ticket_picture_section;
    ImageView crossBox;
    ImageView ticket_picture;
    TextView my_ticket_press_to_take_picture;
    LinearLayout city_selection_content;
    Spinner my_ticket_city_dropdown;
    RelativeLayout comment_section;
    TextView comment_section_comment_text;
    EditText comment_section_comment_content;
    auroratech.traber.common.ui.TBFooter profileFooterSection;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_my_ticket_add_ticket);

        current = this;



        profileHeaderSection = (auroratech.traber.common.ui.TBHeader) findViewById(R.id.profileHeaderSection);
        myTicketAddItemsContent = (RelativeLayout) findViewById(R.id.myTicketAddItemsContent);
        my_ticket_heading = (RelativeLayout) findViewById(R.id.my_ticket_heading);
        my_ticket_display = (TextView) findViewById(R.id.my_ticket_display);
        ticket_picture_section = (RelativeLayout) findViewById(R.id.ticket_picture_section);
        crossBox = (ImageView) findViewById(R.id.crossBox);
        ticket_picture = (ImageView) findViewById(R.id.ticket_picture);
        my_ticket_press_to_take_picture = (TextView) findViewById(R.id.my_ticket_press_to_take_picture);
        city_selection_content = (LinearLayout) findViewById(R.id.city_selection_content);
        my_ticket_city_dropdown = (Spinner) findViewById(R.id.my_ticket_city_dropdown);
        comment_section = (RelativeLayout) findViewById(R.id.comment_section);
        comment_section_comment_text = (TextView) findViewById(R.id.comment_section_comment_text);
        comment_section_comment_content = (EditText) findViewById(R.id.comment_section_comment_content);
        profileFooterSection = (auroratech.traber.common.ui.TBFooter) findViewById(R.id.profileFooterSection);



        // need reference
//        my_ticket_add_btn.setActivityReference(current, (IItemPressed)current);
        profileHeaderSection.setActivityReference(current);
        profileFooterSection.setActivityReference(current);


        // hardware accelerate this... (apparently needed for quick fix)
        myTicketAddItemsContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);


        ticket_picture_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TBUIManager.getInstance().ToPhotoActivity(current, TBPhotoActivity.CONST_FROM_ADD_TICKET);
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

        TBUIManager.getInstance().ToMyTicketList(current);
    }

    @Override
    public void addButtonPressed() {

    }

    @Override
    public void itemPressed(TBUIBindingObj data) {

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

            ticket_picture.setImageBitmap(bitmap);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        profileHeaderSection.deReference();
        profileFooterSection.deReference();


        profileHeaderSection = null;
        myTicketAddItemsContent = null;
        my_ticket_heading = null;
        my_ticket_display = null;
        ticket_picture_section = null;
        ticket_picture = null;
        my_ticket_press_to_take_picture = null;
        city_selection_content = null;
        my_ticket_city_dropdown = null;
        comment_section = null;
        comment_section_comment_text = null;
        comment_section_comment_content = null;
        profileFooterSection = null;

    }


}
