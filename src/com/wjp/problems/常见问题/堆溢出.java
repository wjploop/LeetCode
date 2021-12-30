package com.wjp.problems.常见问题;

import java.util.ArrayList;
import java.util.List;

public class 堆溢出 {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new byte[100 * 1024 * 1024]);
            System.out.println("分配内存 " + 100 * i);
        }
        System.out.println();
        System.out.println("hello");
    }
}
