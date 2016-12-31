package com.kyle.demo;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Kyle on 2016/12/31 0031.
 */

public class LogUtils {
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;

    // change level to control log
    private static final int LEVEL = VERBOSE;

    public static void v(String message) {
        if (LEVEL <= VERBOSE) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.v(getDefaultTag(stackTraceElement), "[" + stackTraceElement.getMethodName() + "]: " + message);
        }
    }

    public static void v(String tag, String message) {
        if (LEVEL <= VERBOSE) {
            if (!TextUtils.isEmpty(tag)) {
                Log.v(tag, message);
            } else {
                StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
                Log.v(getDefaultTag(stackTraceElement), "" + message);
            }
        }
    }

    public static void d(String message) {
        if (LEVEL <= DEBUG) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.d(getDefaultTag(stackTraceElement), "[" + stackTraceElement.getMethodName() + "]: " + message);
        }
    }

    public static void d(String tag, String message) {
        if (LEVEL <= DEBUG) {
            if (!TextUtils.isEmpty(tag)) {
                Log.d(tag, message);
            } else {
                StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
                Log.d(getDefaultTag(stackTraceElement), "" + message);
            }
        }
    }

    public static void i(String message) {
        if (LEVEL <= INFO) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.i(getDefaultTag(stackTraceElement), "[" + stackTraceElement.getMethodName() + "]: " + message);
        }
    }

    public static void i(String tag, String message) {
        if (LEVEL <= INFO) {
            if (!TextUtils.isEmpty(tag)) {
                Log.i(tag, message);
            } else {
                StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
                Log.i(getDefaultTag(stackTraceElement), "" + message);
            }
        }
    }

    public static void w(String message) {
        if (LEVEL <= WARN) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.w(getDefaultTag(stackTraceElement), "[" + stackTraceElement.getMethodName() + "]: " + message);
        }
    }

    public static void w(String tag, String message) {
        if (LEVEL <= WARN) {
            if (!TextUtils.isEmpty(tag)) {
                Log.w(tag, message);
            } else {
                StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
                Log.w(getDefaultTag(stackTraceElement), "" + message);
            }
        }
    }

    public static void e(String message) {
        if (LEVEL <= ERROR) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.e(getDefaultTag(stackTraceElement), "[" + stackTraceElement.getMethodName() + "]: " + message);
        }
    }

    public static void e(String tag, String message) {
        if (LEVEL <= ERROR) {
            if (!TextUtils.isEmpty(tag)) {
                Log.e(tag, message);
            } else {
                StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
                Log.e(getDefaultTag(stackTraceElement), "" + message);
            }
        }
    }

    private static String getDefaultTag(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        String[] stringArray = fileName.split("\\.");
        return stringArray[0];
    }
}
