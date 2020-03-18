package io.tony.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/18
 */
public class ValidParentheses {
  public boolean isValid(String s) {
    if (s.isEmpty()) {
      return true;
    }
    LinkedList<Character> queue = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      if (queue.isEmpty()) {
        queue.add(s.charAt(i));
      } else {
        if (isPair(queue.getLast(), s.charAt(i))) {
          queue.removeLast();
        } else {
          queue.add(s.charAt(i));
        }
      }
    }
    return queue.isEmpty();
  }

  private boolean isPair(char f, char s) {
    return (f == '(' && s == ')') ||
      (f == '[' && s == ']') ||
      (f == '{' && s == '}');
  }

  public static void main(String[] args) {
    ValidParentheses v = new ValidParentheses();
//    System.out.println(v.isValid("()[]{}"));
//    System.out.println(v.isValid("(]"));
//    System.out.println(v.isValid("([)]"));
//    System.out.println(v.isValid("{[]}"));
    System.out.println(v.isValid("([)"));
    System.out.println(v.isValid("([)]"));
  }
}
