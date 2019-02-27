package com.pociot.structures.trees.rbtree;

import com.pociot.structures.trees.AbstractTree;

public class RedBlackTreeNode<K, V> extends AbstractTree.SimpleTreeNode<K, V> {

  private Color color;

  public RedBlackTreeNode(K key, V value, RedBlackTreeNode<K, V> parent,
      RedBlackTreeNode<K, V> nil) {
    super(key, value, parent, nil, nil);
    this.color = Color.BLACK;
  }

  @Override
  public RedBlackTreeNode<K, V> getLeft() {
    return (RedBlackTreeNode<K, V>) super.getLeft();
  }

  @Override
  public RedBlackTreeNode<K, V> getRight() {
    return (RedBlackTreeNode<K, V>) super.getRight();
  }

  @Override
  public RedBlackTreeNode<K, V> getParent() {
    return (RedBlackTreeNode<K, V>) super.getParent();
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public enum Color {
    RED, BLACK
  }
}
