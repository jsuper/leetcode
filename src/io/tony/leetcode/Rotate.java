package io.tony.leetcode;

public class Rotate {
  public static void main(String[] args) {
    int[][] num = {
      new int[]{1, 2, 3, 4},
      new int[]{5, 6, 7, 8},
      new int[]{9, 10, 11, 12},
      new int[]{13, 14, 15, 16}
    };
//    print(num);
    rotate(num);
//    System.out.println("rotated");
//    print(num);
  }

  static void print(int[][] num) {
    for (int i = 0; i < num.length; i++) {
      for (int j = 0; j < num[i].length; j++) {
        System.out.print(num[i][j] + " ");
      }
      System.out.println();
    }
  }

  static void rotate(int[][] num, int level) {
    int len = num.length - (level - 1) * 2;
    System.out.print("(" + (level - 1) + "," + (level - 1) + ") -> step: " + len + ", data: ");
    for (int i = level - 1; i < len; i++) {
      int x = i;
      int y = i;
      int cur = num[y][x];

      x = x + (len - 1);
      y = y + 1;
      int temp = num[y][x];
      num[y][x] = cur;
      cur = temp;

      y = y + (len - 1);
      x = x - 1;
      temp = num[y][x];
      num[y][x] = cur;
      cur = temp;

      x = x - (len - 1);
      y = y - 1;
      temp = num[y][x];
      num[y][x] = cur;
      cur = temp;
      num[i][i] = cur;

      /*int nextX = x, nextY = y;
      int current = num[nextY][nextX];
      int step = len - (nextX + 1);
      nextX += len - 1;
      nextY += (len - step);
      int temp = num[nextY][nextX];
      num[nextY][nextX] = current;
      current = temp;

      step = len - (nextY + 1);
      nextY += step;
      nextX -= (len - step);

      temp = num[nextY][nextX];
      num[nextY][nextX] = current;
      current = temp;

      step = nextX - i + 1;
      nextX = nextX - step;
      nextY = nextY - (len - step);

      temp = num[nextY][nextX];
      num[nextY][nextX] = current;

      num[y][i] = temp;*/
    }
    System.out.println();
  }

  static void rotate(int[][] num) {
    int n = num.length;
    int maxLevel = n / 2;

    for (int i = 1; i <= maxLevel; i++) {
      rotate(num, i);
    }
  }
}
