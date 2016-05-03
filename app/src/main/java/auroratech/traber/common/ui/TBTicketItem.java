package auroratech.traber.common.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import auroratech.traber.R;
import auroratech.traber.base.TBActivityBase;
import auroratech.traber.util.AnimatorUtil;
import auroratech.traber.util.ScreenInfoUtil;

/**
 * Created by E on 4/14/2016.
 */
public class TBTicketItem extends RelativeLayout implements ITBBindable {

    private TBActivityBase activityReference;
    private IItemPressed iItemPressed;
    private TBTicketItem current;

    private boolean isAddTicketButton;


    private int animationHeight;

    /**
     * data binding object
     */
    TBUIBindingObj internalData;


    public static final int TICKET_STATUS_SUBMITTED = 1;
    public static final int TICKET_STATUS_BEING_TAKEN = 2;
    public static final int TICKET_STATUS_WAITING_FOR_PAY = 3;
    public static final int TICKET_STATUS_PAID = 4;
    public static final int TICKET_STATUS_PROCESSING = 5;
    public static final int TICKET_STATUS_FINISHED = 6;


    RelativeLayout ticket_info_content;
    RelativeLayout ticket_info_inside_content;
    TextView ticket_number_output;
    TextView ticket_status_output;
    TextView ticket_submitted_output;
    ImageView my_ticket_chat_arrow_button;
    ImageView ticket_info_expand_btn;
    ImageView ticket_info_contract_btn;
    RelativeLayout ticket_info_detail_content;
    ImageView my_ticket_status;
    Button my_ticket_edit;
    RelativeLayout item_ticketAdd;
    ImageView item_ticketAddImage;


    public void setActivityReference(TBActivityBase activity) {
        this.activityReference = activity;
        this.iItemPressed = activity;

        // need to set height here, when there is activity reference (based on dp)
        animationHeight = ScreenInfoUtil.getCorrectAnimationHeight(activityReference, 210);
    }

    public TBTicketItem(Context context) {
        this(context, null);
    }
    public TBTicketItem(Context context, AttributeSet attrs) {
        super(context, attrs);

        current = this;

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TBTicketItem,
                0, 0);

        try {
            isAddTicketButton = a.getBoolean(R.styleable.TBTicketItem_isAddTicketButton, false);
        } finally {
            a.recycle();
        }

        setGravity(Gravity.CENTER_VERTICAL);
        setBackgroundColor(Color.TRANSPARENT);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_tb_ticket_item, this, true);





        ticket_info_content = (RelativeLayout) findViewById(R.id.ticket_info_content);
        ticket_info_inside_content = (RelativeLayout) findViewById(R.id.ticket_info_inside_content);
        ticket_number_output = (TextView) findViewById(R.id.ticket_number_output);
        ticket_status_output = (TextView) findViewById(R.id.ticket_status_output);
        ticket_submitted_output = (TextView) findViewById(R.id.ticket_submitted_output);
        my_ticket_chat_arrow_button = (ImageView) findViewById(R.id.my_ticket_chat_arrow_button);
        ticket_info_expand_btn = (ImageView) findViewById(R.id.ticket_info_expand_btn);
        ticket_info_contract_btn = (ImageView) findViewById(R.id.ticket_info_contract_btn);
        ticket_info_detail_content = (RelativeLayout) findViewById(R.id.ticket_info_detail_content);
        my_ticket_status = (ImageView) findViewById(R.id.my_ticket_status);
        my_ticket_edit = (Button) findViewById(R.id.my_ticket_edit);
        item_ticketAdd = (RelativeLayout) findViewById(R.id.item_ticketAdd);
        item_ticketAddImage = (ImageView) findViewById(R.id.item_ticketAddImage);





        my_ticket_edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                iItemPressed.itemPressed(internalData);
            }
        });


        my_ticket_chat_arrow_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                iItemPressed.chatArrowPressed(internalData);
            }
        });


        initUI(null);
    }


    public void setIsAddTicketButton(boolean isAddTicketButton) {
        this.isAddTicketButton = isAddTicketButton;
    }

    public void initUI(TBUIBindingObj data){

        setUpUIState();

        /*
        *   debug
        * */
        internalData = data;

         if(data != null) {
            // set binding for display
            internalData = data;
        }
    }

    private void setUpUIState(){

        if(isAddTicketButton) {
            item_ticketAdd.setVisibility(VISIBLE);

            // hide car info section
            ticket_info_content.setVisibility(GONE);
            ticket_info_detail_content.setVisibility(GONE);

            // hide expander / contractor
            ticket_info_expand_btn.setVisibility(GONE);
            ticket_info_contract_btn.setVisibility(GONE);

            item_ticketAdd.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    //Toast.makeText(activityReference, "Add car button is clicked!", Toast.LENGTH_SHORT).show();

                    iItemPressed.addButtonPressed();
                }
            });
        }
        else {
            item_ticketAdd.setVisibility(GONE);

            // show car info section
            ticket_info_content.setVisibility(VISIBLE);
            // hide detail by default
            ticket_info_detail_content.setVisibility(GONE);

            // default to collapsed state
            ticket_info_expand_btn.setVisibility(VISIBLE);
            ticket_info_contract_btn.setVisibility(GONE);

            // expand to detail
            ticket_info_expand_btn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                // hide expand button
                    ticket_info_expand_btn.setVisibility(GONE);

                    // show
                    ticket_info_contract_btn.setVisibility(VISIBLE);

                // show
                AnimatorUtil.expand(ticket_info_detail_content, 500, animationHeight, new AnimatorListenerAdapter()
                {
                    @Override
                    public void onAnimationEnd(Animator animation)
                    {
                        // done
                    }
                });
                }
            });

            // hide details
            ticket_info_contract_btn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                // hide
                AnimatorUtil.expand(ticket_info_detail_content, 500, 0, new AnimatorListenerAdapter()
                {
                    @Override
                    public void onAnimationEnd(Animator animation)
                    {
                        // done

                        // show expand button
                        ticket_info_expand_btn.setVisibility(VISIBLE);

                        // hide
                        ticket_info_contract_btn.setVisibility(GONE);
                    }
                });

                }
            });

        }
    }

    public void setStatus(int status) {
        switch (status) {
            case TICKET_STATUS_SUBMITTED: {
                my_ticket_status.setImageResource(R.drawable.status_submitted);
                break;
            }
            case TICKET_STATUS_BEING_TAKEN: {
                my_ticket_status.setImageResource(R.drawable.status_being_taken);
                break;
            }
            case TICKET_STATUS_WAITING_FOR_PAY: {
                my_ticket_status.setImageResource(R.drawable.status_waiting_for_pay);
                break;
            }
            case TICKET_STATUS_PAID: {
                my_ticket_status.setImageResource(R.drawable.status_paid);
                break;
            }
            case TICKET_STATUS_PROCESSING: {
                my_ticket_status.setImageResource(R.drawable.status_processing);
                break;
            }
            case TICKET_STATUS_FINISHED: {
                my_ticket_status.setImageResource(R.drawable.status_finished);
                break;
            }
        }
    }

/*

ticket_info_content = null;
ticket_info_inside_content = null;
ticket_number_output = null;
ticket_status_output = null;
ticket_submitted_output = null;
my_ticket_chat_arrow_button = null;
ticket_info_expand_btn = null;
ticket_info_contract_btn = null;
ticket_info_detail_content = null;
my_ticket_status = null;
my_ticket_edit = null;
item_ticketAdd = null;
item_ticketAddImage = null;


*/



}
