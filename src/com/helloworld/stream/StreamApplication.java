package com.helloworld.stream;

import com.helloworld.data.AppleData;

import java.util.stream.Collectors;

/**
 * 中间操作：
 * filter
 * map
 * limit
 * sorted
 * distinct
 * forEach
 * 终端操作：
 * count
 * collect
 */
public class StreamApplication {
    public static void main(String[] args) {
        System.out.println(AppleData.DATA.stream()
                .filter(apple -> "green".equals(apple.getColor()))
                .distinct()
                .limit(1)
                .collect(Collectors.toList()));
        System.out.println(AppleData.DATA.stream()
                .filter(apple -> "green".equals(apple.getColor()) && apple.getWeight() > 10)
                .collect(Collectors.counting()));
        System.out.println(AppleData.DATA.stream()
                .filter(apple -> "green".equals(apple.getColor()))
                .count());
        System.out.println(AppleData.DATA.stream()
                .filter(apple -> "green".equals(apple.getColor()))
                .sorted((o1, o2) -> o1.getWeight() - o2.getWeight())
//                .sorted(Comparator.comparingInt(Apple::getWeight))
                .collect(Collectors.toList()));
        System.out.println(AppleData.DATA.stream()
        .mapToInt(apple -> apple.getWeight())
        .sum());

    }
}
