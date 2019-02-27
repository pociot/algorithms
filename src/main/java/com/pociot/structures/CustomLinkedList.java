package com.pociot.structures;


import org.jetbrains.annotations.Nullable;

public class CustomLinkedList<T> {

  private Link<T> head;

  public CustomLinkedList() {
    this.head = null;
  }

  public void push(T object) {
    var link = new Link<>(object);
    link.setNext(head);
    head = link;
  }

  public void append(T object) {
    var link = new Link<>(object);
    if (head == null) {
      head = link;
    } else {
      var last = head;
      while (last.getNext() != null)
        last = last.getNext();
      last.setNext(link);
    }
  }

  public void insertAfter(Link<T> previousNode, T object) {
    if (previousNode == null) {
      throw new IllegalArgumentException("Previous node cannot be null");
    }
    var link = new Link<>(object);
    link.setNext(previousNode.next);
    previousNode.setNext(link);
  }

  public Link<T> delete() {
    var temp = head;
    if(head == null){
      return null;
    }
    head = head.getNext();
    return temp;
  }

  public Link<T> search(T key) {
    var temp = head;
    while (temp != null && !temp.getValue().equals(key)) {
      temp = temp.getNext();
    }
    return temp;
  }

  public @Nullable Link<T> getHead() {
    return head;
  }

  protected static class Link<T> {
    private T data;
    private Link<T> next;

    public Link(T data) {
      this.data = data;
      this.next = null;
    }

    public @Nullable Link<T> getNext() {
      return next;
    }

    private void setNext(Link<T> next) {
      this.next = next;
    }

    public T getValue() {
      return data;
    }

  }
}
