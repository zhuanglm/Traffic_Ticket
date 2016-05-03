package auroratech.traber.web;

import auroratech.traber.handlers.ITBRequestHandler;
import auroratech.traber.handlers.ITBWebRequestHandler;
import auroratech.traber.handlers.ITBWebRequestUiSideHandler;

/**
 * Created by E on 3/30/2016.
 */
public class TBWebRequest implements ITBWebRequestHandler {

    static final String baseURL = "http://10.35.190.117:8124";
    static final String CAPCHA_URL = "";


    String URL_REGISTER;
    String URL_LOGIN;
    String URL_ADD_TICKET;
    String URL_REVIEW_TICKET_INFO;
    String URL_REVIEW_TICKET_DETAIL;
    String URL_TICKET_CHAT;
    String URL_ADD_STICKER;
    String URL_REVIEW_STICKER_INFO;
    String URL_REVIEW_STICKER_DETAIL;
    String URL_STICKER_CHAT;

    /*
    *   OPTIONS
    * */
    public static final int NONE = 0;

    public static final int GET_CAPCHA = 1;
    public static final int REQUEST_LOGIN = 2;
    public static final int REQUEST_FORGOT_PASSWORD = 3;

    public static final int GET_TICKET_INFO = 4;
    public static final int GET_STICKER_INFO = 5;
    public static final int GET_PROFILE_INFO = 6;

    /*
    *   TICKET SUB PAGES
    * */


    /*
    *   STICKER SUB PAGES
    * */

    private static TBWebRequest instance;

    private int currentRequest;
    private int currentPageRequest;

    private ITBRequestHandler activity;
    private ITBWebRequestUiSideHandler activityUi;
    public void setActivity(ITBRequestHandler activity, ITBWebRequestUiSideHandler activityUi) {
        this.activity = activity;
        this.activityUi = activityUi;
    }


    private TBWebRequest(){

        URL_REGISTER = baseURL + "/user/register";
        URL_LOGIN = baseURL + "/user/login";
        URL_ADD_TICKET = baseURL + "/ticket/add";
        URL_REVIEW_TICKET_INFO = baseURL + "/ticket/mylist";
        URL_REVIEW_TICKET_DETAIL = baseURL + "/ticket/detail";
        URL_TICKET_CHAT = baseURL + "/ticket/chats";
        URL_ADD_STICKER = baseURL + "/sticker/add";
        URL_REVIEW_STICKER_INFO = baseURL + "/sticker/mylist";
        URL_REVIEW_STICKER_DETAIL = baseURL + "/sticker/detail";
        URL_STICKER_CHAT = baseURL + "/sticker/chats";

    }

    public static synchronized TBWebRequest getInstance( ) {
        if(instance == null) {
            instance = new TBWebRequest();
        }
        return instance;
    }

    public void request(int request, int subPage, String param){

        currentRequest = request;
        currentPageRequest = subPage;

        String requestURL = null;
        switch (request) {
            case REQUEST_LOGIN:
                requestURL =  URL_LOGIN;
                break;

        }

        // update UI
        activityUi.onAsyncWebRequestStarted();

        TBAsyncUrlRequest r = new TBAsyncUrlRequest(this, requestURL, param);
        r.execute();
    }

    @Override
    public void onRequestCompleted(String response) {
        TBWebResponse resp = new TBWebResponse();
        resp.responseMessage = response;
        this.activity.onRequestHandleSuccess(resp);

        // update UI
        activityUi.onAsyncWebRequestCompleted();
    }

    @Override
    public void onRequestFailed(String response) {
        TBWebResponse resp = new TBWebResponse();
        resp.responseMessage = response;
        this.activity.onRequestHandleFailure(resp);

        // update UI
        activityUi.onAsyncWebRequestCompleted();
    }
}
