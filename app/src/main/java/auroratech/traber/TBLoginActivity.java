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


public class TBLoginActivity extends TBActivityBase {

    Activity current;

    ImageView titleView;
    RelativeLayout email_layout;
    EditText login_email;
    ImageView username_icon;
    RelativeLayout password_layout;
    EditText login_password;
    ImageView password_icon;
    RelativeLayout special_sign_in;
    ImageView wechat_icon;
    ImageView facebook_icon;
    LinearLayout forgot_password_layout;
    Button signInBtn;
    LinearLayout sign_in_link_layout;
    TextView signUpLink;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        current = this;


        titleView = (ImageView) findViewById(R.id.titleView);
        email_layout = (RelativeLayout) findViewById(R.id.email_layout);
        login_email = (EditText) findViewById(R.id.login_email);
        username_icon = (ImageView) findViewById(R.id.username_icon);
        password_layout = (RelativeLayout) findViewById(R.id.password_layout);
        login_password = (EditText) findViewById(R.id.login_password);
        password_icon = (ImageView) findViewById(R.id.password_icon);
        special_sign_in = (RelativeLayout) findViewById(R.id.special_sign_in);
        wechat_icon = (ImageView) findViewById(R.id.wechat_icon);
        facebook_icon = (ImageView) findViewById(R.id.facebook_icon);
        forgot_password_layout = (LinearLayout) findViewById(R.id.forgot_password_layout);
        signInBtn = (Button) findViewById(R.id.signInBtn);
        sign_in_link_layout = (LinearLayout) findViewById(R.id.sign_in_link_layout);
        signUpLink = (TextView) findViewById(R.id.signUpLink);



        // should actually make web request and transition by status, but for now, just transition
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TBUIManager.getInstance().ToMyTicketList(current);
            }
        });

        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // move to signup page
                TBUIManager.getInstance().ToSignUp(current);
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
        special_sign_in = null;
        wechat_icon = null;
        facebook_icon = null;
        forgot_password_layout = null;
        signInBtn = null;
        sign_in_link_layout = null;
        signUpLink = null;

    }

}
