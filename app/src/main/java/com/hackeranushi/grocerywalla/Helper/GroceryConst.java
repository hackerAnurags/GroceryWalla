package com.hackeranushi.grocerywalla.Helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class GroceryConst {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    public static String sp_name = "GroceryWalla";
    @SuppressLint("StaticFieldLeak")
    public static TextView locationGet;
    @SuppressLint("StaticFieldLeak")
    public static TextView userName;
    @SuppressLint("StaticFieldLeak")
    public static TextView userEmail;
    public static boolean isPermissionGranted = true;


//    public static String current_user = "";
//    public static String product_id = "";
//    public static int recycler_position ;
//    public static int selection_position ;
//    public static int category_position ;
//    public static int mobile_category_position ;
//    public static int category_product_position ;
//    public static int redColor;
//    public static int greyColor;


    public static List<String> searchList;


    public static String location;

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

    public interface EmailKeys {
        String USER_NAME = "USER_NAME";
        String USER_EMAIL = "USER_EMAIL";
        String USER_MOBILE = "USER_MOBILE";
        String USER_DOB = "USER_DOB";
        String PIN_CODE = "PIN_CODE";
        String USER_GENDER = "USER_GENDER";
        String USER_IMG = "USER_IMG";
        String UID = "UID";
    }

    public interface adminKey {
        String USER_NAME = "USER_NAME";
        String USER_EMAIL = "USER_EMAIL";
        String UID = "UID";
    }
}
