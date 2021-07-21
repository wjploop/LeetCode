package com.wjp.data_structure;


import java.util.Arrays;

/**
 * 实现一个用比特位的数据结构，存储bool值只需一个bit
 * 内部使用long数组来支持
 */
public class BitSet {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(200);
        System.out.println(bitSet);
        bitSet.set(63, true);
        bitSet.set(128, true);
        System.out.println(bitSet);

    }

    private long[] words;

    // 一个long有64位，可以存储长度位boolean[64]
    // 假设需要存储200个位，需要4个long
    // 即存储n个比特，需要 n/64+1,

    public BitSet(int size) {
        words = new long[size / 64 + 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(Long.toBinaryString(words[i]));
        }
        return sb.toString();
    }

    // 比如 99 位在哪呢
    // 99/64 == 1，在倒数第二个long上面，
    // 99%64 == 35 在第35位上
    public void set(int index, boolean value) {
        if (value) {
            words[index / 64] |= 1L << (index % 64);
        }else{
            words[index / 64] &= ~(1L << (index % 64));

        }
    }

}
