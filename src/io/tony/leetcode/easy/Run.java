package io.tony.leetcode.easy;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/6/11
 */
public class Run {
  private int n;
  int x = 1;
  Semaphore zero = new Semaphore(1);
  Semaphore even = new Semaphore(0);
  Semaphore odd = new Semaphore(0);

  public Run(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    while (x <= n) {
      zero.acquire();
      if (x <= n) {
        printNumber.accept(0);
      }
      if (x % 2 == 0) {
        even.release();
      } else {
        odd.release();
      }
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    while (x <= n) {
      even.acquire();
      if (x <= n) {
        printNumber.accept(x);
        x++;
      }
      zero.release();
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    while (x <= n) {
      odd.acquire();
      if (x <= n) {
        printNumber.accept(x);
        x++;
      }
      zero.release();
    }
  }

  public static void main(String[] args) {
    Run r = new Run(6);
    Thread z = new Thread(() -> {
      try {
        r.zero(System.out::print);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    Thread e = new Thread(() -> {
      try {
        r.even(i->System.out.printf("even(%d)",i));
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    });
    Thread o = new Thread(() -> {
      try {
        r.odd(i->System.out.printf("odd(%d)",i));
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    });
    e.start();
    z.start();
    o.start();

  }
}
