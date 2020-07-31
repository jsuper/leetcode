package io.tony.leetcode;

import java.util.UUID;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/19
 */
public class Base62Encode {
  public static final String BASE_62_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  public static final int BASE = BASE_62_CHAR.length();

  public static long toBase10(String str) {
    //从右边开始
    return toBase10(new StringBuilder(str).reverse().toString().toCharArray());
  }

  private static long toBase10(char[] chars) {
    long n = 0;
    int pow = 0;
    for (char item : chars) {
      n += toBase10(BASE_62_CHAR.indexOf(item), pow);
      pow++;
    }
    return n;
  }

  private static long toBase10(int n, int pow) {
    return n * (long) Math.pow(BASE, pow);
  }

  public static String fromBase10(long i) {
    StringBuilder sb = new StringBuilder("");
    if (i == 0) {
      return "a";
    }
    while (i > 0) {
      i = fromBase10(i, sb);
    }
    return sb.reverse().toString();
  }

  private static long fromBase10(long i, final StringBuilder sb) {
    int rem = (int) (i % BASE);
    sb.append(BASE_62_CHAR.charAt(rem));
    return i / BASE;
  }

  public static void main(String[] args) {

    System.out.println(fromBase10(Long.MAX_VALUE));
    System.out.println(fromBase10(18));
    System.out.println(fromBase10(System.currentTimeMillis()));
  }
}
