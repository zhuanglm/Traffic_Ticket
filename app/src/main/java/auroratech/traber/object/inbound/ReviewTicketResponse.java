package auroratech.traber.object.inbound;

import auroratech.traber.object.internal.StickerInfo;

/**
 * Created by E on 3/30/2016.
 */
public class ReviewTicketResponse extends ResponseBase {
    int total;
    StickerInfo[] list;
}
