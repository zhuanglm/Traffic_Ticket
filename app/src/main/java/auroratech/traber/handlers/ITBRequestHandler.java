package auroratech.traber.handlers;

import auroratech.traber.web.TBWebResponse;

/**
 * Created by E on 3/30/2016.
 */
public interface ITBRequestHandler {
    public void onRequestHandleSuccess(TBWebResponse response);
    public void onRequestHandleFailure(TBWebResponse response);
}
