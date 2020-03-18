package io.tony.leetcode;

public class StringToIntegerAtoi {
  public int myAtoi(String str) {
    int nonEmptyChar = -1;
    int ret = 0;
    int neg = 1;
    for (int i = 0; i < str.length(); i++) {
      char t = str.charAt(i);
      if (t == ' ' && nonEmptyChar == -1) {
        continue;
      } else {
        if (nonEmptyChar == -1) {
          nonEmptyChar = t;
          if (nonEmptyChar != '-' && nonEmptyChar != '+' && (t < '0' || t > '9')) {
            return 0;
          }
          if (nonEmptyChar == '-') {
            neg = -1;
            continue;
          }
          if (nonEmptyChar == '+') {
            neg = 1;
            continue;
          }
        }

        if (t >= '0' && t <= '9') {
          int delta = (t % 48) * neg;
          if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && delta > Integer.MAX_VALUE % 10))
            return Integer.MAX_VALUE;
          if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && delta < Integer.MIN_VALUE % 10))
            return Integer.MIN_VALUE;
          ret = ret * 10 + (t % 48) * neg;
        } else {
          return ret;
        }
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();
    /*
    System.out.println(stringToIntegerAtoi.myAtoi("    -1w23"));
    ;
    System.out.println(stringToIntegerAtoi.myAtoi("    -1w23"));
    ;
    System.out.println(stringToIntegerAtoi.myAtoi("    -1123"));*/
//    System.out.println(stringToIntegerAtoi.myAtoi("-91283472332"));
//    System.out.println(stringToIntegerAtoi.myAtoi(String.valueOf(Integer.MAX_VALUE) + "1"));
//    System.out.println(stringToIntegerAtoi.myAtoi("words and 987"));
//    System.out.println(stringToIntegerAtoi.myAtoi("4193 with words"));
//    System.out.println(stringToIntegerAtoi.myAtoi("+1"));
    System.out.println(stringToIntegerAtoi.myAtoi("2147483648"));
  }
}
