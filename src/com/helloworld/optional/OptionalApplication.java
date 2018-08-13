package com.helloworld.optional;

import com.helloworld.domain.Apple;

import java.util.Optional;

public class OptionalApplication {
    public static void main(String[] args) throws Exception {
        OptionalApplication application = new OptionalApplication();

        Apple apple = application.getApple();

        Optional.ofNullable(apple)
                .orElseThrow(() -> new Exception());

    }

    private Apple getApple() {
        return new Apple("hello apple", "red", 100);
    }
}
