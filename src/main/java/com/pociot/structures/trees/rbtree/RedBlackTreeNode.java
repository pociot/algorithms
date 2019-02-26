package com.pociot.structures.trees.rbtree;

import com.pociot.structures.trees.Tree;

public class RedBlackTreeNode<K, V> extends Tree.TreeNode<K, V> {

  private RedBlackTreeNode<K, V> parent;
  private Color color;

  public RedBlackTreeNode(K key, V value, RedBlackTreeNode<K, V> parent,
      RedBlackTreeNode<K, V> nil) {
    super(key, value, nil, nil);
    this.parent = parent;
    this.color = Color.BLACK;
  }

  public RedBlackTreeNode<K, V> getLeft() {
    return (RedBlackTreeNode<K, V>) super.getLeft();
  }

  public RedBlackTreeNode<K, V> getRight() {
    return (RedBlackTreeNode<K, V>) super.getRight();
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public RedBlackTreeNode<K, V> getParent() {
    return parent;
  }

  public void setParent(RedBlackTreeNode<K, V> parent) {
    this.parent = parent;
  }

  public enum Color {
    RED, BLACK
  }
}
