package io.tony.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LongestSubString {
  public static void main(String[] args) {
    System.out.println(longest("abcab"));
  }

  public static int longest(String s) {
    int n = s.length(), ans = 0;
    int[] index = new int[128]; // current index of character
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < n; j++) {
      i = Math.max(index[s.charAt(j)], i);
      ans = Math.max(ans, j - i + 1);
      index[s.charAt(j)] = j + 1;
    }
    return ans;
  }
}
