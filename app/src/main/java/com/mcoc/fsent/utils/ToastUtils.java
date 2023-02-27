package com.mcoc.fsent.utils;

import android.content.Context;
import android.widget.Toast;

/**
 *
 */
public class ToastUtils {

    /**
     *
     * @param context
     * @param value
     */
    public static void showToast(Context context, String value){
        showToast(context, value, Toast.LENGTH_SHORT);
    }

    /**
     *
     * @param context
     * @param value
     * @param length
     */
    public static void showToast(Context context, String value, int length){
        Toast toast=Toast.makeText(context, value, length);
        toast.show();
    }
}
