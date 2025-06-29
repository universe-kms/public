package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class DemoApplicationTests {
    @Test
    void testFirstStage() {
        String input = "aabcccbbad";
        deleteRepeat(input);
    }

    @Test
    void testSecondStage() {
        String input = "abcccbaZd";
        replaceRepeat(input);
    }

    private void deleteRepeat(String s) {
        if (!StringUtils.hasText(s)) {
            System.out.println("字符串为空");
            return;
        }
        Pattern validPattern = Pattern.compile("[a-z]+");
        if (!validPattern.matcher(s).matches()) {
            System.out.println("输入的字符串格式有误，应在字母a-z之间");
            return;
        }
        Pattern pattern = Pattern.compile("(.)\\1{2,}");
        boolean isMatch;
        do {
            isMatch = false;
            Matcher matcher = pattern.matcher(s);
            StringBuilder sb = new StringBuilder();
            int end = 0;
            while (matcher.find()) {
                isMatch = true;
                sb.append(s, end, matcher.start());
                end = matcher.end();
            }
            sb.append(s.substring(end));
            s = sb.toString();
            System.out.println("->" + s);
        } while (isMatch);
    }

    private void replaceRepeat(String s) {
        if (!StringUtils.hasText(s)) {
            System.out.println("字符串为空");
            return;
        }
        Pattern validPattern = Pattern.compile("[a-z]+");
        if (!validPattern.matcher(s).matches()) {
            System.out.println("输入的字符串格式有误，应在字母a-z之间");
            return;
        }
        boolean isMatch;
        Pattern pattern = Pattern.compile("(.)\\1{2,}");
        do {
            isMatch = false;
            Matcher matcher = pattern.matcher(s);
            StringBuilder sb = new StringBuilder();
            int end = 0;

            while (matcher.find()) {
                isMatch = true;
                int start = matcher.start();
                int matchEnd = matcher.end();
                char curChar = s.charAt(start);
                char prevChar = curChar > 'a' ? (char) (curChar - 1) : 'z';
                sb.append(s, end, start);
                if (prevChar != 'z') {
                    sb.append(prevChar);
                }
                end = matchEnd;
            }
            sb.append(s.substring(end));
            s = sb.toString();
            System.out.println("-> " + s);
        } while (isMatch);
    }
}
