package io.tony.leetcode;

public class ArrayMove {
  public static void main(String[] args) {
    print(new int[][]{
      new int[]{1, 2, 3, 4},
      new int[]{5, 6, 7, 8},
      new int[]{9, 10, 11, 12},
      new int[]{13, 14, 15, 16}
    });
  }

  private static void print(int[][] n) {
    int x = 1, y = 0;
    int minX = 1;
    int minY = 0;
    int step = n.length;
    int direction = 1;
    int count = 0;
    do {
      System.out.println(n[y][x]);
      count++;
      if (count == 2) {
        direction = -1;
      }
      int nx = Math.max(minX, Math.min(n.length - 1, x + (step - 1) * direction));
      int xs = step - (Math.abs(nx - x) + 1);
      int ny = Math.max(minY, Math.min(n.length - 1, y + xs * direction));
      int ys = step - (Math.abs(ny - y) + 1);
      if (ys > 0) {
        nx = Math.max(minX, Math.min(n.length - 1, x + ys * direction));
      }

      x = nx;
      y = ny;
     /* if (x < n.length - 1 && y < n.length - 1) {
        int fx = Math.min(n.length - 1, x + step - 1);
        int fy = y + (step - (fx - x + 1));
        x = fx;
        y = fy;
      } else if (x == n.length - 1 && y < n.length - 1) {
        int fy = Math.min(n.length - 1, y + step - 1);
        x = x + (step - (fy - y + 1)) ;
        y = fy;
      } else if (x == n.length - 1 && y == n.length - 1) {
        x = Math.max(minX, x - step + 1);
      } else if (x < n.length - 1 && y == n.length - 1) {
        int nx = Math.max(minX, x - step + 1);
        int bx = nx - x;
        int ny = Math.max(minY, y - (step - bx) + 1);
        x = nx;
        y = ny;
      }*/

    } while (x != minX || y != minY);
  }
}
