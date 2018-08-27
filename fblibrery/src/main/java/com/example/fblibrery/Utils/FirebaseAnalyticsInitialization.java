package com.example.fblibrery.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Map;

/**
 * Created by munchado on 14-08-2018.
 */

public class FirebaseAnalyticsInitialization extends InitializationUtils {

    private static FirebaseAnalytics mFirebaseAnalytics=null;

    private static Bundle params;
    private static Context context;


    public static Bundle getInformation() {
        Bundle params=new Bundle ();

        DeviceInformation deviceInformation=DeviceInformation.getInstance ();
        params.putString ( "os_version",deviceInformation.getOs_version () );
        params.putString ( "sdk",deviceInformation.getSdk () );
        params.putString ( "brand",deviceInformation.getBrand () );
        params.putString ( "display",deviceInformation.getDisplay () );
        params.putString ( "version_release",deviceInformation.getVersion_release () );
        params.putString ( "device",deviceInformation.getDevice () );
        params.putString ( "model",deviceInformation.getModel () );
        params.putString ( "product",deviceInformation.getProduct () );
        return params;
    }


    public static void logUserDeviceInformation() {
        mFirebaseAnalytics.logEvent ( "user_device_information___",params );

    }

    @Override
    public void postEventforEventTracking(String categoryID,String actionID,String labelID) {

        Bundle bundle=new Bundle ();
        bundle.putString ( "categoryID",categoryID );
        bundle.putString ( "actionID",actionID );
        bundle.putString ( "targetID",labelID );
        mFirebaseAnalytics.logEvent ( "EventTrack",bundle );
        LogUtils.d ("Event Track"+bundle.toString ()  );

    }

    @Override
    public void reportException(Exception crashException,String exceptionType) {

    }


    public void postEvent(String key,Map<String, String> eventProperties) {

    }

    @SuppressLint("MissingPermission")
    @Override
    public void initialize(Context mContext) {
        if (mFirebaseAnalytics == null) {
            mFirebaseAnalytics=FirebaseAnalytics.getInstance ( mContext );
            logUserDeviceInformation ();
            context=mContext;
            params=getInformation ();
        }
    }

}
