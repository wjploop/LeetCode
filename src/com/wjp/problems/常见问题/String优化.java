package com.wjp.problems.常见问题;

public class String优化 {
    private static final int hello = 116;
    private static final String str = "hello";
    public static void main(String[] args) {
        System.out.println("123" == new String("123").intern());
    }
}
