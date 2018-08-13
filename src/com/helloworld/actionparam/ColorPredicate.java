package com.helloworld.actionparam;

import com.helloworld.domain.Apple;

public class ColorPredicate implements ApplePredicate {
    @Override
    public Boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
