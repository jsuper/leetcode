package io.tony.leetcode;

public class FirstDuplicateNum {

  public static void main(String[] args) {
    System.out.println(solution(2,3,1,0,2,5));
    System.out.println(solution(1,3,1,0,2,5));
  }

  private static int solution(int... num) {
    int checkbit = 0;
    for (int i = 0; i < num.length; i++) {
      int el = num[i];
      if ((checkbit & (1 << el)) == 0) {
        checkbit = checkbit | (1 << el);
      } else {
        return el;
      }
    }
    return -1;
  }
}
