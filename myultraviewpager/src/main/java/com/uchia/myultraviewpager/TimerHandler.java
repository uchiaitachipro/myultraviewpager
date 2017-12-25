package com.uchia.myultraviewpager;

import android.os.Handler;
import android.os.Message;
import android.util.SparseIntArray;

/**
 * Created by uchia on 2017/12/25.
 */

class TimerHandler extends Handler {

    interface TimerHandlerListener {
        void callBack();
    }

    SparseIntArray specialInterval;
    long interval;
    boolean isStopped = true;
    TimerHandlerListener listener;
    UltraViewPager mUltraViewPager;

    static final int MSG_TIMER_ID = 87108;

    TimerHandler(UltraViewPager ultraViewPager, TimerHandlerListener listener, long interval) {
        this.mUltraViewPager = ultraViewPager;
        this.listener = listener;
        this.interval = interval;
    }

    @Override
    public void handleMessage(Message msg) {
        if (MSG_TIMER_ID == msg.what) {
            int nextIndex = mUltraViewPager.getNextItem();
            if (listener != null) {
                listener.callBack();
            }
            tick(nextIndex);
        }
    }

    public void tick(int index) {
        sendEmptyMessageDelayed(TimerHandler.MSG_TIMER_ID, getNextInterval(index));
    }

    private long getNextInterval(int index) {
        long next = interval;
        if (specialInterval != null) {
            long has = specialInterval.get(index, -1);
            if (has > 0) {
                next = has;
            }
        }
        return next;
    }

}

