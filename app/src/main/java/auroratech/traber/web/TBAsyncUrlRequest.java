package auroratech.traber.web;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import auroratech.traber.handlers.ITBWebRequestHandler;

/**
 * Created by E on 3/30/2016.
 */
public class TBAsyncUrlRequest extends AsyncTask<Void, Void, Boolean> {

    private final String TAG = "TBAsyncUrlRequest";

    private ITBWebRequestHandler handler;
    private String url;
    private String param;

    private String requestResponse;
    private boolean requestSuccessful;

    public TBAsyncUrlRequest(ITBWebRequestHandler handler, String url, String param) {
        this.handler = handler;
        this.url = url;
        this.param = param;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        this.requestResponse = "";
        this.requestSuccessful = true;

        try {
            this.requestSuccessful = performPostCall(this.url, this.param);
            Log.e(TAG, " RESPONSE IS : " + this.requestResponse.toString());
        } catch (Exception e) {
            Log.e(TAG, "Error ..." + e.getMessage());
            this.requestResponse = e.getMessage();
            return false;
        }

        return this.requestSuccessful;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if(result.booleanValue()) {
            this.handler.onRequestCompleted(this.requestResponse);
        } else {
            this.handler.onRequestFailed(this.requestResponse);
        }
    }

    public Boolean performPostCall(String requestURL, String postDataParams) {

        URL url;
        String response = "";
        try {
            url = new URL(requestURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(30000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Type", "application/json");

            Log.e(TAG, "2 - URL : " + requestURL);
            Log.e(TAG, "3 - param : " + postDataParams);

            /*
             * JSON
             */

  /*          JSONObject root = new JSONObject();
            //

            root.put("securityInfo", Static.getSecurityInfo(context));
            root.put("advertisementId", advertisementId);

            Log.e(TAG, "12 - root : " + root.toString());*/

            //String str = root.toString();

            byte[] outputBytes = postDataParams.getBytes("UTF-8");
            OutputStream os = conn.getOutputStream();
            os.write(outputBytes);

            int responseCode = conn.getResponseCode();

            Log.e(TAG, "responseCode : " + responseCode);

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                Log.e(TAG, "Http Request Successful");

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        conn.getInputStream()));
                while ((line = br.readLine()) != null) {
                    response += line;
                }

                this.requestResponse = response;
            } else {
                throw new Exception("Server Failed to Respond");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Failed Request : " + e.getMessage());
            return false;
        }

        return true;
    }
}
