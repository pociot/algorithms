package com.pociot.structures.trees.bts;

import com.pociot.structures.trees.TreeNode;

public class BinarySearchTree<T extends Comparable<? super T>> {
  private TreeNode<T> root;

  public BinarySearchTree() {
    root = null;
  }

  public void insert(T key) {
    root = insertRecursive(key, root);
  }

  private TreeNode<T> insertRecursive(T key, TreeNode<T> root) {
    if (root == null) {
      root = new TreeNode<>(key);
      return root;
    }

    if (key.compareTo(root.getKey()) < 0) {
      root.setLeft(insertRecursive(key, root.getLeft()));
    } else if (key.compareTo(root.getKey()) > 0) {
      root.setRight(insertRecursive(key, root.getRight()));
    }

    return root;
  }

  public String printInOrder() {
    StringBuilder stringBuilder = new StringBuilder();
    printInOrderRecursive(root, stringBuilder);
    return stringBuilder.toString();
  }

  protected String print2DUtil() {
    StringBuilder stringBuilder = new StringBuilder();
    print2DUtil(root, 0, stringBuilder);
    return stringBuilder.toString();
  }

  private void print2DUtil(TreeNode root, int space, StringBuilder stringBuilder) {
    if (root == null)
      return;

    space += 4;

    print2DUtil(root.getRight(), space, stringBuilder);

    stringBuilder.append("\n");
    for (int i = 4; i < space; i++)
      stringBuilder.append(" ");
    stringBuilder.append(root.getKey()).append("\n");

    print2DUtil(root.getLeft(), space, stringBuilder);
  }

  private void printInOrderRecursive(TreeNode<T> root, StringBuilder stringBuilder) {
    if (root != null) {
      printInOrderRecursive(root.getLeft(), stringBuilder);
      stringBuilder.append(root.getKey()).append(" ");
      printInOrderRecursive(root.getRight(), stringBuilder);
    }
  }

}
