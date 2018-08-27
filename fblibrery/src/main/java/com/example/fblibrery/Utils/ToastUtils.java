package com.example.fblibrery.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Deepak Saini on 6/10/17.
 */

public class ToastUtils {
    public static void showToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
