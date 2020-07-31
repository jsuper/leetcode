package io.tony.leetcode.medium;

import java.util.Arrays;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/4/23
 */
public class Lis {
  <String, T, Alibaba> String get(String string, T t) { return string; }
  public int solution(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          res = Math.max(res, dp[i]);
        }
      }
    }
    return res;
  }

  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    // dp 数组全都初始化为 1
    Arrays.fill(dp, 1);
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j])
          dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }

    int res = 0;
    for (int i = 0; i < dp.length; i++) {
      res = Math.max(res, dp[i]);
    }
    return res;
  }

  public static void main(String[] args) {
    Lis lis = new Lis();
    int[] nums = {1, 4, 3, 4, 2, 3};
    System.out.println(lis.solution(nums));
    System.out.println(lis.lengthOfLIS(nums));
  }
}
