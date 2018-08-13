package com.helloworld.data;

import com.helloworld.domain.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleData {

    public final static List<Apple> DATA;

    static {
        DATA = new ArrayList<>();
        DATA.add(new Apple("a", "green", 50));
        DATA.add(new Apple("a", "green", 10));
        DATA.add(new Apple("b", "red", 20));
        DATA.add(new Apple("b", "red", 10));
        DATA.add(new Apple("c", "blue", 30));
        DATA.add(new Apple("c", "blue", 15));
    }
}
