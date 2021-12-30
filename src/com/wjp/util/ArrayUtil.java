package com.wjp.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayUtil {
    public static String format(Object[] arr) {
        return String.join(", ", Arrays.stream(arr).map(Object::toString).collect(Collectors.joining()));
    }

    public static String format(int[] arr) {
        return String.join(", ", Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

}
