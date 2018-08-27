package com.example.fblibrery.Utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.fblibrery.R;


public final class DialogUtil {
    private static ProgressDialog progressDialog;

    private DialogUtil() {
    }

    public static void showProgressDialog(Context context) {
        try {
            showProgressDialog(context, R.string.please_wait);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void showProgressDialog(Context context, int resourceId) {
        try {

            showProgressDialog(context, context.getString(resourceId));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void showProgressDialog(Context context, String message) {
        try {


            if (progressDialog != null) {
                progressDialog.setMessage(message);
                return;
            }
            progressDialog
                    = new ProgressDialog(context);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void hideProgressDialog() {
        try {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            progressDialog = null;
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}