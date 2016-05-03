package auroratech.traber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.common.ui.TBUIBindingObj;
import auroratech.traber.managers.TBUIManager;


public class TBMyTicketSelectPaymentActivity extends TBActivityBase {

    TBActivityBase current;

    auroratech.traber.common.ui.TBHeader profileHeaderSection;
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
        setContentView(R.layout.activity_tb_my_ticket_select_payment);

        current = this;



        profileHeaderSection = (auroratech.traber.common.ui.TBHeader) findViewById(R.id.profileHeaderSection);
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



        // need reference
//        my_ticket_add_btn.setActivityReference(current, (IItemPressed)current);
        profileHeaderSection.setActivityReference(current);
        profileFooterSection.setActivityReference(current);

        // hardware accelerate this... (apparently needed for quick fix)
        myTicketSelectPackageContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        // load initial state of the page
        loadInitialState();
    }

    private void loadInitialState() {


    }



    @Override
    public void BackPressed() {
        TBUIManager.getInstance().ToMyTicketList(current);
    }


    @Override
    public void addButtonPressed() {

    }

    @Override
    public void itemPressed(TBUIBindingObj data) {

    }



/*


    profileHeaderSection = null;
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
