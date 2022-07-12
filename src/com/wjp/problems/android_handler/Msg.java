package com.wjp.problems.android_handler;

public class Msg {

    long when;

    Msg next;

    Msg messages;

    boolean enqueue(Msg msg, long when) {
        // 同步这个队列
        synchronized (this) {
            msg.when = when;

            Msg p = messages;
            if (p == null || when < p.when) {
                msg.next = p;
                messages = msg;
            } else {
                // 插入该队列
                Msg prev = null;
                while (true) {
                    prev = p;
                    p = p.next;
                    if (when < p.when) {
                        break;
                    }
                }
                msg.next = p;
                prev.next = msg;

            }
        }
        return true;
    }

    

}
