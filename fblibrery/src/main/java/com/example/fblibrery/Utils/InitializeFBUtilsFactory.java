package com.example.fblibrery.Utils;

import android.content.Context;

/**
 * Created by munchado on 14-08-2018.
 */

public class InitializeFBUtilsFactory {


    public InitializationUtils getTargetType(String planType) {
        if (planType == null) {
            return null;
        }
        if (planType.equalsIgnoreCase ( "FBAL" )) {
            return new FirebaseAnalyticsInitialization ();
        } else if (planType.equalsIgnoreCase ( "FBCL" )) {
            return new FirebaseCrashlyticsInitialization (false );
        }

        return null;
    }
}
