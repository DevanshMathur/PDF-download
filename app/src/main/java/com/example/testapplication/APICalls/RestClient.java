//package com.example.testapplication.APICalls;
//
//import com.android.volley.DefaultRetryPolicy;
//import com.android.volley.Request;
//import com.example.testapplication.BuildConfig;
//import com.example.testapplication.model.TransactionPdfUrlResponse;
//
//public class RestClient {
//
//    public VolleyManager getmVolleyManager() {
//        return mVolleyManager;
//    }
//
//    protected static final String PROTOCOL_CHARSET = "utf-8";
//
//    VolleyManager mVolleyManager;
//
//    public RequestHandler _mGetTransactionPdfUrl(final RequestCallback<TransactionPdfUrlResponse> listener, String _mSessionId, String _mOrderId) {
//        GsonRequest gsonRequest = new GsonRequest(Request.Method.GET, APICode.DOWNLOAD_TICKET + _mOrderId , TransactionPdfUrlResponse.class, null, listener);
//        gsonRequest.setRetryPolicy(new DefaultRetryPolicy(
//                8000,
//                0,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
//        ));
//        gsonRequest.setShouldCache(false);
//        gsonRequest.putHeaders(APICode.HEADER_API_KEY, APICode.API_KEY);
//        gsonRequest.putHeaders(APICode.HEADER_SESSION_ID, _mSessionId);
//        gsonRequest.setShouldCache(false);
//        return new RequestHandler(mVolleyManager.addToRequestQueue(gsonRequest));
//
//    }
//
//
//
//}
