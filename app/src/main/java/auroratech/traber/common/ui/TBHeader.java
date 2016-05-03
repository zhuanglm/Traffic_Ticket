package auroratech.traber.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import auroratech.traber.R;
import auroratech.traber.base.TBActivityBase;

/**
 * Created by E on 4/13/2016.
 */
public class TBHeader extends RelativeLayout {

    private TBActivityBase activityReference;
    private IHeaderBackPressed backPressHandler;
    private TBHeader current;
    private Context mContext;

    private boolean disableBackButton;
    private String pageTitle;

    private ImageButton backButton;
    private TextView title;



    public void setActivityReference(TBActivityBase activity) {
        this.activityReference = activity;
        this.backPressHandler = activity;
    }

    // override if needed
    public void setCallBack(IHeaderBackPressed backPressHandler) { this.backPressHandler = backPressHandler; }

    public TBHeader(Context context) {
        this(context, null);
    }
    public TBHeader(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        current = this;

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TBHeader,
                0, 0);

        try {
            disableBackButton = a.getBoolean(R.styleable.TBHeader_disableBackButton, false);
            pageTitle = a.getString(R.styleable.TBHeader_pageTitle);
        } finally {
            a.recycle();
        }

        setGravity(Gravity.CENTER_VERTICAL);
        setBackgroundResource(R.color.tb_header_blue);

        setPadding(20, 20, 0, 20);


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.menu_tbheader, this, true);

        backButton = (ImageButton) findViewById(R.id.header_backButton);
        title = (TextView) findViewById(R.id.header_title);

        // need this out, because visibility of this button can change
        backButton.setBackgroundResource(R.drawable.back);
        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(mContext, "backBtn is clicked!", Toast.LENGTH_SHORT).show();

                if (current.backPressHandler != null) {
                    // delegate back
                    current.backPressHandler.BackPressed();
                }
            }
        });

        // set events
        if (disableBackButton) {
            // hide it completely
            backButton.setVisibility(GONE);
        }

        // set title page
        title.setText(pageTitle);
    }

    public void setBackButtonVisibility(boolean visible) {
        backButton.setVisibility(visible ? VISIBLE : GONE);
    }


    public void deReference(){
        activityReference = null;
        mContext = null;
    }
}
