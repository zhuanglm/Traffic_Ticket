package auroratech.traber;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.common.ui.TBCarItem;
import auroratech.traber.handlers.ITBRequestHandler;
import auroratech.traber.handlers.ITBWebRequestUiSideHandler;
import auroratech.traber.object.TestObject;
import auroratech.traber.util.AnimatorUtil;
import auroratech.traber.util.ITBViewAnimator;
import auroratech.traber.web.TBWebResponse;


public class TBMainActivity extends TBActivityBase implements ITBRequestHandler, ITBWebRequestUiSideHandler, ITBViewAnimator {
    static final String TAG = "TBMainActivity";

    TBActivityBase current;
    ITBRequestHandler handler;
    ITBViewAnimator aHandler;

    boolean swap = false;
    AnimatorUtil aUtil = new AnimatorUtil();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        current = this;
        handler = this;
        aHandler = this;


        setContentView(R.layout.activity_main);


//        final View content_1 = (View) findViewById(R.id.contentPanel_1);
//        final View content_2 = (View) findViewById(R.id.contentPanel_2);
//
//
//
//        final TBHeader header = (TBHeader) findViewById(R.id.profileHeaderSection);
//        header.setActivityReference(this);
//
//        final TBFooter footer = (TBFooter) findViewById(R.id.profileFooterSection);
//        footer.setActivityReference(this);
//
        LinearLayout content =  (LinearLayout)findViewById(R.id.profileContentInside);
//        final TBTicketItem carAdd = (TBTicketItem) findViewById(R.id.addCar);
//        carAdd.setActivityReference(this);


        //ContextThemeWrapper newContext = new ContextThemeWrapper(getBaseContext(), R.style.MyStyle);


        TBCarItem item = new TBCarItem(getBaseContext());
        item.setActivityReference(current);
        item.setIsAddCarButton(false);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item.setLayoutParams(params);

        item.initUI(null);


        TBCarItem itemt = new TBCarItem(getBaseContext());
        itemt.setActivityReference(current);
        itemt.setIsAddCarButton(true);

        itemt.setLayoutParams(params);

        itemt.initUI(null);

        content.addView(item, 0);
        content.addView(itemt, 0);




//        Button mainCancelBtn = (Button) findViewById(R.id.testButton);
//        mainCancelBtn.setOnClickListener( new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                if(swap) {
//                    aUtil.defaultTransitionAnimation(aHandler, content_1, content_2);
//                }
//                else {
//                    aUtil.defaultTransitionAnimation(aHandler, content_2, content_1);
//                }
//
//                swap = !swap;
//            }
//        });

//        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        TextureView title_ticket = (TextureView) findViewById(R.id.title_ticket);
//        TextureView title_easy = (TextureView) findViewById(R.id.title_easy);
//        Button mainCancelBtn = (Button) findViewById(R.id.mainCancelBtn);


//        Button clickButton = (Button) findViewById(R.id.mainCancelBtn);
//        clickButton.setOnClickListener( new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//
//                //TBUIManager.getInstance().ToSignUp(current);
//                TBUIManager.getInstance().ToPhotoActivity(current);
//
////                TBWebRequest.getInstance().setActivity(handler);
////                TestObject test = new TestObject();
////                test.generateRandomContent();
////                Log.e(TAG, test.toString());
////                String testJson = "";
////                try {
////                    testJson = test.toJSON();
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                }
////                TBWebRequest.getInstance().request(TBWebRequest.REQUEST_LOGIN, TBWebRequest.NONE, testJson);
//            }
//        });
    }

    @Override
    public void onRequestHandleSuccess(TBWebResponse response) {
        Log.d(TAG, "I am here successfully");

        TestObject test = new TestObject();
        try {
            test.fromJSON(response.responseMessage);

            String str = test.toJSON();
            Log.d(TAG, "I am here successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "I am here successfully");
    }

    @Override
    public void onRequestHandleFailure(TBWebResponse response) {
        Log.d(TAG, "I failed miserably...");
    }

    @Override
    public void onAnimationStart(View fromView, View toView) {

    }

    @Override
    public void onAnimationEnd(View fromView, View toView) {

    }

    @Override
    public void onAsyncWebRequestStarted() {

    }

    @Override
    public void onAsyncWebRequestCompleted() {

    }
}
