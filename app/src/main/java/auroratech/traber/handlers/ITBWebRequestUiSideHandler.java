package auroratech.traber.handlers;

/**
 * Created by E on 4/17/2016.
 */
public interface ITBWebRequestUiSideHandler {
    /*
    *   when async request is started, any UI change that need to happen
    *   before request is made should be added here (ex: showing loading status icon)
    *
    * */
    public void onAsyncWebRequestStarted();

    /*
    *   when async request is completed, any UI change that need to happen
    *   after request is made should be added here (ex: hide loading status)
    *       - will be called both success or failed case
    * */
    public void onAsyncWebRequestCompleted();
}
