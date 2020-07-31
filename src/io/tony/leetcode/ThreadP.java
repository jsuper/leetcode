package io.tony.leetcode;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/5/21
 */
public class ThreadP {
  static int counter = 1 ;

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(() -> {
        synchronized (ThreadP.class) {
          System.out.print(counter++);
        }
      });
      t.start();
    }
  }
}
