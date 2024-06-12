package com.example.test.str;

import java.util.Scanner;

/**
 * ClassName: DistinctStr
 * Package: com.example.demo4
 * Description:
 *
 * @author Star
 * @version v1.0
 * @since 2024/6/12 - 下午4:47
 */
public class DistinctStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input:");
        String line = scanner.nextLine();
        String distinct = distinct(new StringBuilder(line));
        System.out.println("output: " + distinct);
    }

    private static String distinct(StringBuilder builder) {
        if (builder.length() <= 2) {
            return builder.toString();
        }
        for (int i = 0; i < builder.length() - 2; i++) {
            char current = builder.charAt(i);
            if (current == builder.charAt(i + 1) && current == builder.charAt(i + 2)) {
                String replaced = current - 1 >= 'a' ?  String.valueOf((char) (current - 1)) : "";
                StringBuilder replacedBuilder = builder.replace(i, Math.min(i + 3, builder.length()), replaced);
//                builder.delete(i, Math.min(i + 3, builder.length()));
                return distinct(replacedBuilder);
            }
        }
        return builder.toString();
    }
}
