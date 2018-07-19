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

  public void delete(T key) {
    root = deleteRecursive(root, key);
  }

  private TreeNode<T> deleteRecursive(TreeNode<T> root, T key) {
    if (root == null)
      return null;

    if (key.compareTo(root.getKey()) < 0)
      root.setLeft(deleteRecursive(root.getLeft(), key));
    else if (key.compareTo(root.getKey()) > 0)
      root.setRight(deleteRecursive(root.getRight(), key));
    else {
      if (root.getLeft() == null)
        return root.getRight();
      else if (root.getRight() == null)
        return root.getLeft();

      root.setKey(minValue(root.getRight()));

      root.setRight(deleteRecursive(root.getRight(), root.getKey()));
    }
    return root;
  }

  private T minValue(TreeNode<T> root)
  {
    T minv = root.getKey();
    while (root.getLeft() != null)
    {
      minv = root.getLeft().getKey();
      root = root.getLeft();
    }
    return minv;
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
