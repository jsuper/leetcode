package io.tony.leetcode;

import java.util.Objects;

public class PrintNum {

  interface IncrEl<T> {
    void incr();

    String value();

    boolean stop();
  }

  static class TypePrinter<T> implements Runnable {

    private IncrEl<T> start;
    private Object myLock;
    private Object nextLock;

    public TypePrinter(IncrEl<T> start, Object myLock, Object nextLock) {
      this.start = start;
      this.myLock = myLock;
      this.nextLock = nextLock;
      Objects.requireNonNull(myLock);
      Objects.requireNonNull(nextLock);
    }

    @Override
    public void run() {
      try {
        while (!start.stop()) {
          synchronized (myLock) {
            System.out.println(start.value());
            start.incr();
            myLock.notifyAll();
          }
          synchronized (nextLock) {
            nextLock.wait();
          }
        }
      } catch (InterruptedException e) {
        //ignore
      }
    }
  }

  public static void main(String[] args) {
    IncrEl<Character> charEl = new IncrEl<Character>() {
      private char start = 'a';

      @Override
      public void incr() {
        start++;
      }

      @Override
      public String value() {
        return String.valueOf((char) start);
      }

      @Override
      public boolean stop() {
        return start == (char) ('z' + 1);
      }
    };
    IncrEl<Integer> intEl = new IncrEl<Integer>() {
      private int value = 1;

      @Override
      public void incr() {
        value++;
      }

      @Override
      public String value() {
        return String.valueOf(value);
      }

      @Override
      public boolean stop() {
        return value == 27;
      }
    };
    Object charThreadLock = new Object();
    Object intLock = new Object();
    TypePrinter<Character> charp = new TypePrinter<>(charEl, charThreadLock, intLock);
    TypePrinter<Integer> intp = new TypePrinter<>(intEl, intLock, charThreadLock);
    /*synchronized (intLock) {
      new Thread(intp).start();
    }*/
    charp.run();
   /*synchronized (intLock) {
     charThreadLock.notifyAll();
   }*/
  }
}
