package com.example.fblibrery.Utils;

import android.os.Bundle;
import android.util.Log;

import com.example.fblibrery.BuildConfig;

/**
 * Created by munchado on 13-08-2018.
 */


//import com.example.munchado.bravvurautils.BuildConfig;

public class LogUtils {

    public static void d(String s) {
        if (BuildConfig.DEBUG) Log.d ( "",s );
    }

    public static void d(String tag,String message) {
        if (BuildConfig.DEBUG && !StringUtils.isNullOrEmpty ( tag ) && !StringUtils.isNullOrEmpty ( message ))
            Log.d ( tag,message );
    }

    public static void d(String tag,Bundle message) {
        if (BuildConfig.DEBUG && !StringUtils.isNullOrEmpty ( tag ) && !StringUtils.isNullOrEmpty ( message.toString () ))
            Log.d ( tag,message.toString () );
    }

    public static void e(String s) {
//        if (BuildConfig.DEBUG)
        Log.e ( "",s );
    }

    public static void i(String tag,String value) {
        if (!StringUtils.isNullOrEmpty ( value ))
            if (BuildConfig.DEBUG && !StringUtils.isNullOrEmpty ( tag ) && !StringUtils.isNullOrEmpty ( value )) {
                Log.i ( tag,value );
            }
    }

    public static void e(String tag,String value) {
        if (!StringUtils.isNullOrEmpty ( value ))
            if (BuildConfig.DEBUG && !StringUtils.isNullOrEmpty ( tag ) && !StringUtils.isNullOrEmpty ( value ))
                Log.e ( tag,value );
//            else
//                Fabric.getLogger().e(tag, value);
    }


    public static void v(String tag,String message) {
        if (BuildConfig.DEBUG && !StringUtils.isNullOrEmpty ( tag ) && message != null) {
//            System.out.println(tag + " : " + message);
            Log.v ( tag,tag + " : " + message );
        }
    }


}
