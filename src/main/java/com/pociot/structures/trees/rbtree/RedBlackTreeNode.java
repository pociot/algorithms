package com.pociot.structures.trees.rbtree;

public class RedBlackTreeNode<T extends Comparable<? super T>> {

  private final T key;
  private RedBlackTreeNode<T> parent;
  private RedBlackTreeNode<T> left;
  private RedBlackTreeNode<T> right;
  private Color color;

  public RedBlackTreeNode(T key, RedBlackTreeNode<T> parent, RedBlackTreeNode<T> nil) {
    this.parent = parent;
    this.key = key;
    this.left = nil;
    this.right = nil;
    this.color = Color.BLACK;
  }

  public T getKey() {
    return key;
  }

  public RedBlackTreeNode<T> getLeft() {
    return left;
  }

  public void setLeft(RedBlackTreeNode<T> left) {
    this.left = left;
  }

  public RedBlackTreeNode<T> getRight() {
    return right;
  }

  public void setRight(RedBlackTreeNode<T> right) {
    this.right = right;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public RedBlackTreeNode<T> getParent() {
    return parent;
  }

  public void setParent(RedBlackTreeNode<T> parent) {
    this.parent = parent;
  }

  public enum Color {
    RED, BLACK
  }
}
