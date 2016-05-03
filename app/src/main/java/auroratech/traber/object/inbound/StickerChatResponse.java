package auroratech.traber.object.inbound;

import auroratech.traber.object.internal.StickerChat;

/**
 * Created by E on 3/30/2016.
 */
public class StickerChatResponse extends ResponseBase {
    int total;
    StickerChat[] list;
}
