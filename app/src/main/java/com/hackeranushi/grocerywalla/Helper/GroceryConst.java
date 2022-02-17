package com.hackeranushi.grocerywalla.Helper;

import android.content.Context;
import android.content.SharedPreferences;

public class GroceryConst {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    public static String sp_name = "GroceryWalla";

    public interface OtpKeys {
        String USER_NAME = "USER_NAME";
        String USER_EMAIL = "USER_EMAIL";
        String USER_MOBILE = "USER_MOBILE";
        String USER_DOB = "USER_DOB";
        String PIN_CODE = "PIN_CODE";
        String USER_GENDER = "USER_GENDER";
        String USER_IMG = "USER_IMG";
        String UID = "UID";

    }

    public interface EmailKeys
    {
        String USER_NAME = "USER_NAME";
        String USER_EMAIL = "USER_EMAIL";
        String USER_MOBILE = "USER_MOBILE";
        String USER_DOB = "USER_DOB";
        String PIN_CODE = "PIN_CODE";
        String USER_GENDER = "USER_GENDER";
        String USER_IMG = "USER_IMG";
        String UID = "UID";
    }
}
