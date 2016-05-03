package auroratech.traber;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.managers.TBUIManager;


public class TBSignUpActivity extends TBActivityBase {

    Activity current;

    ImageView titleView;
    RelativeLayout email_layout;
    EditText login_email;
    ImageView username_icon;
    RelativeLayout password_layout;
    EditText login_password;
    ImageView password_icon;
    RelativeLayout repeat_password_layout;
    EditText login_password_repeat;
    ImageView repeat_password_icon;
    LinearLayout policy_layout;
    TextView sign_up_privacy_policy_link;
    Button signUpBtn;
    LinearLayout sign_in_link_layout;
    TextView signUpLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        current = this;

        setContentView(R.layout.activity_sign_up);



        titleView = (ImageView) findViewById(R.id.titleView);
        email_layout = (RelativeLayout) findViewById(R.id.email_layout);
        login_email = (EditText) findViewById(R.id.login_email);
        username_icon = (ImageView) findViewById(R.id.username_icon);
        password_layout = (RelativeLayout) findViewById(R.id.password_layout);
        login_password = (EditText) findViewById(R.id.login_password);
        password_icon = (ImageView) findViewById(R.id.password_icon);
        repeat_password_layout = (RelativeLayout) findViewById(R.id.repeat_password_layout);
        login_password_repeat = (EditText) findViewById(R.id.login_password_repeat);
        repeat_password_icon = (ImageView) findViewById(R.id.repeat_password_icon);
        policy_layout = (LinearLayout) findViewById(R.id.policy_layout);
        sign_up_privacy_policy_link = (TextView) findViewById(R.id.sign_up_privacy_policy_link);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);
        sign_in_link_layout = (LinearLayout) findViewById(R.id.sign_in_link_layout);
        signUpLink = (TextView) findViewById(R.id.signUpLink);



        signUpLink.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                TBUIManager.getInstance().ToLogin(current);
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        titleView = null;
        email_layout = null;
        login_email = null;
        username_icon = null;
        password_layout = null;
        login_password = null;
        password_icon = null;
        repeat_password_layout = null;
        login_password_repeat = null;
        repeat_password_icon = null;
        policy_layout = null;
        sign_up_privacy_policy_link = null;
        signUpBtn = null;
        sign_in_link_layout = null;
        signUpLink = null;
    }

}
