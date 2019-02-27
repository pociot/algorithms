package com.pociot.structures.trees.bts;

import com.pociot.structures.trees.AbstractTree;

public class BinarySearchTree<K extends Comparable<? super K>, V> extends AbstractTree<K, V> {


  public BinarySearchTree() {
    setRoot(null);
  }

  @Override
  public void insert(K key, V value) {
    treeInsert(new SimpleTreeNode<K, V>(key, value, null, null, null));
  }

  @Override
  public void delete(K key) {
    TreeNode<K, V> node = searchNode(key);
    if (node != null) {
      treeDelete(node);
    }
  }

  @Override
  public V search(K key) {
    TreeNode<K, V> node;
    return (node = searchNode(key)) == null ? null : node.getValue();
  }

  @Override
  protected SimpleTreeNode<K, V> getRoot() {
    return (SimpleTreeNode<K, V>) super.getRoot();
  }

  private void treeInsert(TreeNode<K, V> z) {
    TreeNode<K, V> y = null;
    TreeNode<K, V> x = getRoot();
    while (x != null) {
      y = x;
      if (z.getKey().compareTo(x.getKey()) < 0) {
        x = x.getLeft();
      } else {
        x = x.getRight();
      }
    }
    z.setParent(y);
    if (y == null) {
      setRoot(z);
    } else if (z.getKey().compareTo(y.getKey()) < 0) {
      y.setLeft(z);
    } else {
      y.setRight(z);
    }
  }

  private void transplant(TreeNode<K, V> u, TreeNode<K, V> v) {
    if (u.getParent() == null) {
      setRoot(v);
    } else if (u == u.getParent().getLeft()) {
      u.getParent().setLeft(v);
    } else {
      u.getParent().setRight(v);
    }
    if (v != null) {
      v.setParent(u.getParent());
    }
  }

  private void treeDelete(TreeNode<K, V> z) {
    if (z.getLeft() == null) {
      transplant(z, z.getRight());
    } else if (z.getRight() == null) {
      transplant(z, z.getLeft());
    } else {
      TreeNode<K, V> y = treeMinimum(z.getRight());
      if (y.getParent() != z) {
        transplant(y, y.getRight());
        y.setRight(z.getRight());
        y.getRight().setParent(y);
      }
      transplant(z, y);
      y.setLeft(z.getLeft());
      y.getLeft().setParent(y);
    }
  }
}
