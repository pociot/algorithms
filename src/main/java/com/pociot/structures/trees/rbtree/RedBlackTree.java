package com.pociot.structures.trees.rbtree;

import com.pociot.structures.trees.AbstractTree;
import com.pociot.structures.trees.rbtree.RedBlackTreeNode.Color;

public class RedBlackTree<K extends Comparable<? super K>, V> extends AbstractTree<K, V> {

  private final RedBlackTreeNode<K, V> nil = new RedBlackTreeNode<>(null, null, null, null);

  public RedBlackTree() {
    setRoot(nil);
  }

  @Override
  public RedBlackTreeNode<K, V> searchNode(K key) {
    return iterativeTreeSearch(getRoot(), key);
  }

  @Override
  public void delete(K key) {
    RedBlackTreeNode<K, V> node = searchNode(key);
    if (node != null) {
      rbDelete(node);
    }
  }

  @Override
  public V search(K key) {
    return searchNode(key).getValue();
  }

  @Override
  public void insert(K key, V value) {
    if (key == null) {
      throw new IllegalArgumentException("Key cannot be null");
    }
    rbInsert(new RedBlackTreeNode<>(key, value, null, this.nil));
  }

  @Override
  protected RedBlackTreeNode<K, V> getRoot() {
    return (RedBlackTreeNode<K, V>) super.getRoot();
  }

  @Override
  protected RedBlackTreeNode<K, V> treeMinimum(TreeNode<K, V> x) {
    return (RedBlackTreeNode<K, V>) super.treeMinimum(x);
  }

  private void leftRotate(RedBlackTreeNode<K, V> x) {
    var y = x.getRight();
    x.setRight(y.getLeft());
    if (y.getLeft() != this.nil) {
      y.getLeft().setParent(x);
    }
    rbTransplant(x, y);
    y.setLeft(x);
    x.setParent(y);
  }

  private void rightRotate(RedBlackTreeNode<K, V> x) {
    var y = x.getLeft();
    x.setLeft(y.getRight());
    if (y.getRight() != this.nil) {
      y.getRight().setParent(x);
    }
    y.setParent(x.getParent());
    if (x.getParent() == this.nil) {
      setRoot(y);
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

  private void rbInsert(RedBlackTreeNode<K, V> z) {
    var y = this.nil;
    var x = getRoot();
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
      setRoot(z);
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

  private void rbInsertFixup(RedBlackTreeNode<K, V> z) {
    while (z.getParent().getColor() == Color.RED) {
      if (z.getParent() == z.getParent().getParent().getLeft()) {
        z = leftSideFixup(z);
      } else {
        z = rightSideFixup(z);
      }
    }
    getRoot().setColor(Color.BLACK);
  }

  private RedBlackTreeNode<K, V> rightSideFixup(RedBlackTreeNode<K, V> z) {
    var y = z.getParent().getParent().getLeft();
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

  private RedBlackTreeNode<K, V> leftSideFixup(RedBlackTreeNode<K, V> z) {
    var y = z.getParent().getParent().getRight();
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

  private void rbTransplant(RedBlackTreeNode<K, V> u, RedBlackTreeNode<K, V> v) {
    if (u.getParent() == this.nil) {
      setRoot(v);
    } else if (u == u.getParent().getLeft()) {
      u.getParent().setLeft(v);
    } else {
      u.getParent().setRight(v);
    }
    v.setParent(u.getParent());
  }

  private void rbDelete(RedBlackTreeNode<K, V> z) {
    RedBlackTreeNode<K, V> x;
    var y = z;
    var yOriginalColor = y.getColor();

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

  private void rbDeleteFixup(RedBlackTreeNode<K, V> x) {
    while (x != getRoot() && x.getColor() == Color.BLACK) {
      if (x == x.getParent().getLeft()) {
        x = leftSideDeleteFixup(x);
      } else {
        x = rightSideDeleteFixup(x);
      }
    }
    x.setColor(Color.BLACK);
  }

  private RedBlackTreeNode<K, V> rightSideDeleteFixup(RedBlackTreeNode<K, V> x) {
    var w = x.getParent().getLeft();
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
      x = getRoot();
    }
    return x;
  }

  private RedBlackTreeNode<K, V> leftSideDeleteFixup(RedBlackTreeNode<K, V> x) {
    var w = x.getParent().getRight();
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
      x = getRoot();
    }
    return x;
  }

  private RedBlackTreeNode<K, V> iterativeTreeSearch(RedBlackTreeNode<K, V> x, K k) {
    while (x != this.nil && k.compareTo(x.getKey()) != 0) {
      if (k.compareTo(x.getKey()) < 0) {
        x = x.getLeft();
      } else {
        x = x.getRight();
      }
    }
    return x;
  }

  private void updateColors(RedBlackTreeNode<K, V> z, RedBlackTreeNode<K, V> y) {
    z.getParent().setColor(Color.BLACK);
    y.setColor(Color.BLACK);
    z.getParent().getParent().setColor(Color.RED);
  }
}
