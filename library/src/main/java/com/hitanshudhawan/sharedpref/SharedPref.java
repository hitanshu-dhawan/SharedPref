package com.hitanshudhawan.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Map;
import java.util.Set;


public final class SharedPref {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.OnSharedPreferenceChangeListener mOnSharedPreferenceChangeListener;
    private SharedPref.OnSharedPrefChangeListener mOnSharedPrefChangeListener;

    public SharedPref(final Context context) {
        this(context, context.getPackageName(), Context.MODE_PRIVATE);
    }

    public SharedPref(final Context context, final String name) {
        this(context, name, Context.MODE_PRIVATE);
    }

    public SharedPref(final Context context, final String name, final int mode) {
        mSharedPreferences = context.getSharedPreferences(name, mode);
    }

    public boolean contains(final String key) {
        return mSharedPreferences.contains(key);
    }

    public void remove(final String key) {
        if (Build.VERSION.SDK_INT >= 9) {
            mSharedPreferences.edit().remove(key).apply();
        } else {
            mSharedPreferences.edit().remove(key).commit();
        }
    }

    public Map<String, ?> getAll() {
        return mSharedPreferences.getAll();
    }

    public void clear() {
        if (Build.VERSION.SDK_INT >= 9) {
            mSharedPreferences.edit().clear().apply();
        } else {
            mSharedPreferences.edit().clear().commit();
        }
    }

    public boolean getBoolean(final String key, final boolean defValue) {
        return mSharedPreferences.getBoolean(key, defValue);
    }

    public void putBoolean(final String key, final boolean value) {
        if (Build.VERSION.SDK_INT >= 9) {
            mSharedPreferences.edit().putBoolean(key, value).apply();
        } else {
            mSharedPreferences.edit().putBoolean(key, value).commit();
        }
    }

    public float getFloat(final String key, final float defValue) {
        return mSharedPreferences.getFloat(key, defValue);
    }

    public void putFloat(final String key, final float value) {
        if (Build.VERSION.SDK_INT >= 9) {
            mSharedPreferences.edit().putFloat(key, value).apply();
        } else {
            mSharedPreferences.edit().putFloat(key, value).commit();
        }
    }

    public int getInt(final String key, final int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }

    public void putInt(final String key, final int value) {
        if (Build.VERSION.SDK_INT >= 9) {
            mSharedPreferences.edit().putInt(key, value).apply();
        } else {
            mSharedPreferences.edit().putInt(key, value).commit();
        }
    }

    public long getLong(final String key, final long defValue) {
        return mSharedPreferences.getLong(key, defValue);
    }

    public void putLong(final String key, final long value) {
        if (Build.VERSION.SDK_INT >= 9) {
            mSharedPreferences.edit().putLong(key, value).apply();
        } else {
            mSharedPreferences.edit().putLong(key, value).commit();
        }
    }

    public String getString(final String key, final String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    public void putString(final String key, final String value) {
        if (Build.VERSION.SDK_INT >= 9) {
            mSharedPreferences.edit().putString(key, value).apply();
        } else {
            mSharedPreferences.edit().putString(key, value).commit();
        }
    }

    @RequiresApi(11)
    public Set<String> getStringSet(final String key, final Set<String> defValues) {
        return mSharedPreferences.getStringSet(key, defValues);
    }

    @RequiresApi(11)
    public void putStringSet(final String key, final Set<String> values) {
        if (Build.VERSION.SDK_INT >= 9) {
            mSharedPreferences.edit().putStringSet(key, values).apply();
        } else {
            mSharedPreferences.edit().putStringSet(key, values).commit();
        }
    }

    public void registerOnSharedPrefChangeListener(final SharedPref.OnSharedPrefChangeListener listener) {
        mOnSharedPrefChangeListener = listener;
        mOnSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                mOnSharedPrefChangeListener.onSharedPrefChanged(key);
            }
        };
        mSharedPreferences.registerOnSharedPreferenceChangeListener(mOnSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPrefChangeListener(final SharedPref.OnSharedPrefChangeListener listener) {
        mOnSharedPrefChangeListener = listener;
        mOnSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                mOnSharedPrefChangeListener.onSharedPrefChanged(key);
            }
        };
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(mOnSharedPreferenceChangeListener);
    }

    public interface OnSharedPrefChangeListener {
        void onSharedPrefChanged(String key);
    }
}