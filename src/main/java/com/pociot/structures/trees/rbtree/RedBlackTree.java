package com.pociot.structures.trees.rbtree;

import com.pociot.structures.trees.rbtree.RedBlackTreeNode.Color;

public class RedBlackTree<T extends Comparable<? super T>> {

  private final RedBlackTreeNode<T> nil = new RedBlackTreeNode<>(null, null, null);
  RedBlackTreeNode<T> root = nil;


  void leftRotate(RedBlackTreeNode<T> x) {
    RedBlackTreeNode<T> y = x.getRight();
    x.setRight(y.getLeft());
    if (y.getLeft() != this.nil) {
      y.getLeft().setParent(x);
    }
    y.setParent(x.getParent());
    if (x.getParent() == this.nil) {
      this.root = y;
    } else if (x == x.getParent().getLeft()) {
      //noinspection SuspiciousNameCombination
      x.getParent().setLeft(y);
    } else {
      //noinspection SuspiciousNameCombination
      x.getParent().setRight(y);
    }
    y.setLeft(x);
    x.setParent(y);
  }

  void rightRotate(RedBlackTreeNode<T> x) {
    RedBlackTreeNode<T> y = x.getLeft();
    x.setLeft(y.getRight());
    if (y.getRight() != this.nil) {
      y.getRight().setParent(x);
    }
    y.setParent(x.getParent());
    if (x.getParent() == this.nil) {
      this.root = y;
    } else if (x == x.getParent().getRight()) {
      //noinspection SuspiciousNameCombination
      x.getParent().setRight(y);
    } else {
      //noinspection SuspiciousNameCombination
      x.getParent().setLeft(y);
    }
    y.setRight(x);
    x.setParent(y);
  }

  void insert(T key) {
    rbInsert(new RedBlackTreeNode<>(key, null, this.nil));
  }

  void rbInsert(RedBlackTreeNode<T> z) {
    RedBlackTreeNode<T> y = this.nil;
    RedBlackTreeNode<T> x = this.root;
    while (x != this.nil) {
      //noinspection SuspiciousNameCombination
      y = x;
      if (z.getKey().compareTo(x.getKey()) < 0) {
        x = x.getLeft();
      } else {
        x = x.getRight();
      }
    }
    z.setParent(y);
    if (y == this.nil) {
      this.root = z;
    } else if (z.getKey().compareTo(y.getKey()) < 0) {
      y.setLeft(z);
    } else {
      y.setRight(z);
    }
    z.setLeft(this.nil);
    z.setRight(this.nil);
    z.setColor(Color.RED);
    rbInsertFixup(z);
  }

  void rbInsertFixup(RedBlackTreeNode<T> z) {
    while (z.getParent().getColor() == Color.RED) {
      if (z.getParent() == z.getParent().getParent().getLeft()) {
        z = leftSideFixup(z);
      } else {
        z = rightSideFixup(z);
      }
    }
    root.setColor(Color.BLACK);
  }

  private RedBlackTreeNode<T> rightSideFixup(RedBlackTreeNode<T> z) {
    RedBlackTreeNode<T> y = z.getParent().getParent().getLeft();
    if (y.getColor() == Color.RED) {
      updateColors(z, y);
      z = z.getParent().getParent();
    } else {
      if (z == z.getParent().getLeft()) {
        z = z.getParent();
        rightRotate(z);
      }
      z.getParent().setColor(Color.BLACK);
      z.getParent().getParent().setColor(Color.RED);
      leftRotate(z.getParent().getParent());
    }
    return z;
  }

  private RedBlackTreeNode<T> leftSideFixup(RedBlackTreeNode<T> z) {
    RedBlackTreeNode<T> y = z.getParent().getParent().getRight();
    if (y.getColor() == Color.RED) {
      updateColors(z, y);
      z = z.getParent().getParent();
    } else {
      if (z == z.getParent().getRight()) {
        z = z.getParent();
        leftRotate(z);
      }
      z.getParent().setColor(Color.BLACK);
      z.getParent().getParent().setColor(Color.RED);
      rightRotate(z.getParent().getParent());
    }
    return z;
  }

  void rbTransplant(RedBlackTreeNode<T> u, RedBlackTreeNode<T> v) {
    if (u.getParent() == this.nil) {
      root = v;
    } else if (u == u.getParent().getLeft()) {
      u.getParent().setLeft(v);
    } else {
      u.getParent().setRight(v);
    }
    v.setParent(u.getParent());
  }

  RedBlackTreeNode<T> treeMinimum(RedBlackTreeNode<T> x) {
    while (x.getLeft() != this.nil) {
      x = x.getLeft();
    }
    return x;
  }

  void rbDelete(RedBlackTreeNode<T> z) {
    RedBlackTreeNode<T> y = z;
    RedBlackTreeNode<T> x;
    Color yOriginalColor = y.getColor();

    if (z.getLeft() == this.nil) {
      x = z.getRight();
      rbTransplant(z, z.getRight());
    } else if (z.getRight() == this.nil) {
      x = z.getLeft();
      rbTransplant(z, z.getLeft());
    } else {
      y = treeMinimum(z.getRight());
      yOriginalColor = y.getColor();
      x = y.getRight();
      if (y.getParent() == z) {
        x.setParent(y);
      } else {
        rbTransplant(y, y.getRight());
        y.setRight(z.getRight());
        y.getRight().setParent(y);
      }
      rbTransplant(z, y);
      y.setLeft(z.getLeft());
      y.getLeft().setParent(y);
      y.setColor(z.getColor());
    }
    if (yOriginalColor == Color.BLACK) {
      rbDeleteFixup(x);
    }
  }

  void rbDeleteFixup(RedBlackTreeNode<T> x) {
    while (x != this.root && x.getColor() == Color.BLACK) {
      if (x == x.getParent().getLeft()) {
        x = leftSideDeleteFixup(x);
      } else {
        x = rightSideDeleteFixup(x);
      }
    }
    x.setColor(Color.BLACK);
  }

  private RedBlackTreeNode<T> rightSideDeleteFixup(RedBlackTreeNode<T> x) {
    RedBlackTreeNode<T> w = x.getParent().getLeft();
    if (w.getColor() == Color.RED) {
      w.setColor(Color.BLACK);
      x.getParent().setColor(Color.RED);
      rightRotate(x.getParent());
      w = x.getParent().getLeft();
    }
    if (w.getLeft().getColor() == Color.BLACK && w.getRight().getColor() == Color.BLACK) {
      w.setColor(Color.RED);
      x = x.getParent();
    } else {
      if (w.getLeft().getColor() == Color.BLACK) {
        w.getRight().setColor(Color.BLACK);
        w.setColor(Color.RED);
        leftRotate(w);
        w = x.getParent().getLeft();
      }
      w.setColor(x.getParent().getColor());
      x.getParent().setColor(Color.BLACK);
      w.getLeft().setColor(Color.BLACK);
      rightRotate(x.getParent());
      x = this.root;
    }
    return x;
  }

  private RedBlackTreeNode<T> leftSideDeleteFixup(RedBlackTreeNode<T> x) {
    RedBlackTreeNode<T> w = x.getParent().getRight();
    if (w.getColor() == Color.RED) {
      w.setColor(Color.BLACK);
      x.getParent().setColor(Color.RED);
      leftRotate(x.getParent());
      w = x.getParent().getRight();
    }
    if (w.getLeft().getColor() == Color.BLACK && w.getRight().getColor() == Color.BLACK) {
      w.setColor(Color.RED);
      x = x.getParent();
    } else {
      if (w.getRight().getColor() == Color.BLACK) {
        w.getLeft().setColor(Color.BLACK);
        w.setColor(Color.RED);
        rightRotate(w);
        w = x.getParent().getRight();
      }
      w.setColor(x.getParent().getColor());
      x.getParent().setColor(Color.BLACK);
      w.getRight().setColor(Color.BLACK);
      leftRotate(x.getParent());
      x = this.root;
    }
    return x;
  }

  RedBlackTreeNode<T> iterativeTreeSearch(RedBlackTreeNode<T> x, T k) {
    while (x != this.nil && k.compareTo(x.getKey()) != 0) {
      if (k.compareTo(x.getKey()) < 0) {
        x = x.getLeft();
      } else {
        x = x.getRight();
      }
    }
    return x;
  }

  public RedBlackTreeNode<T> search(T key) {
    return iterativeTreeSearch(this.root, key);
  }

  public void delete(T key) {
    rbDelete(search(key));
  }

  private void updateColors(RedBlackTreeNode<T> z, RedBlackTreeNode<T> y) {
    z.getParent().setColor(Color.BLACK);
    y.setColor(Color.BLACK);
    z.getParent().getParent().setColor(Color.RED);
  }
}
