package com.functional_groceries.pos.entity;

public class CartItem {
    private String name;
    private Long count;

    public CartItem(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long newCount) {
        this.count = newCount;
    }
}
