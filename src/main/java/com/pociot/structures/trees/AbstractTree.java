package com.pociot.structures.trees;

public abstract class AbstractTree<K extends Comparable<? super K>, V> implements Tree<K, V> {

  private TreeNode<K, V> root;

  protected TreeNode<K, V> getRoot() {
    return this.root;
  }

  protected void setRoot(TreeNode<K, V> root) {
    this.root = root;
  }

  protected TreeNode<K, V> treeMinimum(TreeNode<K, V> x) {
    while (x.getLeft() != null && x.getLeft().getKey() != null) {
      x = x.getLeft();
    }
    return x;
  }

  private void inOrderTreeWalk(TreeNode<K, V> x, StringBuilder stringBuilder, boolean printValue) {
    if (x != null && x.getKey() != null) {
      inOrderTreeWalk(x.getLeft(), stringBuilder, printValue);
      appendNode(x, stringBuilder, printValue);
      inOrderTreeWalk(x.getRight(), stringBuilder, printValue);
    }
  }

  private void appendNode(TreeNode<K, V> x, StringBuilder stringBuilder, boolean printValue) {
    stringBuilder.append(x.getKey());
    if (printValue) {
      stringBuilder.append(":").append(x.getValue());
    }
    stringBuilder.append(" ");
  }

  @Override
  public String printInOrder() {
    return printInOrder(false);
  }

  @Override
  public String printInOrder(boolean printValue) {
    StringBuilder stringBuilder = new StringBuilder();
    inOrderTreeWalk(getRoot(), stringBuilder, printValue);
    return stringBuilder.toString();
  }

  private TreeNode<K, V> iterativeTreeSearch(TreeNode<K, V> x, K k) {
    while (x != null && k.compareTo(x.getKey()) != 0) {
      if (k.compareTo(x.getKey()) < 0) {
        x = x.getLeft();
      } else {
        x = x.getRight();
      }
    }
    return x;
  }

  protected TreeNode<K, V> searchNode(K key) {
    return iterativeTreeSearch(this.root, key);
  }

  public static class SimpleTreeNode<K, V> implements TreeNode<K, V> {

    private final K key;
    private V value;
    private TreeNode<K, V> parent;
    private TreeNode<K, V> left;
    private TreeNode<K, V> right;

    public SimpleTreeNode(K key, V value, TreeNode<K, V> parent,
        TreeNode<K, V> left, TreeNode<K, V> right) {
      this.key = key;
      this.value = value;
      this.parent = parent;
      this.left = left;
      this.right = right;
    }

    @Override
    public K getKey() {
      return key;
    }

    @Override
    public V getValue() {
      return value;
    }

    @Override
    public void setValue(V value) {
      this.value = value;
    }

    @Override
    public TreeNode<K, V> getParent() {
      return parent;
    }

    @Override
    public void setParent(TreeNode<K, V> parent) {
      this.parent = parent;
    }

    @Override
    public TreeNode<K, V> getLeft() {
      return left;
    }

    @Override
    public void setLeft(TreeNode<K, V> left) {
      this.left = left;
    }

    @Override
    public TreeNode<K, V> getRight() {
      return right;
    }

    @Override
    public void setRight(TreeNode<K, V> right) {
      this.right = right;
    }
  }
}
