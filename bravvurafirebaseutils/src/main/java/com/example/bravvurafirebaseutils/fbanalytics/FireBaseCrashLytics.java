package com.example.bravvurafirebaseutils.fbanalytics;

import android.content.Context;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.example.bravvurafirebaseutils.BuildConfig;
import com.example.bravvurafirebaseutils.fbanalytics.Utils.LogUtils;

import io.fabric.sdk.android.Fabric;

/**
 * Created by munchado on 13-08-2018.
 */

public class FireBaseCrashLytics {
    static Context context;
    private static final FireBaseCrashLytics ourInstance=new FireBaseCrashLytics ();
    public static FireBaseCrashLytics getInstance()  {
        return ourInstance;
    }
static String m_name,m_email;

    static Bundle param;
    private FireBaseCrashLytics() {
    }

    public static void initCrashLyitics(String name,String email,Context m_context,Boolean flag) {
        context=m_context;
        m_name=name;
        m_email=email;
        final Fabric fabric = new Fabric.Builder(m_context)
                .kits(new Crashlytics())
                .debuggable(flag)
                .build();
        Fabric.with(fabric);
//        Fabric.with ( context,new Crashlytics () );
        logUserInformation ();
        param=new Bundle ( );

        param.putString ("name",m_name   );
        param.putString ("email",m_email);
        Crashlytics.log ( 1,"User_ifno  ",param.toString () );//Store log
        Crashlytics.setString ( "crash  ",param.toString () );//Store log key vallue
        LogUtils.d ( "User_info  ",param );

    }

    public static void reportException(Exception crashException,String exceptionType) {
        LogUtils.d ( "type-exception",exceptionType + "User Information " + param.toString () );
        Crashlytics.logException ( crashException );
        Crashlytics.setString ( "type-exception",exceptionType + "User Information" + param.toString () );
    }

    public static void logUserInformation() {
        if(param!=null){
            Crashlytics.setUserIdentifier ( param.toString () );
            Crashlytics.setUserEmail ( param.toString () );
            Crashlytics.setUserName (  param.toString () );
        }

    }
}
