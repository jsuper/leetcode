package io.tony.leetcode.medium;

import java.math.BigInteger;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/30
 */
public class MutiplyNum {
  public String multiply(String num1, String num2) {
    int n1 = num1.length();
    int n2 = num2.length();
    if (n1 == 0 || n2 == 0) return "";
    if ((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0')) {
      return "0";
    }

    int max = Math.max(num1.length(), num2.length());
    int min = Math.min(num1.length(), num2.length());
    String maxNum, minNum;
    if (num1.length() > num2.length()) {
      maxNum = num1;
      minNum = num2;
    } else {
      maxNum = num2;
      minNum = num1;
    }
    int[][] digits = new int[min][max + min + 1];

    int x = 0;
    int y = digits[0].length - 1;
    for (int i = minNum.length() - 1; i > -1; i--) {
      int cy = y;
      for (int j = maxNum.length() - 1; j > -1; j--) {
        int cur = (minNum.charAt(i) - 48) * (maxNum.charAt(j) - 48) + digits[x][cy];
        if (cur >= 10) {
          digits[x][cy] = cur % 10;
          digits[x][cy - 1] = cur / 10;
        } else {
          digits[x][cy] = cur;
        }
        cy--;
      }
      x++;
      y--;
    }

    print(digits);

    StringBuilder result = new StringBuilder();
    int pre = 0;
    int ySize = digits[0].length;
    int xSize = digits.length;
    for (int i = ySize - 1; i >= 0; i--) {
      int sum = pre;
      for (int j = 0; j < xSize; j++) {
        sum += digits[j][i];
      }
      if (sum >= 10) {
        result.insert(0, sum % 10);
        pre = sum / 10;
      } else {
        result.insert(0, sum);
        pre = 0;
      }
    }
    while (true) {
      //remove leading zero char
      if (result.charAt(0) == '0') {
        result.deleteCharAt(0);
      } else {
        break;
      }
    }
    return result.toString();
  }

  private void print(int[][] digits) {
    for (int i = 0; i < digits.length; i++) {
      for (int j = 0; j < digits.length - (i + 1); j++) {
        System.out.print(" ");
      }
      for (int k = 0; k < digits[i].length; k++) {
        System.out.print(digits[i][k] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    MutiplyNum s = new MutiplyNum();
/*    System.out.println(s.multiply("22", "3"));
    System.out.println(s.multiply("2", "3"));
    System.out.println(s.multiply("2", "30"));
    System.out.println(s.multiply("22", "30"));
    System.out.println(s.multiply("222", "30"));
    System.out.println(s.multiply("123", "456"));
    System.out.println(s.multiply("1234", "456"));
    System.out.println(s.multiply("1", "456"));
    System.out.println(s.multiply("0", "456"));
    System.out.println(s.multiply("999", "456"));
    System.out.println(s.multiply("1000", "2000").equals(String.valueOf(1000 * 2000)));*/
    String multiply = s.multiply("99999", "99999");
    System.out.println(multiply);
    System.out.println(multiply.equals(String.valueOf(99999 * 99999L)));
//    String multiply = s.multiply(String.valueOf(Long.MAX_VALUE), "236");
//    String anObject = String.valueOf(BigInteger.valueOf(Long.MAX_VALUE).multiply(BigInteger.valueOf(236)));
//    System.out.println(multiply + ":" + anObject);
    System.out.println(Long.MAX_VALUE);
    System.out.println(Integer.MAX_VALUE);
  }
}
