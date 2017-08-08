package com.kyle.demo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kyle on 2017/8/3 0003.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    private static final boolean DEBUG = true;
    private static final String PATH = Environment.getExternalStorageDirectory().getPath();
    private static final String APP_NAME = "LogDemo";
    private static final String FILE_NAME = "crash";
    private static final String FILE_NAME_SUFFIX = ".trace";

    private CrashHandler() {

    }

    private static class CrashHandlerHolder {
        private static final CrashHandler INSTANCE = new CrashHandler();
    }

    public static CrashHandler getInstance() {
        return CrashHandlerHolder.INSTANCE;
    }

    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;

    public void init(Context ctx) {
        mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext = ctx.getApplicationContext();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        dumpExceptionToSDCard(ex);

        uploadExceptionToServer();

        if (mDefaultCrashHandler != null) {
            mDefaultCrashHandler.uncaughtException(thread, ex);
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    private void dumpExceptionToSDCard(Throwable ex) {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return;
        }

        String filePath = PATH + File.separator + APP_NAME + File.separator + FILE_NAME;
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        long currentTime = System.currentTimeMillis();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(currentTime));

        File file = new File(filePath + File.separator + FILE_NAME + "_" + time + FILE_NAME_SUFFIX);

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            printWriter.println(time);
            getPhoneInfo(printWriter);
            ex.printStackTrace(printWriter);
        } catch (Exception e) {
            LogUtils.e(e.getMessage());
        } finally {
            printWriter.close();
        }
    }

    private void getPhoneInfo(PrintWriter pw) throws PackageManager.NameNotFoundException {
        PackageManager pm = mContext.getPackageManager();
        PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);
        pw.print("APP Version: ");
        pw.println(pi.versionName);
        pw.print("_");
        pw.println(pi.versionCode);

        pw.print("OS version: ");
        pw.print(Build.VERSION.RELEASE);
        pw.print("_");
        pw.println(Build.VERSION.SDK_INT);

        pw.print("Vendor: ");
        pw.println(Build.MANUFACTURER);

        pw.print("Model: ");
        pw.println(Build.MODEL);

        pw.print("CPU ABI: ");
        pw.println(Build.CPU_ABI);
    }

    private void uploadExceptionToServer() {

    }
}
