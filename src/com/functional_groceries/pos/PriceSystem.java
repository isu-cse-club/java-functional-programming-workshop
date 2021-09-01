package com.functional_groceries.pos;

import com.functional_groceries.pos.entity.CartItem;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class PriceSystem {

    // This is a pure function because it's output is dependent only on it's input and there are no side effects
    public static final Function<CartItem, Double> getPrice = (item) -> {
        switch (item.getName().toLowerCase()) {
            case "tomato":
                return 0.99 * item.getCount();
            case "lettuce":
                return 2.19 * item.getCount();
            case "grape":
                return 4.30 * item.getCount();
            case "apple":
                return 0.66 * item.getCount();
            case "orange":
                return 1.12 * item.getCount();
            default:
                return null;
        }
    };

    public static Function<Stream<CartItem>, Double> getCartTotal = (cartStream) ->
            cartStream
            .map(PriceSystem.getPrice)
            .filter(Objects::nonNull)
            .mapToDouble(Double::valueOf)
            .sum();

}
