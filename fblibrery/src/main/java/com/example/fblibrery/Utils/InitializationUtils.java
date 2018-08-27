package com.example.fblibrery.Utils;

import android.content.Context;

/**
 * Created by munchado on 14-08-2018.
 */


public abstract  class InitializationUtils {
    abstract public void initialize(Context context);
    abstract public void  postEventforEventTracking(String categoryID,String actionID,String labelID);
    public abstract  void reportException(Exception crashException,String exceptionType);
}
