package com.functional_groceries.pos;

import com.functional_groceries.pos.entity.CartItem;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CartSystem {

    private static final Function<Map.Entry<String, Long>, CartItem> entryToCartItem = (entry) ->
            new CartItem(entry.getKey(), entry.getValue());

    public static Function<Stream<String>, Stream<CartItem>> fillCart = (items) -> items
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .map(entryToCartItem);
}
