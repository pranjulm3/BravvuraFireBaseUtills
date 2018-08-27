package com.example.bravvurafirebaseutils.fbanalytics;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.example.bravvurafirebaseutils.fbanalytics.Utils.LogUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

public class FireBaseAnalytics {
    private static FirebaseAnalytics mFirebaseAnalytics;

    static Bundle params;
    static Context context;
    @SuppressLint("MissingPermission")
    public static void initFireBaseAnalytics(Context mContext) {
        context=mContext;
        params=getInformation ();
        mFirebaseAnalytics=FirebaseAnalytics.getInstance ( mContext );
        logUserDeviceInformation ();
    }

    public static Bundle getInformation() {
        Bundle params=new Bundle ();


        params.putString ( "os_version",System.getProperty ( "os.version" ) );
        params.putString ( "sdk",(Build.VERSION.SDK) );
        params.putString ( "brand",(Build.BRAND) );
        params.putString ( "display",(Build.DISPLAY) );
        params.putString ( "version_release",(Build.VERSION.RELEASE) );
        params.putString ( "device",(Build.DEVICE) );
        params.putString ( "model",(Build.MODEL) );
        params.putString ( "product",(Build.PRODUCT) );
        return params;
    }


    public static void logUserDeviceInformation() {
        mFirebaseAnalytics.logEvent ( "user_device_information___",params );
        LogUtils.d ( "user_device_information  ",params );
    }
    public static void postEventforEventTracking(String categoryID,
                                       String actionID,String labelID) {

        Bundle bundle=new Bundle (  );
        bundle.putString ( "categoryID",categoryID );
        bundle.putString ( "actionID",actionID );
        bundle.putString ( "targetID",labelID );

        mFirebaseAnalytics.logEvent ( "EventTrack",bundle );
        LogUtils.d ( "EventTrack  ",bundle );
        }



    public void postEvent(String key,Map<String, String> eventProperties) {

    }
}
