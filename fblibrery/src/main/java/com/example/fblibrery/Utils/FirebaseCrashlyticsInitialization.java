package com.example.fblibrery.Utils;

import android.content.Context;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by munchado on 14-08-2018.
 */


public class FirebaseCrashlyticsInitialization extends InitializationUtils {
    private static Context context;
    private static String m_name, m_email;
    private static Bundle param;
    private boolean flag;

    public FirebaseCrashlyticsInitialization(boolean b) {
        flag=b;
    }

    @Override
    public void reportException(Exception crashException,String exceptionType) {

        Crashlytics.logException ( crashException );
        Crashlytics.setString ( "type-exception",exceptionType + "User Information" + param.toString () );
        LogUtils.d ("type-exception"+param.toString ()  );
    }

    public static void logUserInformation() {
        if (param != null) {
            Crashlytics.setUserIdentifier ( param.toString () );
            Crashlytics.setUserEmail ( param.toString () );
            Crashlytics.setUserName ( param.toString () );
        }

    }

    @Override
    public void initialize(Context m_context) {
        context=m_context;

        final Fabric fabric=new Fabric.Builder ( m_context ).kits ( new Crashlytics () ).debuggable ( flag ).build ();
        Fabric.with ( fabric );

        logUserInformation ();
        param=new Bundle ();

        Crashlytics.log ( 1,"User_ifno  ",param.toString () );//Store log
        Crashlytics.setString ( "crash  ",param.toString () );//Store log key vallue
    }

    @Override
    public void postEventforEventTracking(String categoryID,String actionID,String labelID) {

    }
}
