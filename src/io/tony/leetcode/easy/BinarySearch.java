package io.tony.leetcode.easy;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/5/27
 */
public class BinarySearch {

  public static int bs(int[] a, int target) {
    int low = 0;
    int high = a.length-1;
    while (low < high) {
      int mid = (low+high+1)>>>1;
      System.out.println(mid);
      if (a[mid] == target) {
        return mid;
      } else if (a[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int d[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(bs(d,1));
//    System.out.println(bs(d,10));
//    System.out.println(bs(d,8));
  }
}
