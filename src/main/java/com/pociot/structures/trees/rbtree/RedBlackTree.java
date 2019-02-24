package com.pociot.structures.trees.rbtree;

import com.pociot.structures.trees.rbtree.RedBlackTreeNode.Color;

public class RedBlackTree<T extends Comparable<? super T>> {

  private final RedBlackTreeNode<T> nil = new RedBlackTreeNode<>(null, null);
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
      x.getParent().setLeft(y);
    } else {
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
      x.getParent().setRight(y);
    } else {
      x.getParent().setLeft(y);
    }
    y.setRight(x);
    x.setParent(y);
  }

  void insert(T key) {
    rbInsert(new RedBlackTreeNode<>(key, null));
  }

  void rbInsert(RedBlackTreeNode<T> z) {
    RedBlackTreeNode<T> y = this.nil;
    RedBlackTreeNode<T> x = this.root;
    while (x != this.nil) {
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
      } else {
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
      }
    }
    root.setColor(Color.BLACK);
  }

  private void updateColors(RedBlackTreeNode<T> z, RedBlackTreeNode<T> y) {
    z.getParent().setColor(Color.BLACK);
    y.setColor(Color.BLACK);
    z.getParent().getParent().setColor(Color.RED);
  }
}
