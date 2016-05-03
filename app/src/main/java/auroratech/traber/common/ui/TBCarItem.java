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
import auroratech.traber.managers.TBUIManager;
import auroratech.traber.util.AnimatorUtil;
import auroratech.traber.util.ScreenInfoUtil;

/**
 * Created by E on 4/14/2016.
 */
public class TBCarItem extends RelativeLayout implements ITBBindable {

    private TBActivityBase activityReference;
    private IItemPressed iItemPressed;
    private TBCarItem current;

    private boolean isAddCarButton;


    private int animationHeight;

    /**
     * data binding object
     */
    TBUIBindingObj internalData;


    RelativeLayout car_info_content;
    RelativeLayout car_info_inside_content;
    TextView item_carModel;
    TextView item_carYear;
    TextView item_carExpiry;
    ImageView item_carIcon;
    TextView item_renew_sticker;
    ImageView car_info_expand_btn;
    RelativeLayout car_info_detail_content;
    ImageView car_info_contract_btn;
    TextView my_car_plate_number;
    TextView my_car_insurance_number;
    TextView my_car_insurance_company;
    TextView my_car_insurance_expiry_date;
    Button my_car_edit;
    RelativeLayout item_carAdd;
    ImageView item_carAddImage;


    public void setActivityReference(TBActivityBase activity) {
        this.activityReference = activity;
        this.iItemPressed = activity;


        // need to set height here, when there is activity reference (based on dp)
        animationHeight = ScreenInfoUtil.getCorrectAnimationHeight(activityReference, 150);
    }

    public TBCarItem(Context context) {
        this(context, null);
    }
    public TBCarItem(Context context, AttributeSet attrs) {
        super(context, attrs);

        current = this;

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TBCarItem,
                0, 0);

        try {
            isAddCarButton = a.getBoolean(R.styleable.TBCarItem_isAddCarButton, false);
        } finally {
            a.recycle();
        }

        setGravity(Gravity.CENTER_VERTICAL);
        setBackgroundColor(Color.TRANSPARENT);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_tb_car_item, this, true);


        car_info_content = (RelativeLayout) findViewById(R.id.car_info_content);
        car_info_inside_content = (RelativeLayout) findViewById(R.id.car_info_inside_content);
        item_carModel = (TextView) findViewById(R.id.item_carModel);
        item_carYear = (TextView) findViewById(R.id.item_carYear);
        item_carExpiry = (TextView) findViewById(R.id.item_carExpiry);
        item_carIcon = (ImageView) findViewById(R.id.item_carIcon);
        item_renew_sticker = (TextView) findViewById(R.id.item_renew_sticker);
        car_info_expand_btn = (ImageView) findViewById(R.id.car_info_expand_btn);
        car_info_detail_content = (RelativeLayout) findViewById(R.id.car_info_detail_content);
        car_info_contract_btn = (ImageView) findViewById(R.id.car_info_contract_btn);
        my_car_plate_number = (TextView) findViewById(R.id.my_car_plate_number);
        my_car_insurance_number = (TextView) findViewById(R.id.my_car_insurance_number);
        my_car_insurance_company = (TextView) findViewById(R.id.my_car_insurance_company);
        my_car_insurance_expiry_date = (TextView) findViewById(R.id.my_car_insurance_expiry_date);
        my_car_edit = (Button) findViewById(R.id.my_car_edit);
        item_carAdd = (RelativeLayout) findViewById(R.id.item_carAdd);
        item_carAddImage = (ImageView) findViewById(R.id.item_carAddImage);


        item_renew_sticker.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: need to propagate proper date to right screen

                // ... but for now...
                TBUIManager.getInstance().ToMyCarStickerRenewal(activityReference);
            }
        });

        initUI(null);
    }


    public void setIsAddCarButton(boolean isAddCarButton) {
        this.isAddCarButton = isAddCarButton;
    }

    public void initUI(TBUIBindingObj data){

        setUpUIState();


        if(data != null) {
            // set binding for display
        }
    }

    private void setUpUIState(){

        if(isAddCarButton) {
            item_carAdd.setVisibility(VISIBLE);

            // hide car info section
            car_info_content.setVisibility(GONE);
            car_info_detail_content.setVisibility(GONE);

            // hide expander / contractor
            car_info_expand_btn.setVisibility(GONE);
            car_info_contract_btn.setVisibility(GONE);

            item_carAdd.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    //Toast.makeText(activityReference, "Add car button is clicked!", Toast.LENGTH_SHORT).show();

                    iItemPressed.addButtonPressed();
                }
            });
        }
        else {
            item_carAdd.setVisibility(GONE);

            // show car info section
            car_info_content.setVisibility(VISIBLE);
            // hide detail by default
            car_info_detail_content.setVisibility(GONE);

            // default to collapsed state
            car_info_expand_btn.setVisibility(VISIBLE);
            car_info_contract_btn.setVisibility(GONE);

            // expand to detail
            car_info_expand_btn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                // hide expand button
                car_info_expand_btn.setVisibility(GONE);

                // show collapse button
                car_info_contract_btn.setVisibility(VISIBLE);

                // show
                AnimatorUtil.expand(car_info_detail_content, 500, animationHeight, new AnimatorListenerAdapter()
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
            car_info_contract_btn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                // hide
                AnimatorUtil.expand(car_info_detail_content, 500, 0, new AnimatorListenerAdapter()
                {
                    @Override
                    public void onAnimationEnd(Animator animation)
                    {
                        // done

                        // show expand button
                        car_info_expand_btn.setVisibility(VISIBLE);

                        // hide
                        car_info_contract_btn.setVisibility(GONE);
                    }
                });

                }
            });

        }
    }
    /*
    public void destroy(){
car_info_content = null;
car_info_inside_content = null;
item_carModel = null;
item_carYear = null;
item_carExpiry = null;
item_carIcon = null;
item_renew_sticker = null;
car_info_expand_btn = null;
car_info_detail_content = null;
car_info_contract_btn = null;
my_car_plate_number = null;
my_car_insurance_number = null;
my_car_insurance_company = null;
my_car_insurance_expiry_date = null;
my_car_edit = null;
item_carAdd = null;
item_carAddImage = null;

    }
    */
}
