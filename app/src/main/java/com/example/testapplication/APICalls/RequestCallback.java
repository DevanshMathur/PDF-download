//package com.example.testapplication.APICalls;
//
//import android.util.Log;
//
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.HttpHeaderParser;
//import com.google.gson.Gson;
//
//public abstract class RequestCallback <T> implements ResponseListener<T> {
//
//    Gson gson = new Gson();
//
//    @Override
//    public void onSuccessResponse(T responseData) {
//        onRestResponse(null, responseData);
//    }
//
//    @Override
//    public void onErrorResponse(VolleyError error) {
//        String errorJSON=null;
//        if (error.networkResponse != null && error.networkResponse.data != null) {
//            try {
//                if (error.networkResponse.headers != null) {
//                    errorJSON = new String(error.networkResponse.data, HttpHeaderParser.parseCharset(error.networkResponse.headers));
//                }
//            } catch (Exception e) {
//                Log.e("Look Forward","Exception "+e);
//            }
//        }
//        onErrorResponse(error, errorJSON);
//    }
//
//
//    public abstract void onRestResponse(Exception e, T result);
//
//    public abstract void onErrorResponse(Exception e, String errorJson);
//
//
//}
