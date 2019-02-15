package com.pociot.structures.trees;

public class TreeNode<T extends Comparable<? super T>> {

  private T key;
  private TreeNode<T> left;
  private TreeNode<T> right;

  public TreeNode(T key) {
    setKey(key);
    setLeft(null);
    setRight(null);
  }

  public T getKey() {
    return key;
  }

  public void setKey(T key) {
    this.key = key;
  }

  public TreeNode<T> getLeft() {
    return left;
  }

  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }

  public TreeNode<T> getRight() {
    return right;
  }

  public void setRight(TreeNode<T> right) {
    this.right = right;
  }
}
