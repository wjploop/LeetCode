package com.wjp.problems.android_handler;

public class MyLooper {

    boolean quitAllowed = false;

    public MyLooper(boolean quitAllowed) {
        this.quitAllowed = quitAllowed;
    }

    static final ThreadLocal<MyLooper> sThreadLocal = new ThreadLocal<>();

    void prepare(boolean quitAllowed) {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("一个线程只允许一个Looper");
        }
        // 线程私有
        // 其内部从
        sThreadLocal.set(new MyLooper(quitAllowed));
    }



}
