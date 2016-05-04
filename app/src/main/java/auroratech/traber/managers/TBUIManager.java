package auroratech.traber.managers;

import android.app.Activity;
import android.content.Intent;

import auroratech.traber.TBMyTicketChatActivity;
import auroratech.traber.TBPhotoActivity;
import auroratech.traber.TBForgotPasswordActivity;
import auroratech.traber.TBLoginActivity;
import auroratech.traber.TBMainActivity;
import auroratech.traber.TBMyCarAddCarActivity;
import auroratech.traber.TBMyCarListActivity;
import auroratech.traber.TBMyCarStickerRenewalActivity;
import auroratech.traber.TBMyProfileActivity;
import auroratech.traber.TBMyTicketAddTicketActivity;
import auroratech.traber.TBMyTicketListActivity;
import auroratech.traber.TBMyTicketSelectPaymentActivity;
import auroratech.traber.TBSignUpActivity;


/**
 * Created by E on 3/29/2016.
 */
public class TBUIManager {

    /*
    *   list of activities available
    *
    *       Main
    *       Login
    *       Sign Up
    *       Forgot Password
    *
    *       Tickets
    *       Sticker
    *       Profile
    *
    *       PhotoActivity
    * */

    private static TBUIManager instance;

    private TBUIManager(){ }

    public static synchronized TBUIManager getInstance( ) {
        if(instance == null) {
            instance = new TBUIManager();
        }
        return instance;
    }

    public void ToMain(Activity activity){
        transition(activity, TBMainActivity.class);
    }

    public void ToLogin(Activity activity){
        transition(activity, TBLoginActivity.class);
    }

    public void ToSignUp(Activity activity){
        transition(activity, TBSignUpActivity.class);
    }

    public void ToForgotPassword(Activity activity){
        transition(activity, TBForgotPasswordActivity.class);
    }

    // obsolete
//    public void ToMyTicket(Activity activity){
//        transition(activity, TBMyTicketActivity.class);
//    }

    public void ToMyTicketList(Activity activity){
        transition(activity, TBMyTicketListActivity.class);
    }

    public void ToMyTicketAddTicket(Activity activity){
        transition(activity, TBMyTicketAddTicketActivity.class);
    }

    public void ToMyTicketSelectPaymentOption(Activity activity){
        transition(activity, TBMyTicketSelectPaymentActivity.class);
    }

    public void ToMyTicketChat(Activity activity) {
        transition(activity, TBMyTicketChatActivity.class);
    }

    // obsolete
//    public void ToMyCar(Activity activity){ transition(activity, TBMyCarActivity.class); }

    public void ToMyCarList(Activity activity){
        transition(activity, TBMyCarListActivity.class);
    }
    public void ToMyCarAddCar(Activity activity){
        transition(activity, TBMyCarAddCarActivity.class);
    }
    public void ToMyCarStickerRenewal(Activity activity){
        transition(activity, TBMyCarStickerRenewalActivity.class);
    }

    public void ToMyProfile(Activity activity){ transition(activity, TBMyProfileActivity.class ); }
    public void ToMyProfileAddLicensePage(Activity activity){
        Intent intent = getTransitionIntent(activity, TBMyProfileActivity.class);

        // just tell photo activity where the incoming activity is
        intent.putExtra(TBMyProfileActivity.ToProfilePage, true);

        transitionWithCustomIntent(activity, intent); }


    public void ToPhotoActivity(Activity activity) {
        transition(activity, TBPhotoActivity.class);
    }
    public void ToPhotoActivity(Activity activity, String fromActivity) {
        Intent intent = getTransitionIntent(activity, TBPhotoActivity.class);

        // just tell photo activity where the incoming activity is
        intent.putExtra(TBPhotoActivity.TAG_FROM_ACTIVITY, fromActivity);

        transitionWithCustomIntent(activity, intent);
    }


    private void transition(Activity srcActivity, Class destActivity) {
        Intent intent = new Intent(srcActivity, destActivity);
        srcActivity.startActivity(intent);
        srcActivity.finish();
    }

    private Intent getTransitionIntent(Activity srcActivity, Class destActivity) {
        return new Intent(srcActivity, destActivity);
    }

    public void transitionWithCustomIntent (Activity srcActivity, Intent intent){
        srcActivity.startActivity(intent);
        srcActivity.finish();
    }
}
