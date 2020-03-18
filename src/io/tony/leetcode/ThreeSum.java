package io.tony.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/17
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 3) {
      return Collections.emptyList();
    }
    long s = System.currentTimeMillis();
    List<List<Integer>> result = new ArrayList<>();
    Map<String, Integer> dist = new HashMap<>();
    Map<Integer, Integer> numMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      numMap.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int t = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        int jt = nums[j];
        int l = 0 - t - jt;
        if (numMap.containsKey(l) && numMap.get(l) != i && numMap.get(l) != j) {
          List<Integer> d = Arrays.asList(t, jt, l);
          int min = min(Math.min(t, jt), l);
          int max = max(Math.max(t, jt), l);
          String key = min + "-" + (0 - max - min) + "-" + max;
          if (!dist.containsKey(key)) {
            result.add(d);
            dist.put(key, 1);
          }
        }
      }
    }
    System.out.println(System.currentTimeMillis() - s);
    return result;
  }

  public int max(int i, int j) {
    return i > j ? i : j;
  }

  public int min(int i, int j) {
    return i < j ? i : j;
  }

  public static void main(String[] args) {
    System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }
}
