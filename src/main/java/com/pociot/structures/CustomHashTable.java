package com.pociot.structures;

public class CustomHashTable<K, V> {

  private Node<K, V>[] table;
  private int size = 0;
  private int threshold = 15;

  public CustomHashTable() {
    resize();
  }

  public void put(K key, V value) {
    putVal(hash(key), key, value);
  }

  public V get(K key) {
    Node<K, V> node;
    return (node = getNode(hash(key), key)) == null ? null : node.getValue();
  }

  int hash(Object key) {
    if (key == null) {
      return 0;
    }
    int hashCode = key.hashCode();
    return hashCode ^ (hashCode >>> 16);
  }

  private void putVal(int hash, K key, V value) {
    Node<K, V> existing;
    Node<K, V> newNode = new Node<>(hash, key, value, null);
    if ((existing = table[(table.length - 1) & hash]) == null) {
      table[(table.length - 1) & hash] = newNode;
    } else {
      while (existing.next != null) {
        existing = existing.next;
      }
      existing.next = newNode;
    }
    size++;
    checkMapSize();
  }

  private Node<K, V> getNode(int hash, K key) {
    Node<K, V> firstNode = table[(table.length - 1) & hash];
    if (firstNode != null) {
      if (firstNode.getKey().equals(key)) {
        return firstNode;
      }
      do {
        if (firstNode.hash == hash && firstNode.getKey().equals(key)) {
          return firstNode;
        }
      } while ((firstNode = firstNode.next) != null);
    }
    return null;
  }

  private void checkMapSize() {
    if (size >= threshold) {
      resize();
      threshold = table.length - 1;
    }
  }

  private void resize() {
    Node<K, V>[] oldTab = table;

    int oldCapacity = table == null ? 0 : table.length;
    int newLength = oldCapacity == 0 ? 16 : table.length * 2;

    @SuppressWarnings({"rawtypes", "unchecked"})
    Node<K, V>[] newTab = (Node<K, V>[]) new Node[newLength];
    table = newTab;

    recreateTable(oldTab, oldCapacity, newTab);
  }

  private void recreateTable(Node<K, V>[] oldTab, int oldCapacity, Node<K, V>[] newTab) {
    if (oldTab != null) {
      for (int i = 0; i < oldCapacity; i++) {
        Node<K, V> oldNode;
        if ((oldNode = oldTab[i]) != null) {
          copyNode(oldCapacity, newTab, i, oldNode);
        }
      }
    }
  }

  private void copyNode(int oldCapacity, Node<K, V>[] newTab, int i, Node<K, V> oldNode) {
    if (oldNode.next == null) {
      table[(table.length - 1) & oldNode.hash] = oldNode;
    } else {
      balanceTable(oldCapacity, newTab, i, oldNode);
    }
  }

  private void balanceTable(int oldCapacity, Node<K, V>[] newTab, int i, Node<K, V> oldNode) {
    Node<K, V> lowHead = null;
    Node<K, V> lowTail = null;
    Node<K, V> highHead = null;
    Node<K, V> highTail = null;
    Node<K, V> next;
    do {
      next = oldNode.next;
      if ((oldNode.hash & oldCapacity) == 0) {
        if (lowTail == null) {
          lowHead = oldNode;
        } else {
          lowTail.next = oldNode;
        }
        lowTail = oldNode;
      } else {
        if (highTail == null) {
          highHead = oldNode;
        } else {
          highTail.next = oldNode;
        }
        highTail = oldNode;
      }
    } while ((oldNode = next) != null);
    setNode(newTab, i, lowHead, lowTail);
    setNode(newTab, i + oldCapacity, highHead, highTail);
  }

  private void setNode(Node<K, V>[] newTab, int i, Node<K, V> lowHead, Node<K, V> lowTail) {
    if (lowTail != null) {
      lowTail.next = null;
      newTab[i] = lowHead;
    }
  }

  static class Node<K, V> {

    final int hash;
    final K key;
    V value;
    Node<K, V> next;

    Node(int hash, K key, V value, Node<K, V> next) {
      this.hash = hash;
      this.key = key;
      this.value = value;
      this.next = next;
    }

    final K getKey() {
      return key;
    }

    final V getValue() {
      return value;
    }
  }
}
