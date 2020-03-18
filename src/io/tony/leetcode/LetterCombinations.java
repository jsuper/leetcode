package io.tony.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/17
 */
public class LetterCombinations {
  public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    if (digits.isEmpty()) return ans;
    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    while (ans.peek().length() != digits.length()) {
      String remove = ans.remove();
      String map = mapping[digits.charAt(remove.length()) - '0'];
      for (char c : map.toCharArray()) {
        ans.addLast(remove + c);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(new LetterCombinations().letterCombinations("234"));
  }
}
