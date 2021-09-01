package com.functional_groceries.pos;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class SelfCheckout {

    // We read input in an imperative manner because Java does not currently support functional I/O
    private static Function<Void, Stream<String>> scanItems = (nothing) -> {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        boolean checkout = false;

        List<String> items = new ArrayList<>();

        while (!checkout) {
            System.out.print("Scan item: ");

            String input = scanner.nextLine();

            if (input.equals("") || input.equals("done")) {
                checkout = true;
            }
            else {
                items.add(input);
            }
        }

        return items.stream();
    };

    public static void main(String[] args) {

        Double total = SelfCheckout.scanItems
                .andThen(CartSystem.fillCart)
                .andThen(PriceSystem.getCartTotal)
                .apply(null);

        System.out.println("Your total is: " + total);
    }

}
