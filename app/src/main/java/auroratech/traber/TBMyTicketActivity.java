package auroratech.traber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.common.ui.IItemPressed;
import auroratech.traber.common.ui.TBTicketItem;
import auroratech.traber.common.ui.TBUIBindingObj;

/**
 * Created by E on 3/29/2016.
 */
public class TBMyTicketActivity extends TBActivityBase implements IItemPressed {

    /*
    *
    *   BASE TEST WITH ANIMATION (IS NOW SPLITTED)
    *
    * */

    TBActivityBase current;


    auroratech.traber.common.ui.TBHeader profileHeaderSection;
    RelativeLayout myTicketNoTicket;
    RelativeLayout myTicketViewItemsContent;
    LinearLayout my_ticket_list;
    TextView profile_user_name;
    auroratech.traber.common.ui.TBTicketItem my_ticket_add_btn;
    RelativeLayout myTicketAddItemsContent;
    LinearLayout my_ticket_heading;
    TextView my_ticket_display;
    ImageView ticket_picture;
    LinearLayout city_selection_content;
    RelativeLayout comment_section;
    TextView comment_section_comment_text;
    EditText comment_section_comment_content;
    RelativeLayout myTicketSelectPackageContent;
    TextView payment_package_title;
    LinearLayout option_one_content;
    RelativeLayout option_one_content_description;
    TextView option_one_content_description_title;
    TextView option_one_content_description_content;
    LinearLayout option_one_privacy_policy_section;
    CheckBox option_one_privacy_policy_checkbox;
    TextView option_one_privacy_policy_link;
    Button option_one_buy_now_button;
    LinearLayout option_two_content;
    RelativeLayout option_two_content_description;
    TextView option_two_content_description_title;
    TextView option_two_content_description_content;
    LinearLayout option_two_privacy_policy_section;
    CheckBox option_two_privacy_policy_checkbox;
    TextView option_two_privacy_policy_link;
    Button option_two_buy_now_button;
    auroratech.traber.common.ui.TBFooter profileFooterSection;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        current = this;

        setContentView(R.layout.activity_my_ticket);



        profileHeaderSection = (auroratech.traber.common.ui.TBHeader) findViewById(R.id.profileHeaderSection);
        myTicketNoTicket = (RelativeLayout) findViewById(R.id.myTicketNoTicket);
        myTicketViewItemsContent = (RelativeLayout) findViewById(R.id.myTicketViewItemsContent);
        my_ticket_list = (LinearLayout) findViewById(R.id.my_ticket_list);
        profile_user_name = (TextView) findViewById(R.id.profile_user_name);
        my_ticket_add_btn = (auroratech.traber.common.ui.TBTicketItem) findViewById(R.id.my_ticket_add_btn);
        myTicketAddItemsContent = (RelativeLayout) findViewById(R.id.myTicketAddItemsContent);
        my_ticket_heading = (LinearLayout) findViewById(R.id.my_ticket_heading);
        my_ticket_display = (TextView) findViewById(R.id.my_ticket_display);
        ticket_picture = (ImageView) findViewById(R.id.ticket_picture);
        city_selection_content = (LinearLayout) findViewById(R.id.city_selection_content);
        comment_section = (RelativeLayout) findViewById(R.id.comment_section);
        comment_section_comment_text = (TextView) findViewById(R.id.comment_section_comment_text);
        comment_section_comment_content = (EditText) findViewById(R.id.comment_section_comment_content);
        myTicketSelectPackageContent = (RelativeLayout) findViewById(R.id.myTicketSelectPackageContent);
        payment_package_title = (TextView) findViewById(R.id.payment_package_title);
        option_one_content = (LinearLayout) findViewById(R.id.option_one_content);
        option_one_content_description = (RelativeLayout) findViewById(R.id.option_one_content_description);
        option_one_content_description_title = (TextView) findViewById(R.id.option_one_content_description_title);
        option_one_content_description_content = (TextView) findViewById(R.id.option_one_content_description_content);
        option_one_privacy_policy_section = (LinearLayout) findViewById(R.id.option_one_privacy_policy_section);
        option_one_privacy_policy_checkbox = (CheckBox) findViewById(R.id.option_one_privacy_policy_checkbox);
        option_one_privacy_policy_link = (TextView) findViewById(R.id.option_one_privacy_policy_link);
        option_one_buy_now_button = (Button) findViewById(R.id.option_one_buy_now_button);
        option_two_content = (LinearLayout) findViewById(R.id.option_two_content);
        option_two_content_description = (RelativeLayout) findViewById(R.id.option_two_content_description);
        option_two_content_description_title = (TextView) findViewById(R.id.option_two_content_description_title);
        option_two_content_description_content = (TextView) findViewById(R.id.option_two_content_description_content);
        option_two_privacy_policy_section = (LinearLayout) findViewById(R.id.option_two_privacy_policy_section);
        option_two_privacy_policy_checkbox = (CheckBox) findViewById(R.id.option_two_privacy_policy_checkbox);
        option_two_privacy_policy_link = (TextView) findViewById(R.id.option_two_privacy_policy_link);
        option_two_buy_now_button = (Button) findViewById(R.id.option_two_buy_now_button);
        profileFooterSection = (auroratech.traber.common.ui.TBFooter) findViewById(R.id.profileFooterSection);



        profileFooterSection.setActivityReference(current);
        my_ticket_add_btn.setActivityReference(current);

        // need reference
//        my_ticket_add_btn.setActivityReference(current, (IItemPressed)current);
        profileFooterSection.setActivityReference(current);

        // hardware accelerate this... (apparently needed for quick fix)
        myTicketViewItemsContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        myTicketAddItemsContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        myTicketSelectPackageContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

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
        TBTicketItem item = new TBTicketItem(getBaseContext());
        item.setActivityReference(current);
        item.setIsAddTicketButton(false);
        item.setStatus(3);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item.setLayoutParams(params);

        item.initUI(null);



        TBTicketItem itemt = new TBTicketItem(getBaseContext());
        itemt.setActivityReference(current);
        itemt.setIsAddTicketButton(false);
        item.setStatus(4);

        itemt.setLayoutParams(params);

        itemt.initUI(null);


        my_ticket_list.addView(item);
        my_ticket_list.addView(itemt);
    }

    @Override
    public void addButtonPressed() {

    }

    @Override
    public void itemPressed(TBUIBindingObj data) {

    }


/*


profileHeaderSection = null;
myTicketNoTicket = null;
myTicketViewItemsContent = null;
my_ticket_list = null;
profile_user_name = null;
my_ticket_add_btn = null;
myTicketAddItemsContent = null;
my_ticket_heading = null;
my_ticket_display = null;
ticket_picture = null;
city_selection_content = null;
comment_section = null;
comment_section_comment_text = null;
comment_section_comment_content = null;
myTicketSelectPackageContent = null;
payment_package_title = null;
option_one_content = null;
option_one_content_description = null;
option_one_content_description_title = null;
option_one_content_description_content = null;
option_one_privacy_policy_section = null;
option_one_privacy_policy_checkbox = null;
option_one_privacy_policy_link = null;
option_one_buy_now_button = null;
option_two_content = null;
option_two_content_description = null;
option_two_content_description_title = null;
option_two_content_description_content = null;
option_two_privacy_policy_section = null;
option_two_privacy_policy_checkbox = null;
option_two_privacy_policy_link = null;
option_two_buy_now_button = null;
profileFooterSection = null;



*/

}
