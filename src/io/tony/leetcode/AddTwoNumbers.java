package io.tony.leetcode;

public class AddTwoNumbers {

  public static void main(String[] args) {
    int[] a = {2, 4, 3};
    int[] b = {5, 6, 4};
    ListNode l1 = build(a);
    ListNode l2 = build(b);
    add(l1, l2);
  }

  private static ListNode build(int[] da) {
    ListNode root = new ListNode(da[0]);
    ListNode current = null;
    for (int i = 1; i < da.length; i++) {
      if (current == null) {
        current = new ListNode(da[i]);
        root.next = current;
      } else {
        ListNode temp = current;
        temp.next = new ListNode(da[i]);
        current = temp.next;
      }
    }
    return root;
  }

  public static ListNode add(ListNode l1, ListNode l2) {
    ListNode n1 = l1, n2 = l2;
    ListNode result = null;
    ListNode current = null;
    int addNum = 0;
    while (n1 != null && n2 != null) {
      int n1v = n1.val;
      int n2v = n2.val;
      int val = n1v + n2v;
      ListNode temp;
      if (n1v + n2v >= 10) {
        addNum = 1;
        val = 0;
        temp = new ListNode(0);
      } else {
        if (addNum == 1) {
          val += 1;
          addNum = 0 ;
        }
        if (val >= 10) {
          val = 0;
          addNum = 1;
        }
        temp = new ListNode(val);
      }
      if (result == null) {
        result = temp;
        current = temp ;
      } else {
        current.next = temp;
        current = temp;
      }
      n1 = n1.next;
      n2 = n2.next ;
    }
    ListNode f = n1 == null && n2 == null ? null : n1 != null ? n1 : n2;
    if (f == null) {
      if (addNum == 1) {
        current.next = new ListNode(1);
      }
      return result;
    } else {
      while (f != null) {
        int v = f.val;
        if (addNum == 1) {
          v = f.val + 1;
          if (v >= 10) {
            addNum = 1;
            v = 0;
          }
        }
        ListNode node = new ListNode(v);
        current.next = node;
        current = node;
      }
    }
    return result;
  }

  static class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }
  }
}
