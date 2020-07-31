package io.tony.leetcode.medium;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/30
 */
public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }
    if (nums.length == 1) {
      return nums[0] == target ? 0 : -1;
    }
    int pivot = -1;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        pivot = i;
        break;
      }
    }
    if (pivot == -1) {
      return doBinarySearch(nums, 0, nums.length-1, target);
    } else {
      int prevMin = nums[0];
      int prevMax = nums[pivot];
      return target >= prevMin && target <= prevMax ? doBinarySearch(nums, 0, pivot, target) :
        doBinarySearch(nums, pivot + 1, nums.length - 1, target);
    }
  }

  private int doBinarySearch(int[] nums, int start, int end, int target) {
    int len = end - start + 1;
    if (len == 0) {
      return -1;
    }
    if (len == 1) {
      return nums[end] == target ? end : -1;
    }
    int middle = len >> 1;
    int middleVal = nums[start + middle];
    return target == middleVal ? start + middle : target > middleVal ? doBinarySearch(nums, start + middle, end, target) :
      doBinarySearch(nums, start, start + middle - 1, target);
  }

  public static void main(String[] args) {
    SearchInRotatedSortedArray si = new SearchInRotatedSortedArray();
    System.out.println(si.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    System.out.println(si.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
    System.out.println(si.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
    System.out.println(si.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    System.out.println(si.search(new int[]{4}, 4));
    System.out.println(si.search(new int[]{4,1}, 1));
    System.out.println(si.search(new int[]{1,3}, 4));
  }
}
