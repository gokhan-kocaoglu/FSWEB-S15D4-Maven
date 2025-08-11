package org.example;


import java.util.Locale;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkForPalindrome("I did, did I?")); // true
        System.out.println(checkForPalindrome("Racecar")); // true
        System.out.println(checkForPalindrome("hello")); // false
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));

        System.out.println("****************************");

        WorkintechList<String> list = new WorkintechList<>();

        list.add("Banana");
        list.add("Apple");
        list.add("Orange");
        list.add("Banana"); // duplicate, eklenmeyecek

        System.out.println(list); // [Apple, Banana, Orange]

        list.remove("Banana");
        System.out.println(list); // [Apple, Orange]

        list.add("Grapes");
        list.add("Cherry");
        System.out.println(list); // [Apple, Cherry, Grapes, Orange]

        System.out.println("****************************");

        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(13));
    }

    public static String convertDecimalToBinary(int decimal) {
        if (decimal == 0) return "0";

        Stack<Integer> stack = new Stack<>();

        // Bölme ve kalan ekleme
        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        // Stack'ten pop edip string oluşturma
        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }

    public static boolean checkForPalindrome(String text) {
        if (text == null) return false;

        // Locale bağımsız normalize et
        String clean = text
                .toLowerCase(Locale.ROOT)
                .replaceAll("[^\\p{Alnum}]", ""); // harf ve rakam dışını sil (Unicode uyumlu)

        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }

}