package io.tony.leetcode;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/17
 */
public class IntToRoman {

  public String intToRoman(int num) {
    int n = num;
    StringBuilder number = new StringBuilder();
    while (n != 0) {
      int many;
      String temp;
      if (n / 1000 > 0) {
        many = n / 1000;
        n = n % 1000;
        temp = "M";
      } else if (n / 900 > 0) {
        many = n / 900;
        n = n % 900;
        temp = "CM";
      } else if (n / 500 > 0) {
        many = n / 500;
        n = n % 500;
        temp = "D";
      } else if (n / 400 > 0) {
        many = n / 400;
        n = n % 400;
        temp = "CD";
      } else if (n / 100 > 0) {
        many = n / 100;
        n = n % 100;
        temp = "C";
      } else if (n / 90 > 0) {
        many = n / 90;
        n = n % 90;
        temp = "XC";
      } else if (n / 50 > 0) {
        many = n / 50;
        n = n % 50;
        temp = "L";
      } else if (n / 40 > 0) {
        many = n / 40;
        n = n % 40;
        temp = "XL";
      } else if (n / 10 > 0) {
        many = n / 10;
        n = n % 10;
        temp = "X";
      } else if (n / 9 > 0) {
        many = n / 9;
        n = n % 9;
        temp = "IX";
      } else if (n / 5 > 0) {
        many = n / 5;
        n = n % 5;
        temp = "V";
      } else if (n / 4 > 0) {
        many = n / 4;
        n = n % 4;
        temp = "IV";
      } else {
        many = n;
        n = 0;
        temp = "I";
      }
      for (int i = 0; i < many; i++) {
        number.append(temp);
      }
    }
    return number.toString();
  }

  public static void main(String[] args) {
    final IntToRoman x = new IntToRoman();
    System.out.println(x.intToRoman(1994));
    System.out.println(x.intToRoman(58));
    System.out.println(x.intToRoman(9));
    System.out.println(x.intToRoman(4));
    System.out.println(x.intToRoman(3));
  }
}
