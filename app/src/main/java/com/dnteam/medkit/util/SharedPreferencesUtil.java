package com.dnteam.medkit.util;

import android.content.Context;
import android.content.SharedPreferences;

import org.jetbrains.annotations.NotNull;

public class SharedPreferencesUtil {
    public static void setLang(@NotNull Context context, String lang) {
        SharedPreferences preferences = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("LANGUAGE", lang);
        editor.commit();
    }

    public static void setCountry(@NotNull Context context, String country) {
        SharedPreferences preferences = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("COUNTRY", country);
        editor.commit();
    }

    public static String getLang(@org.jetbrains.annotations.NotNull Context context) {
        SharedPreferences preferences = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        return preferences.getString("LANGUAGE", null);
    }

    public static String getCountry(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        return preferences.getString("COUNTRY", null);
    }


}
