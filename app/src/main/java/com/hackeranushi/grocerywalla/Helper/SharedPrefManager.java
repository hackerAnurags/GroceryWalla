package com.hackeranushi.grocerywalla.Helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.hackeranushi.grocerywalla.Activities.Authentication;
import com.hackeranushi.grocerywalla.Models.UserDetails;
import com.hackeranushi.grocerywalla.databinding.ActivityAuthenticationBinding;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "GroceryWalla";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USERNAME = "user_name";
    private static final String KEY_EMAIL = "key_email";
    private static final String KEY_MOBILE = "key_mobile";
    private static final String KEY_PASS = "key_pass";
    private static final String KEY_TOTAL_AMOUNT = "key_total_amount";

    private static SharedPrefManager mInstance;
    private  static Context mCtx;

    public SharedPrefManager(Context context){mCtx=context;}

    public static synchronized SharedPrefManager getInstance(Context context)
    {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void userLogin(String getID, String getName, String getEmail, String getMobile, String getPassword) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_USER_ID, getID);
        editor.putString(KEY_USERNAME, getName);
        editor.putString(KEY_EMAIL,getEmail);
        editor.putString(KEY_MOBILE, getMobile);
        editor.putString(KEY_PASS, getPassword);

        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null) != null;
    }

    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Intent i = new Intent(mCtx, Authentication.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mCtx.startActivity(i);
    }
    public UserDetails getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new UserDetails(

                sharedPreferences.getString(KEY_USER_ID,null),
                sharedPreferences.getString(KEY_USERNAME,null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_MOBILE, null),
                sharedPreferences.getString(KEY_PASS, null)
        );
    }

}
