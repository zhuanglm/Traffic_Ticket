package auroratech.traber.object;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

import auroratech.traber.util.TBRandom;

/**
 * Created by E on 4/4/2016.
 */
public class NonPrimative {
    String testStr1;
    int testInt;
    String testStr2;


    public String toJSON() throws JSONException {
        JSONObject obj = new JSONObject();
        JSONArray jAry = new JSONArray();
        obj.put("testStr1", new String(testStr1));
        obj.put("testInt", new Integer(testInt));
        obj.put("testStr2", new String(testStr2));
        return obj.toString();
    }
    public void fromJSON(String json) throws Exception {
        JSONObject obj = new JSONObject(json);
        JSONArray array;
        testStr1 = obj.getString("testStr1");
        testInt = obj.getInt("testInt");
        testStr2 = obj.getString("testStr2");
    }
    public void generateRandomContent() {
        int count = 0;
        testStr1 = TBRandom.GetRandomString(5);
        testInt = (new Random()).nextInt(10);
        testStr2 = TBRandom.GetRandomString(5);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("testStr1 : " + testStr1).append("\n");
        sb.append("testInt : " + String.valueOf(testInt)).append("\n");
        sb.append("testStr2 : " + testStr2).append("\n");
        return sb.toString();
    }

}
