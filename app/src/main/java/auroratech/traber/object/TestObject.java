package auroratech.traber.object;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import auroratech.traber.util.TBRandom;

/**
 * Created by E on 3/31/2016.
 */
public class TestObject {
    int int1;
    int[] int2;

    String string1;
    String[] string2;

    short short1;
    short[] short2;

    long long1;
    long[] long2;

    float float1;
    float[] float2;

    double double1;
    double[] double2;

    Date date1;
    Date[] date2;

    boolean boolean1;
    boolean[] boolean2;

    byte byte1;
    byte[] byte2;

    NonPrimative nonPrimative1;
    NonPrimative[] nonPrimative2;

    /**
     *
     *  char, List, Dictionary etc, currently not supposed...
     *
     */



    public String toJSON() throws JSONException {
        JSONObject obj = new JSONObject();
        JSONArray jAry = new JSONArray();
        obj.put("int1", new Integer(int1));
        jAry = new JSONArray();
        for(int i=0; i< int2.length; i++) {
            jAry.put(new Integer(int2[i]));
        }
        obj.put("int2", jAry);
        obj.put("string1", new String(string1));
        jAry = new JSONArray();
        for(int i=0; i< string2.length; i++) {
            jAry.put(new String(string2[i]));
        }
        obj.put("string2", jAry);
        obj.put("short1", String.valueOf(short1));
        jAry = new JSONArray();
        for(int i=0; i< short2.length; i++) {
            jAry.put(String.valueOf(short2[i]));
        }
        obj.put("short2", jAry);
        obj.put("long1", String.valueOf(long1));
        jAry = new JSONArray();
        for(int i=0; i< long2.length; i++) {
            jAry.put(String.valueOf(long2[i]));
        }
        obj.put("long2", jAry);
        obj.put("float1", String.valueOf(float1));
        jAry = new JSONArray();
        for(int i=0; i< float2.length; i++) {
            jAry.put(String.valueOf(float2[i]));
        }
        obj.put("float2", jAry);
        obj.put("double1", String.valueOf(double1));
        jAry = new JSONArray();
        for(int i=0; i< double2.length; i++) {
            jAry.put(String.valueOf(double2[i]));
        }
        obj.put("double2", jAry);
        obj.put("date1", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).format(date1));
        jAry = new JSONArray();
        for(int i=0; i< date2.length; i++) {
            jAry.put((new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).format(date2[i]));
        }
        obj.put("date2", jAry);
        obj.put("boolean1", new Boolean(boolean1));
        jAry = new JSONArray();
        for(int i=0; i< boolean2.length; i++) {
            jAry.put(new Boolean(boolean2[i]));
        }
        obj.put("boolean2", jAry);
        obj.put("byte1", Byte.toString(byte1));
        jAry = new JSONArray();
        for(int i=0; i< byte2.length; i++) {
            jAry.put(Byte.toString(byte2[i]));
        }
        obj.put("byte2", jAry);
        obj.put("nonPrimative1", nonPrimative1.toJSON());
        jAry = new JSONArray();
        for(int i=0; i< nonPrimative2.length; i++) {
            jAry.put(nonPrimative2[i].toJSON());
        }
        obj.put("nonPrimative2", jAry);
        return obj.toString();
    }
    public void fromJSON(String json) throws Exception {
        JSONObject obj = new JSONObject(json);
        JSONArray array;
        int1 = obj.getInt("int1");
        array = obj.getJSONArray("int2");
        int2 = new int[array.length()];
        for(int i = 0 ; i < array.length() ; i++){
            int2[i] = array.getInt(i);
        }
        string1 = obj.getString("string1");
        array = obj.getJSONArray("string2");
        string2 = new String[array.length()];
        for(int i = 0 ; i < array.length() ; i++){
            string2[i] = array.getString(i);
        }
        short1 = Short.parseShort(obj.getString("short1"));
        array = obj.getJSONArray("short2");
        short2 = new short[array.length()];
        for(int i = 0 ; i < array.length() ; i++){
            short2[i] = Short.parseShort(array.getString(i));
        }
        long1 = Long.parseLong(obj.getString("long1"));
        array = obj.getJSONArray("long2");
        long2 = new long[array.length()];
        for(int i = 0 ; i < array.length() ; i++){
            long2[i] = Long.parseLong(array.getString(i));
        }
        float1 = Float.parseFloat(obj.getString("float1"));
        array = obj.getJSONArray("float2");
        float2 = new float[array.length()];
        for(int i = 0 ; i < array.length() ; i++){
            float2[i] = Float.parseFloat(array.getString(i));
        }
        double1 = Double.parseDouble(obj.getString("double1"));
        array = obj.getJSONArray("double2");
        double2 = new double[array.length()];
        for(int i = 0 ; i < array.length() ; i++){
            double2[i] = Double.parseDouble(array.getString(i));
        }
        date1 = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).parse(obj.getString("date1"));
        array = obj.getJSONArray("date2");
        date2 = new Date[array.length()];
        for(int i = 0 ; i < array.length() ; i++){
            date2[i] = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).parse(array.getString(i));
        }
        boolean1 = obj.getBoolean("boolean1");
        array = obj.getJSONArray("boolean2");
        boolean2 = new boolean[array.length()];
        for(int i = 0 ; i < array.length() ; i++){
            boolean2[i] = array.getBoolean(i);
        }
        byte1 = Byte.parseByte(obj.getString("byte1"));
        array = obj.getJSONArray("byte2");
        byte2 = new byte[array.length()];
        for(int i = 0 ; i < array.length() ; i++){
            byte2[i] = Byte.parseByte(array.getString(i));
        }
        nonPrimative1 = new NonPrimative();
        nonPrimative1.fromJSON(obj.getString("nonPrimative1"));
        array = obj.getJSONArray("nonPrimative2");
        nonPrimative2 = new NonPrimative[array.length()];
        for(int i = 0 ; i < array.length() ; i++){
            nonPrimative2[i] = new NonPrimative();
            nonPrimative2[i].fromJSON(array.getString(i));
        }
    }
    public void generateRandomContent() {
        int count = 0;
        int1 = (new Random()).nextInt(10);
        int2 = new int[2];
        for(int i=0; i< int2.length; i++) {
            int2[i] = (new Random()).nextInt(10);
        }
        string1 = TBRandom.GetRandomString(5);
        string2 = new String[2];
        for(int i=0; i< string2.length; i++) {
            string2[i] = TBRandom.GetRandomString(5);
        }
        short1 = Short.MAX_VALUE;
        short2 = new short[2];
        for(int i=0; i< short2.length; i++) {
            short2[i] = Short.MAX_VALUE;
        }
        long1 = Long.MAX_VALUE;
        long2 = new long[2];
        for(int i=0; i< long2.length; i++) {
            long2[i] = Long.MAX_VALUE;
        }
        float1 = (new Random()).nextFloat();
        float2 = new float[2];
        for(int i=0; i< float2.length; i++) {
            float2[i] = (new Random()).nextFloat();
        }
        double1 = (new Random()).nextDouble();
        double2 = new double[2];
        for(int i=0; i< double2.length; i++) {
            double2[i] = (new Random()).nextDouble();
        }
        date1 = new Date(Math.abs(System.currentTimeMillis() - (new Random()).nextInt(100000)));
        date2 = new Date[2];
        for(int i=0; i< date2.length; i++) {
            date2[i] = new Date(Math.abs(System.currentTimeMillis() - (new Random()).nextInt(100000)));
        }
        boolean1 = (new Random()).nextBoolean();
        boolean2 = new boolean[2];
        for(int i=0; i< boolean2.length; i++) {
            boolean2[i] = (new Random()).nextBoolean();
        }
        byte1 = Byte.MAX_VALUE;
        byte2 = new byte[2];
        new Random(System.currentTimeMillis()).nextBytes(byte2);
        nonPrimative1 = new NonPrimative();
        nonPrimative1.generateRandomContent();
        nonPrimative2 = new NonPrimative[2];
        for(int i=0; i< nonPrimative2.length; i++) {
            nonPrimative2[i] = new NonPrimative();
            nonPrimative2[i].generateRandomContent();
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("int1 : " + String.valueOf(int1)).append("\n");
        for(int i=0; i< int2.length; i++) {
            sb.append("int2[" + String.valueOf(i) + "] : " + String.valueOf(int2[i])).append("\n");
        }
        sb.append("\n");
        sb.append("string1 : " + string1).append("\n");
        for(int i=0; i< string2.length; i++) {
            sb.append("string2[" + String.valueOf(i) + "] : " + string2[i]).append("\n");
        }
        sb.append("\n");
        sb.append("short1 : " + Short.toString(short1)).append("\n");
        for(int i=0; i< short2.length; i++) {
            sb.append("short2[" + String.valueOf(i) + "] : " + Short.toString(short2[i])).append("\n");
        }
        sb.append("\n");
        sb.append("long1 : " + Long.toString(long1)).append("\n");
        for(int i=0; i< long2.length; i++) {
            sb.append("long2[" + String.valueOf(i) + "] : " + Long.toString(long2[i])).append("\n");
        }
        sb.append("\n");
        sb.append("float1 : " + Float.toString(float1)).append("\n");
        for(int i=0; i< float2.length; i++) {
            sb.append("float2[" + String.valueOf(i) + "] : " + Float.toString(float2[i])).append("\n");
        }
        sb.append("\n");
        sb.append("double1 : " + Double.toString(double1)).append("\n");
        for(int i=0; i< double2.length; i++) {
            sb.append("double2[" + String.valueOf(i) + "] : " + Double.toString(double2[i])).append("\n");
        }
        sb.append("\n");
        sb.append("date1 : " + (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).format(date1)).append("\n");
        for(int i=0; i< date2.length; i++) {
            sb.append("date2[" + String.valueOf(i) + "] : " + (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).format(date2[i])).append("\n");
        }
        sb.append("\n");
        sb.append("boolean1 : " + Boolean.toString(boolean1)).append("\n");
        for(int i=0; i< boolean2.length; i++) {
            sb.append("boolean2[" + String.valueOf(i) + "] : " + Boolean.toString(boolean2[i])).append("\n");
        }
        sb.append("\n");
        sb.append("byte1 : " + Byte.toString(byte1)).append("\n");
        for(int i=0; i< byte2.length; i++) {
            sb.append("byte2[" + String.valueOf(i) + "] : " + Byte.toString(byte2[i])).append("\n");
        }
        sb.append("\n");
        sb.append("nonPrimative1 : " + nonPrimative1.toString()).append("\n");
        for(int i=0; i< nonPrimative2.length; i++) {
            sb.append("nonPrimative2[" + String.valueOf(i) + "] : ");
            sb.append(nonPrimative2[i].toString()).append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

}
