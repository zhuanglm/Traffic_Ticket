package auroratech.traber;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.common.ui.TBTicketItem;
import auroratech.traber.common.ui.TBUIBindingObj;
import auroratech.traber.managers.TBUIManager;


public class TBMyTicketListActivity extends TBActivityBase {

    TBActivityBase current;

    auroratech.traber.common.ui.TBHeader profileHeaderSection;
    RelativeLayout myTicketViewItemsContent;
    LinearLayout my_ticket_list;
    TextView profile_user_name;
    auroratech.traber.common.ui.TBTicketItem my_ticket_add_btn;
    auroratech.traber.common.ui.TBFooter profileFooterSection;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_my_ticket_list);

        current = this;

        profileHeaderSection = (auroratech.traber.common.ui.TBHeader) findViewById(R.id.profileHeaderSection);
        myTicketViewItemsContent = (RelativeLayout) findViewById(R.id.myTicketViewItemsContent);
        my_ticket_list = (LinearLayout) findViewById(R.id.my_ticket_list);
        profile_user_name = (TextView) findViewById(R.id.profile_user_name);
        my_ticket_add_btn = (auroratech.traber.common.ui.TBTicketItem) findViewById(R.id.my_ticket_add_btn);
        profileFooterSection = (auroratech.traber.common.ui.TBFooter) findViewById(R.id.profileFooterSection);


        my_ticket_add_btn.setActivityReference(current);

        // need reference
//        my_ticket_add_btn.setActivityReference(current, (IItemPressed)current);
        profileHeaderSection.setActivityReference(current);
        profileFooterSection.setActivityReference(current);

        // hardware accelerate this... (apparently needed for quick fix)
        myTicketViewItemsContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);


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
        item.setStatus(TBTicketItem.TICKET_STATUS_PROCESSING);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item.setLayoutParams(params);

        item.initUI(null);



        TBTicketItem item2 = new TBTicketItem(getBaseContext());
        item2.setActivityReference(current);
        item2.setIsAddTicketButton(false);
        item2.setStatus(TBTicketItem.TICKET_STATUS_PAID);

        item2.setLayoutParams(params);

        item2.initUI(null);



        TBTicketItem item3 = new TBTicketItem(getBaseContext());
        item3.setActivityReference(current);
        item3.setIsAddTicketButton(false);
        item3.setStatus(TBTicketItem.TICKET_STATUS_FINISHED);

        item3.setLayoutParams(params);

        item3.initUI(null);


        my_ticket_list.addView(item);
        my_ticket_list.addView(item2);
        my_ticket_list.addView(item3);
    }



    @Override
    public void BackPressed() {
        // can't go anywhere
    }

    @Override
    public void addButtonPressed() {
        TBUIManager.getInstance().ToMyTicketAddTicket(current);
    }

    @Override
    public void itemPressed(TBUIBindingObj data) {
        // TODO: pass data to payment page

        TBUIManager.getInstance().ToMyTicketSelectPaymentOption(current);
    }


    @Override
    public void chatArrowPressed(TBUIBindingObj data) {
        // TODO:

        TBUIManager.getInstance().ToMyTicketChat(current);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        profileHeaderSection.deReference();
        profileFooterSection.deReference();

        profileHeaderSection = null;
        myTicketViewItemsContent = null;
        my_ticket_list = null;
        profile_user_name = null;
        my_ticket_add_btn = null;
        profileFooterSection = null;

    }


}
