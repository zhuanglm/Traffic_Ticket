package auroratech.traber.object.outbound;

import java.util.Date;

/**
 * Created by E on 3/30/2016.
 */
public class AddStickerRequest {

    String email;
    String token;
    String deviceId;
    String maker;
    String placeNumber;
    String insuranceNumber;
    Date expireDate;
    int term;
    String message;

    byte[] image1;
    byte[] image2;
    byte[] image3;
    byte[] image4;
    byte[] image5;
}
