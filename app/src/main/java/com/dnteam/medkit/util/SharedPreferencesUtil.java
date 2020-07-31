package com.dnteam.medkit.util;

import android.content.Context;
import android.content.SharedPreferences;

import org.jetbrains.annotations.NotNull;

public class SharedPreferencesUtil {
    public static void setLang(@NotNull Context context, String lang) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.LOCALE_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.LANGUAGE_PREFERENCE_KEY, lang);
        editor.commit();
    }

    public static void setCountry(@NotNull Context context, String country) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.LOCALE_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.COUNTRY_PREFERENCE_KEY, country);
        editor.commit();
    }

    public static String getLang(@org.jetbrains.annotations.NotNull Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.LOCALE_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        return preferences.getString(Constants.LANGUAGE_PREFERENCE_KEY, null);
    }

    public static String getCountry(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.LOCALE_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        return preferences.getString(Constants.COUNTRY_PREFERENCE_KEY, null);
    }


}
