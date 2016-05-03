package auroratech.traber.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import auroratech.traber.R;
import auroratech.traber.base.TBActivityBase;

/**
 * Created by E on 4/13/2016.
 */
public class TBChatItem extends RelativeLayout implements ITBBindable {

    private TBActivityBase activityReference;
    private TBChatItem current;

    private Context mContext;

    private boolean isLeftMessage = false;
    private boolean isRightMessage = false;
    private String leftMessage;
    private String rightMessage;

    /**
     * data binding object
     */
    TBUIBindingObj internalData;


    RelativeLayout chatLeftMessageSection;
    ImageView chatLeftIcon;
    auroratech.traber.common.ui.TBChatTriangleShape chatLeftArrow;
    TextView chatLeftMessage;
    RelativeLayout chatRightMessageSection;
    TextView chatRightMessage;
    auroratech.traber.common.ui.TBChatTriangleShape chatRightMessageArrow;
    ImageView chatRightMessageImage;





    public void setActivityReference(TBActivityBase activity) {
        this.activityReference = activity;

    }


    public TBChatItem(Context context) {
        this(context, null);
    }
    public TBChatItem(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        current = this;

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TBChatItem,
                0, 0);

        try {
            isLeftMessage = a.getBoolean(R.styleable.TBChatItem_isLeftMessage, false);
            isRightMessage = a.getBoolean(R.styleable.TBChatItem_isRightMessage, false);
            leftMessage = a.getString(R.styleable.TBChatItem_leftMessage);
            rightMessage = a.getString(R.styleable.TBChatItem_rightMessage);
        } finally {
            a.recycle();
        }

        setGravity(Gravity.CENTER_VERTICAL);
        setBackgroundColor(Color.TRANSPARENT);

        //setPadding(20, 20, 0, 20);


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_tb_chat_item, this, true);



        chatLeftMessageSection = (RelativeLayout) findViewById(R.id.chatLeftMessageSection);
        chatLeftIcon = (ImageView) findViewById(R.id.chatLeftIcon);
        chatLeftArrow = (auroratech.traber.common.ui.TBChatTriangleShape) findViewById(R.id.chatLeftArrow);
        chatLeftMessage = (TextView) findViewById(R.id.chatLeftMessage);
        chatRightMessageSection = (RelativeLayout) findViewById(R.id.chatRightMessageSection);
        chatRightMessage = (TextView) findViewById(R.id.chatRightMessage);
        chatRightMessageArrow = (auroratech.traber.common.ui.TBChatTriangleShape) findViewById(R.id.chatRightMessageArrow);
        chatRightMessageImage = (ImageView) findViewById(R.id.chatRightMessageImage);



        // reset (hides all)
        resetUI();

        // set state for message
        setLeftMessage(isLeftMessage);
        setRightMessage(isRightMessage);

        // set message
        setChatLeftMessage(leftMessage);
        setChatRightMessage(rightMessage);
    }

    @Override
    public void initUI(TBUIBindingObj data){

        resetUI();

        /*
        *   debug
        * */
        internalData = data;

        if(data != null) {
            // set binding for display
            internalData = data;
        }
    }

    public void resetUI() {
        chatLeftMessageSection.setVisibility(GONE);
        chatRightMessageSection.setVisibility(GONE);
    }

    public void setLeftMessage(boolean leftMessage) {
        if (leftMessage) {
            chatLeftMessageSection.setVisibility(VISIBLE);
            chatRightMessageSection.setVisibility(GONE);
        }
    }

    public void setChatLeftMessage(String message){
        chatLeftMessage.setText(message);
    }

    public void setRightMessage(boolean rightMessage) {
        if(rightMessage) {
            chatLeftMessageSection.setVisibility(GONE);
            chatRightMessageSection.setVisibility(VISIBLE);
        }
    }

    public void setChatRightMessage(String message) {
        chatRightMessage.setText(message);
    }





/*

chatLeftMessageSection = null;
chatLeftIcon = null;
chatLeftArrow = null;
chatLeftMessage = null;
chatRightMessageSection = null;
chatRightMessage = null;
chatRightMessageArrow = null;
chatRightMessageImage = null;


*/




    public void resetFields() {
    }




}
