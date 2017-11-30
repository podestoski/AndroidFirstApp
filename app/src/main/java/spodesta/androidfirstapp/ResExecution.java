package spodesta.androidfirstapp;

import com.loopj.android.http.*;

/**
 * Created by Spodesta on 28/11/2017.
 */

public class ResExecution {

    private static final String BASE_URL = "http://localhost:46953/RestNFLService.svc/json/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(BASE_URL, params, responseHandler);
    }

    public static void post(RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(BASE_URL, params, responseHandler);
    }



}
