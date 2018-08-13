package com.helloworld.lambda;

import com.helloworld.data.AppleData;
import com.helloworld.domain.Apple;

import java.util.HashMap;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 匿名：没有名字
 * 函数：lambda不属于特定类，但和方法一样，有参数列表、函数体，返回类型，抛出异常
 * 传递：传递给方法或存储在变量中
 * 简洁：不需要像匿名类一样写大量模板代码
 * Consumer Function Predicate Supplier
 * Comparator Runnable
 * (Apple apple){
 *
 *     return xxx;
 * }
 */
public class LambdaApplication {
    public static void main(String[] args) {
        System.out.println("11");
        AppleData.DATA.forEach(apple -> System.out.println(apple));
        System.out.println("22");
        System.out.println(AppleData.DATA.stream()
                .filter(apple -> "green".equals(apple.getColor()))
                .collect(Collectors.toList()));
        System.out.println("33");
        System.out.println(AppleData.DATA.stream()
                .filter((apple) -> "green".equals(apple.getColor()))
                .map(apple -> apple.getWeight())
                .collect(Collectors.toList()));
        System.out.println("44");
        AppleData.DATA.forEach(apple -> {
            if ("green".equals(apple.getColor())) {
                System.out.println(apple);
            }
        });
        System.out.println("55");
        LongSupplier longSupplier = () -> 100;
        System.out.println(longSupplier.getAsLong());
        System.out.println("66");
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.forEach((k, v) -> System.out.println(k + "-" + v));
        System.out.println("77");
        Predicate<Apple> colorPredicate = apple -> "green".equals(apple.getColor());
        Predicate<Apple> weightPredicate = apple -> apple.getWeight() > 10;
        Predicate<Apple> colorWeightPredicate = colorPredicate.and(weightPredicate);
        System.out.println(AppleData.DATA.stream()
                .filter(colorWeightPredicate)
                .collect(Collectors.toList()));

    }
}
