package io.tony.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/17
 */
public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] input) {
    if (input == null) {
      return null;
    }
    if (input.length == 1) {
      return input[0];
    }
    String prefix = "";
    int idx = 0;
    boolean stop = false;
    while (!stop) {
      boolean allSame = false;
      Character cur = null;
      for (String i : input) {
        if (idx < i.length()) {
          if (cur == null) {
            cur = i.charAt(idx);
            allSame = true;
          } else {
            allSame = allSame && cur.charValue() == i.charAt(idx);
          }
        } else {
          stop = true;
          allSame = false;
          break;
        }
      }
      if (allSame) {
        prefix += cur;
        idx++;
      } else {
        stop = true;
      }
    }
    System.out.println(prefix);
    return prefix;
  }

  public String longestCommonPrefixB(String[] input) {
    if (input == null) {
      return "";
    }
    if (input.length == 1) {
      return input[0];
    }
    return longest(input, 0, input.length - 1);
  }

  private String longestCommonPrefixO(String input[]) {
    if (input == null || input.length == 0) {
      return "";
    }
    if (input.length == 1) {
      return input[0];
    }
    if (input.length == 2) {
      return prefix(input[0], input[1]);
    }
    int i = 1;
    int j = input.length - 1;
    String prefix = input[0];
    while (i <= j) {
      String temp = prefix(input[i], input[j]);
      if (temp == null || temp.length() == 0) {
        return "";
      }
      prefix = prefix(prefix, temp);
      if (prefix == null || prefix.length() == 0) {
        return "";
      }
      i++;
      j--;
    }
    return prefix;
  }

  private String longest(String[] input, int start, int end) {
    int len = end - start + 1;
    if (len == 1) {
      return input[0];
    }
    if (len == 2) {
      return prefix(input[start], input[end]);
    }
    int mid = len >> 1;
    String left = longest(input, start, start + mid - 1);
    String right = longest(input, start + mid, end);
    return prefix(left, right);
  }

  private String prefix(String left, String right) {
    String prefix = "";
    int idx = 0;
    while (idx < left.length() && idx < right.length() && left.charAt(idx) == right.charAt(idx)) {
      prefix += left.charAt(idx);
      idx++;
    }
    return prefix;
  }

  public static void main(String[] args) {
    final LongestCommonPrefix lp = new LongestCommonPrefix();
    String[] input = {"flower", "flow", "flight"};
    System.out.println("prefix of: " + Arrays.toString(input) + " - " + lp.longestCommonPrefixO(input));

    input = new String[]{"dog", "racecar", "car"};
    System.out.println("prefix of: " + Arrays.toString(input) + " - " + lp.longestCommonPrefixB(input));

    input = new String[]{"aa", "a"};
    final String s = lp.longestCommonPrefixO(input);
    System.out.println("prefix of: " + Arrays.toString(input) + " - " + s);
  }
}
