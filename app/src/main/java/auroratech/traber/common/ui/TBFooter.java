package auroratech.traber.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import auroratech.traber.R;
import auroratech.traber.base.TBActivityBase;
import auroratech.traber.managers.TBTransitionObjectManager;
import auroratech.traber.managers.TBUIManager;

/**
 * Created by E on 4/13/2016.
 */

public class TBFooter extends LinearLayout {

    private TBActivityBase activityReference;
    private Context mContext;

    private int disableClickOption;

    private ImageButton mTicketBtn;
    private ImageButton mCarBtn;
    private ImageButton mProfileBtn;

    private final int OPTION_DISABLE_TICKET = 1;
    private final int OPTION_DISABLE_CAR = 2;
    private final int OPTION_DISABLE_PROFILE = 3;

    public void setActivityReference(TBActivityBase activity) {
        this.activityReference = activity;
    }
    public TBFooter(Context context) {
        this(context, null);
    }
    public TBFooter(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TBFooter,
                0, 0);

        try {
            disableClickOption = a.getInteger(R.styleable.TBFooter_disableClickableOption, 0);
        } finally {
            a.recycle();
        }

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        setBackgroundResource(R.color.background_material_dark);

        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        setLayoutParams(linearParams);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.menu_tbfooter, this, true);

//        mTicketBtn = (ImageButton) getChildAt(0);
//        mCarBtn = (ImageButton) getChildAt(1);
//        mProfileBtn = (ImageButton) getChildAt(2);

        mTicketBtn = (ImageButton) findViewById(R.id.footer_ticket);
        mCarBtn = (ImageButton) findViewById(R.id.footer_car);
        mProfileBtn = (ImageButton) findViewById(R.id.footer_profile);


        setDefaultImageForButtons();

        // now disable the button not supposed to be used
        disableUnUsedButton();

        OnClickListener pressed = new OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = null;

                // just in case
                TBTransitionObjectManager.getInstance().deleteAllImage();

                switch (v.getId()) {

                    case R.id.footer_ticket:
//                        msg = "mTicketBtn";
                        TBUIManager.getInstance().ToMyTicketList(activityReference);
                        break;

                    case R.id.footer_car:
//                        msg = "mCarBtn";
                        TBUIManager.getInstance().ToMyCarList(activityReference);
                        break;

                    case R.id.footer_profile:
//                        msg = "mProfileBtn";
                        TBUIManager.getInstance().ToMyProfile(activityReference);
                        break;

                    default:
                        break;
                }

                //Toast.makeText(mContext, msg + " is clicked!", Toast.LENGTH_SHORT).show();
            }
        };

        // attach events, not going to link to other activity for now, since only need to make page transition
        mTicketBtn.setOnClickListener(pressed);
        mCarBtn.setOnClickListener(pressed);
        mProfileBtn.setOnClickListener(pressed);
    }


    private void setDefaultImageForButtons() {
        mTicketBtn.setBackgroundResource(R.drawable.footer_white1);
        mCarBtn.setBackgroundResource(R.drawable.footer_white2);
        mProfileBtn.setBackgroundResource(R.drawable.footer_white3);
    }

    private void disableUnUsedButton(){
        if (disableClickOption == OPTION_DISABLE_TICKET){
            mTicketBtn.setEnabled(false);

            mCarBtn.setBackgroundResource(R.drawable.footer_grey2);
            mProfileBtn.setBackgroundResource(R.drawable.footer_grey3);

        } else if (disableClickOption == OPTION_DISABLE_CAR){
            mCarBtn.setEnabled(false);

            mTicketBtn.setBackgroundResource(R.drawable.footer_grey1);
            mProfileBtn.setBackgroundResource(R.drawable.footer_grey3);

        } else if (disableClickOption == OPTION_DISABLE_PROFILE){
            mProfileBtn.setEnabled(false);

            mTicketBtn.setBackgroundResource(R.drawable.footer_grey1);
            mCarBtn.setBackgroundResource(R.drawable.footer_grey2);

        }
    }


    public void deReference(){
        activityReference = null;
        mContext = null;
    }
}

