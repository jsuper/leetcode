package io.tony.leetcode.medium;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/4/23
 */
public class StringMatch {

  public static void main(String[] args) {
    System.out.println(isMatch("aac", "a*c"));

  }

  static boolean isMatch(String text, String pattern) {
    if (pattern == null || pattern.isEmpty()) return text == null || text.isEmpty();

    boolean firstMatch = !text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      return isMatch(text, pattern.substring(2)) ||
        (firstMatch && isMatch(text.substring(1), pattern));
    } else {
      return firstMatch && isMatch(text.substring(1), pattern.substring(1));
    }
  }
}
