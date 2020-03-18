package io.tony.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/18
 */
public class RemoveNthNodeFromEnd {

  public static class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return String.valueOf(val);
    }

    public void print() {

      System.out.print(val);
      ListNode temp = next;
      while (temp != null) {
        System.out.print("->" + temp.val);
        temp = temp.next;
      }
      System.out.println();
    }

    public static ListNode buildNode(int... nums) {
      ListNode head = new ListNode(nums[0]);
      ListNode cur = head;
      for (int i = 1; i < nums.length; i++) {
        ListNode t = new ListNode(nums[i]);
        cur.next = t;
        cur = t;
      }
      return head;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode tail = head;
    ListNode temp = head;
    List<ListNode> nodes = new ArrayList<>();
    while (temp.next != null) {
      nodes.add(temp);
      temp = temp.next;
    }
    nodes.add(temp);
    int idx = nodes.size() - n;
    if (idx == 0) {
      return head.next;
    }
    final ListNode listNode = nodes.get(idx - 1);
    ListNode removed = nodes.get(idx);
    listNode.next = removed.next;
    return head;
  }


  public static void main(String[] args) {
    final RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
    removeNthNodeFromEnd.removeNthFromEnd(ListNode.buildNode(1, 2), 1).print();
    removeNthNodeFromEnd.removeNthFromEnd(ListNode.buildNode(1, 2, 3, 4, 5), 2).print();
  }
}
