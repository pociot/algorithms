package com.pociot.structures.trees;

public abstract class Tree<K extends Comparable<? super K>, V> {

  private TreeNode<K, V> root;

  public abstract void insert(K key, V value);

  public abstract void delete(K key);

  public abstract V search(K key);

  protected TreeNode<K, V> getRoot() {
    return root;
  }

  protected void setRoot(TreeNode<K, V> root) {
    this.root = root;
  }

  public static class TreeNode<K, V> {

    private final K key;
    private V value;
    private TreeNode<K, V> left;
    private TreeNode<K, V> right;

    public TreeNode(K key, V value, TreeNode<K, V> left,
        TreeNode<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    public TreeNode<K, V> getLeft() {
      return left;
    }

    public void setLeft(TreeNode<K, V> left) {
      this.left = left;
    }

    public TreeNode<K, V> getRight() {
      return right;
    }

    public void setRight(TreeNode<K, V> right) {
      this.right = right;
    }
  }
}
