package io.tony.leetcode.hard;

import io.tony.leetcode.RemoveNthNodeFromEnd.ListNode;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/18
 */
public class ReverseKGroup {

  public ListNode reverseKGroup(ListNode node, int k) {
    if (node == null || node.next == null) {
      return node;
    }
    int len = 0;
    ListNode result = new ListNode(-1);
    ListNode curTail = result;
    ListNode tempHead = node;
    ListNode p = node;
    while (p != null) {
      len++;
      if (len == k) {
        ListNode nextNodes = p.next;
        p.next = null;

        ListNode next = tempHead.next;
        tempHead.next = null;
        ListNode head = tempHead, tail = tempHead;
        while (next != null) {
          ListNode leftNode = next.next;
          next.next = head;
          head = next;
          next = leftNode;
        }
        curTail.next = head ;
        curTail = tail;
        len = 0;
        p = nextNodes;
        tempHead = nextNodes;
      } else {
        p = p.next;
      }
    }
    if (len > 0) {
      curTail.next = tempHead;
    }
    return result.next;
  }

  private ListNode[] reverse(ListNode rvNode) {
    ListNode next = rvNode.next;
    rvNode.next = null;
    ListNode head = rvNode, tail = rvNode;
    while (next != null) {
      ListNode leftNode = next.next;
      next.next = head;
      head = next;
      next = leftNode;
    }
    return new ListNode[]{head, tail};
  }

  public static void main(String[] args) {
    ReverseKGroup rk = new ReverseKGroup();
//    rk.reverse(ListNode.buildNode(1, 2, 3, 4, 5));
//    rk.reverse(ListNode.buildNode(1, 2, 3, 4, 5))[0].print();
    rk.reverseKGroup(ListNode.buildNode(1, 2, 3, 4, 5), 2).print();
    rk.reverseKGroup(ListNode.buildNode(1, 2, 3, 4, 5), 3).print();
  }
}
