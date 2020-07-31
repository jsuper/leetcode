package io.tony.leetcode.medium;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/23
 */
public class DivideTwoNum {
  public static void main(String[] args) {
    System.out.println(div(-1, -1));

  }

  public int divide(int dividend, int divisor) {
    return div(dividend, divisor);
  }

  private static int divn(int left, int divisor) {
    if (left <= 0 || left < divisor) {
      return 0;
    }
    if (left == divisor) {
      return 1;
    }
    int cur = 0;
    int dv = divisor;
    while (true) {
      final int temp = dv << 1;
      if (temp < left && temp > 0) {
        dv = temp;
        cur++;
      } else {
        break;
      }
    }
    return (1 << cur) + divn(left - dv, divisor);
  }

  private static int div(int d, int dv) {
    if (d == dv) {
      return 1;
    }
    if (d < 0 && dv < 0 && d > dv) {
      return 0;
    }
    if (d > 0 && dv > 0 && d < dv) {
      return 0;
    }
    if (dv == 1) {
      return d;
    }
    if (dv == -1) {
      return d == Integer.MIN_VALUE ? Integer.MAX_VALUE : 0 - d;
    }
    if (dv == Integer.MIN_VALUE) {
      return 0;
    }
    int ad = d;
    int adv = dv;
    int fac = 0;
    if (ad == Integer.MIN_VALUE) {
      ad = dv > 0 ? ad + dv : ad - dv;
      fac++;
    }
    ad = ad < 0 ? 0 - ad : ad;
    adv = adv < 0 ? 0 - adv : adv;

    boolean isPos = (d > 0 && dv > 0) || (d < 0 && dv < 0);
    int result = fac + divn(ad, adv);
    return isPos ? result : 0 - result;
  }
}
