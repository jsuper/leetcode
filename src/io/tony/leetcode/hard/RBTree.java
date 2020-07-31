package io.tony.leetcode.hard;

import static io.tony.leetcode.hard.RBTree.Color.BLACK;
import static io.tony.leetcode.hard.RBTree.Color.RED;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/4/9
 */

public class RBTree {
  static enum Color {
    RED, BLACK
  }

  static final Node NIL = new Node(-1, Color.BLACK, null, null, null);

  static class Node {
    int key;
    Color color;
    Node parent;
    Node left;
    Node right;

    public Node(int key, Color color, Node parent, Node left, Node right) {
      this.key = key;
      this.color = color;
      this.parent = parent;
      this.left = left;
      this.right = right;
    }

    Node grandpa() {
      if (parent != null) {
        return parent.parent;
      }
      return null;
    }

    Node uncle() {
      if (parent != null && grandpa() != null) {
        if (parent == grandpa().left) {
          return grandpa().right;
        } else {
          return grandpa().left;
        }
      }
      return null;
    }

    void leftRotate(RBTree tree) {
      boolean currentIsRoot = tree.root == this;
      boolean isLeft = this.parent != null && this == this.parent.left;

      Node newRoot = this.right;
      Node parent = this.parent;
      Node thisRightChild = newRoot.left;

      if (parent != null) {
        newRoot.parent = parent;
        if (isLeft) {
          parent.left = newRoot;
        } else {
          parent.right = newRoot;
        }
      }

      newRoot.left = this;
      this.parent = newRoot;
      this.right = thisRightChild;
      thisRightChild.parent = this;

      if (currentIsRoot) {
        tree.root = newRoot;
      }
    }

    void rightRotate(RBTree tree) {
      //检查是否是根节点
      boolean isTreeRoot = tree.root == this;

      //检查当前节点在其父节点的位置
      boolean isLeft = this.parent != null && this == this.parent.left;

      Node newRoot = this.left;
      Node parent = this.parent;

      Node thisLeftChild = newRoot.right;

      if (parent != null) {
        newRoot.parent = parent;
        if (isLeft) {
          parent.left = newRoot;
        } else {
          parent.right = newRoot;
        }
      }
      newRoot.right = this;
      this.parent = newRoot;
      this.left = thisLeftChild;
      thisLeftChild.parent = this;


      if (isTreeRoot) {
        tree.root = newRoot;
      }
    }

    boolean isRed() {
      return this.color != RED;
    }

    @Override
    public String toString() {
      return "Node{" +
        "key=" + key +
        ", color=" + color +
        '}';
    }
  }

  private Node root;

  public void insert(int key) {
    Node parent = findParent(key);
    Node curNode = new Node(key, RED, parent, NIL, NIL);
    if (parent == null) {
      root = curNode;
    } else {
      if (key < parent.key) {
        parent.left = curNode;
      } else {
        parent.right = curNode;
      }
    }
    fixInsert(curNode);
  }

  private void fixInsert(Node node) {
    while (node.parent != null && node.parent.color == RED) {

      if (node.parent == node.grandpa().left) {
        Node uncle = node.uncle();
        if (uncle.color == RED) {
          node.parent.color = BLACK;
          uncle.color = BLACK;
          node.grandpa().color = RED;
          node = node.grandpa();
        } else if (node == node.parent.right) {
          //情况2，当前节点是父节点的有孩子，旋转树将其转成情况3
          node = node.parent;
          node.leftRotate(this);
        } else {
          //情况3
          node.parent.color = BLACK;
          node.grandpa().color = RED;
          node = node.grandpa();
          node.rightRotate(this);
        }
      } else {
        Node uncle = node.uncle();
        if (uncle.color == RED) {
          node.parent.color = BLACK;
          uncle.color = BLACK;
          node.grandpa().color = RED;
          node = node.grandpa();
        } else if (node == node.parent.left) {
          //情况2，当前节点是父节点的有孩子，旋转树将其转成情况3
          node = node.parent;
          node.leftRotate(this);
        } else {
          node.parent.color = BLACK;
          node.grandpa().color = RED;
          node = node.grandpa();
          node.rightRotate(this);
        }
      }
    }
    root.color = BLACK;
  }

  private Node findParent(int key) {
    Node parent = null;
    Node p = root;
    while (p != null && p != NIL) {
      parent = p;
      if (key < p.key) {
        p = p.left;
      } else {
        p = p.right;
      }
    }
    return parent;
  }

  public void print(Node node) {
    if (node != null) {
      if (node.left != null && node.left != NIL) {
        print(node.left);
      }
      System.out.printf(" %d(%s)", node.key, node.color.name().charAt(0));
      if (node.right != null && node.right != NIL) {
        print(node.right);
      }
    }
  }

  private void transplant(Node u, Node v) {
    if (u.parent == null) {
      root = v;
    } else if (u == u.parent.left) {
      u.parent.left = v;
    } else {
      u.parent.right = v;
    }
    v.parent = u.parent;
  }

  public void print() {
    print(root);
    System.out.println();
  }

  public int height(Node node) {
    if (node == null) {
      return 0;
    }
    return Math.max(height(node.left), height(node.right)) + 1;
  }

  public static void main(String[] args) {
    RBTree rbTree = new RBTree();
    rbTree.insert(41);
    rbTree.print();
    rbTree.insert(38);
    rbTree.print();
    rbTree.insert(31);
    rbTree.print();

    rbTree.insert(12);
    rbTree.print();

    rbTree.insert(19);
    System.out.println(rbTree.root);
    rbTree.print();
    rbTree.insert(8);
    rbTree.print();

  }
}
