package io.tony.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/17
 */
public class ThreeSumClosest {

  /*public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length < 3) {
      return 0;
    }

    int minDist = Integer.MAX_VALUE;
    int sum = 0;
    if (nums.length == 3) {
      return nums[0] + nums[1] + nums[2];
    }
    for (int i = 0; i < nums.length; i++) {
      int t = nums[i];
      for (int j = i + 1; j < nums.length - 1 ; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          final int threeSum = t + nums[j] + nums[k];
          System.out.println(threeSum + ": " + t + "," + nums[j] + "," + nums[k]);
          int dist = Math.abs(target - threeSum);
          if (dist < minDist) {
            sum = threeSum;
            minDist = dist;
          }
        }
      }
    }
    return sum;
  }*/
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int closest = nums[0] + nums[1] + nums[2];
    int low, high;
    for (int i = 0; i < nums.length - 1; i++) {
      low = i + 1;
      high = nums.length - 1;
      while (low < high) {
        //如果等于目标值，直接返回
        if (nums[low] + nums[high] == target - nums[i]) {
          return target;
        } else if (nums[low] + nums[high] > target - nums[i]) {
          //如果大于目标值
          while (low < high && nums[low] + nums[high] > target - nums[i]){
            //移动到和小于目标值的位置
            high--;
          }
          if (Math.abs(nums[i] + nums[low] + nums[high + 1] - target) < Math.abs(closest - target))
            closest = nums[i] + nums[low] + nums[high + 1];
        } else {
          while (low < high && nums[low] + nums[high] < target - nums[i]) low++;
          if (Math.abs(nums[i] + nums[low - 1] + nums[high] - target) < Math.abs(closest - target))
            closest = nums[i] + nums[low - 1] + nums[high];
        }
      }
    }
    return closest;
  }

  public static void main(String[] args) {
//    System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
//    System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
    System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0, 2, 1, -3}, 1));
  }
}
