package io.tony.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/4/23
 */
public class ThreadPrint {
  static Object MAIN = new Object();
  static Object THREAD = new Object();

  static void sleep(long m) {
//    try {
//      Thread.sleep(m);
//    } catch (InterruptedException e) {
//      //
//    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(() -> {
      System.out.println("Thread started");
      int s = 'a';
      while (s <= 'z') {
        synchronized (THREAD) {
          try {
            THREAD.wait();
          } catch (InterruptedException e) {
            //
          }
        }
        System.out.print((char) s + " ");
        s++;
        sleep(500);
        synchronized (MAIN) {
          MAIN.notifyAll();
        }
      }
    });
    t.start();
    int n = 1;
    while (n <= 26) {
      System.out.print(n + " ");
      n++;
      synchronized (MAIN) {
        synchronized (THREAD) {
          sleep(500);
          THREAD.notifyAll();
        }
        MAIN.wait();
      }
    }
  }
}
