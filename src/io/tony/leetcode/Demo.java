package io.tony.leetcode;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/5/19
 */
public class Demo {
  static class A {
    public A(){
      System.out.println("new a");
    }
  }
  static class B extends A {
    public B(){
      System.out.println("new b");
    }
  }

  public static void main(String[] args) {
    A a = new B();
  }
}
