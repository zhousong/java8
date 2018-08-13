package com.helloworld.actionparam;

import com.helloworld.data.AppleData;
import com.helloworld.domain.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 行为参数化
 */
public class ActionParamApplication {
    public static void main(String[] args) {
        System.out.println("1 =" + filterApple(AppleData.DATA));
        System.out.println("2 =" + filterApple(AppleData.DATA, "green"));
        System.out.println("3 =" + filterApple(AppleData.DATA, "green", 20));
        System.out.println("4 =" + filterApple(AppleData.DATA, new ColorPredicate()));
        System.out.println("5 =" + filterApple(AppleData.DATA, new ApplePredicate() {
            @Override
            public Boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        }));
        AppleData.DATA.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        System.out.println("6 = " + AppleData.DATA);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
            }
        }).start();
    }

    private static List<Apple> filterApple(List<Apple> data, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : data) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterApple(List<Apple> data, String color, int i) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : data) {
            if (color.equals(apple.getColor()) && apple.getWeight() > i) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterApple(List<Apple> data, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : data) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterApple(List<Apple> data) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : data) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
}
