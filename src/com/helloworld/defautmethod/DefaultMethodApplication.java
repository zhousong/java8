package com.helloworld.defautmethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodApplication {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 6, 3, 9);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }
}
