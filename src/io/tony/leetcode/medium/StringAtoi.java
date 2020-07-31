package io.tony.leetcode.medium;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/5/19
 */
public class StringAtoi {
  static class Automation {
    static final int START = 0, SIGNED = 1, NUM = 2, END = 3;
    static final int[][] SM = new int[][]{
      new int[]{START, SIGNED, NUM, END},
      new int[]{END, END, NUM, END},
      new int[]{END, END, NUM, END},
      new int[]{END, END, END, END}
    };

    int state = START;
    int sign = 1;
    int ans = 0;

    public int getCol(char c) {
      if (c == ' ') return 0;
      if (c == '+' || c == '-') return 1;
      if (c >= '0' && c <= '9') return 2;
      return 3;
    }

    public boolean get(char c) {
      int col = getCol(c);
      this.state = SM[state][col];
      if (state == NUM) {
        int cur = (c - '0') * sign;
        if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && cur > 7)) {
          ans = Integer.MAX_VALUE;
          state = END;
        } else if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && cur < -8)) {
          ans = Integer.MIN_VALUE;
          state = END;
        } else {
          ans = ans * 10 + cur;
        }
      } else if (state == SIGNED) {
        sign = c == '-' ? -1 : 1;
      }
      return state != END;
    }

  }

  public int myAtoi2(String string) {
    if (string == null || string.isEmpty()) {
      return 0;
    }
    Automation a = new Automation();
    for (int i = 0; i < string.length() && a.get(string.charAt(i)); i++) {
    }
    return a.ans;
  }

  public int myAtoi(String str) {
    if (str == null || str.isEmpty()) return 0;

    int result = 0;
    int neg = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int cur = c - '0';
      if ((c == '-' || c == '+') && i < str.length() - 1) {
        int next = str.charAt(i + 1) - '0';
        if (next >= 0 && next <= 9) {
          neg = c == '-' ? 1 : 0;
          continue;
        } else {
          break;
        }
      }
      if ((cur < 0 || cur > 9) && cur != -16) {
        break;
      }
      ;
      if (cur == -16) {
        continue;
      }
      cur = neg == 1 ? cur * -1 : cur;
      if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && cur > 7)) return Integer.MAX_VALUE;
      if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && cur < -8)) return Integer.MIN_VALUE;
      result = result * 10 + cur;
    }
    return result;
  }

  public static void main(String[] args) {
    StringAtoi stringAtoi = new StringAtoi();
    System.out.println(stringAtoi.myAtoi2("2147483648"));
  }
}
