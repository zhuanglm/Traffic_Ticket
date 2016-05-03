package auroratech.traber;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.common.ui.TBChatItem;
import auroratech.traber.managers.TBUIManager;


public class TBMyTicketChatActivity extends TBActivityBase {

    TBActivityBase current;

    auroratech.traber.common.ui.TBHeader profileHeaderSection;
    RelativeLayout myChatViewListItemsContent;
    LinearLayout my_chat_list;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_my_ticket_chat);

        current = this;


        profileHeaderSection = (auroratech.traber.common.ui.TBHeader) findViewById(R.id.profileHeaderSection);
        myChatViewListItemsContent = (RelativeLayout) findViewById(R.id.myChatViewListItemsContent);
        my_chat_list = (LinearLayout) findViewById(R.id.my_chat_list);


        // need reference
        profileHeaderSection.setActivityReference(current);

        // hardware accelerate this... (apparently needed for quick fix)
        myChatViewListItemsContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

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
        TBChatItem item = new TBChatItem(getBaseContext());
        item.setActivityReference(current);

        item.initUI(null);

        // need to come after initUI
        item.setLeftMessage(true);
        item.setChatLeftMessage("this is a test for chat left message, which will be longer than this");



        TBChatItem itemR = new TBChatItem(getBaseContext());
        itemR.setActivityReference(current);

        itemR.initUI(null);

        // need to come after initUI
        itemR.setRightMessage(true);
        itemR.setChatRightMessage("this is a test for chat left message, which will be longer than this");


        TBChatItem itemR2 = new TBChatItem(getBaseContext());
        itemR2.setActivityReference(current);

        itemR2.initUI(null);

        // need to come after initUI
        itemR2.setRightMessage(true);
        itemR2.setChatRightMessage("this is a test for chat left message, which will be longer than this");


        my_chat_list.addView(item);
        my_chat_list.addView(itemR);
        my_chat_list.addView(itemR2);
    }



    @Override
    public void BackPressed() {
        TBUIManager.getInstance().ToMyTicketList(current);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        profileHeaderSection.deReference();


        profileHeaderSection = null;
        myChatViewListItemsContent = null;
        my_chat_list = null;

    }

}
