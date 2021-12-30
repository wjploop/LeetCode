package com.wjp.problems.常见问题;

public class 栈溢出 {
    static int depth = 0;

    public static void main(String[] args) {
        redo();
    }

    static void redo() {
        int a = 1;
        int b = 2;
        System.out.println("depth " + depth++);
        redo();
    }
}
