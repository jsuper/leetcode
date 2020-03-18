package io.tony.leetcode.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/18
 */
public class RemoveElement {
  public int removeElement(int[] nums, int val) {
    int m = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[m++] = nums[i];
      }
    }
    return m;
  }

  public static void main(String[] args) {
    RemoveElement re = new RemoveElement();
    final int i = re.removeElement(new int[]{3, 2, 2, 3}, 3);
    System.out.println(re.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
  }
}
