package com.pociot.structures.trees;

public interface Tree<K extends Comparable<? super K>, V> {

  void insert(K key, V value);

  void delete(K key);

  V search(K key);

  String printInOrder();

  String printInOrder(boolean printValue);

  interface TreeNode<K, V> {

    K getKey();

    V getValue();

    void setValue(V value);

    TreeNode<K, V> getParent();

    void setParent(TreeNode<K, V> parent);

    TreeNode<K, V> getLeft();

    void setLeft(TreeNode<K, V> left);

    TreeNode<K, V> getRight();

    void setRight(TreeNode<K, V> right);
  }
}
