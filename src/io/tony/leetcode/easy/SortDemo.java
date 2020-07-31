package io.tony.leetcode.easy;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/5/27
 */
public class SortDemo {
  public static void main(String[] args) {
    Random r = new Random();
    int d[] = new int[200];
    for (int i = 0; i < 200; i++) {
      d[i] = r.nextInt(2000);
    }
    Arrays.sort(d);
  }
}
