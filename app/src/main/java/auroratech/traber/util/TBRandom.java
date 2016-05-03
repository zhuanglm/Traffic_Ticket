package auroratech.traber.util;

import java.security.SecureRandom;

/**
 * Created by E on 3/31/2016.
 */
public class TBRandom {
    static final String CHARs = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static String GetRandomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( CHARs.charAt( rnd.nextInt(CHARs.length()) ) );
        return sb.toString();
    }
}
