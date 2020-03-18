package io.tony.leetcode.easy;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/18
 */
public class StrStr {
  public int strStr(String haystack, String needle) {
    if (needle == null || needle.isEmpty() || haystack == null || haystack.isEmpty()) {
      return 0;
    }
    for (int i = 0; i < haystack.length() - needle.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(0) && haystack.substring(i, needle.length() + i).equals(needle)) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    StrStr ss = new StrStr();
    ss.strStr("hello", "ll");
  }
}
