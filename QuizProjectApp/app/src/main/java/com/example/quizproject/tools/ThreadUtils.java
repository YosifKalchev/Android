package com.example.quizproject.tools;

import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {

    private static ExecutorService exServiceInstance;
    private static Handler handlerInstance;

    public static ExecutorService getExServiceInstance() {
        if(exServiceInstance == null) exServiceInstance = Executors.newFixedThreadPool(4);
        return exServiceInstance;
    }

    public static Handler getHandlerInstance() {
        if(handlerInstance == null) handlerInstance = HandlerCompat.createAsync(Looper.getMainLooper());
        return handlerInstance;
    }

    private ThreadUtils() {
    }
}
