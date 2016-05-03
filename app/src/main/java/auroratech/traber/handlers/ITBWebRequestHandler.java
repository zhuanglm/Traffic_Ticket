package auroratech.traber.handlers;

/**
 * Created by E on 3/30/2016.
 */
public interface ITBWebRequestHandler {
    public void onRequestCompleted(String response);
    public void onRequestFailed(String response);
}
