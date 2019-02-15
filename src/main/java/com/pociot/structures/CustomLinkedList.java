package com.pociot.structures;


import org.jetbrains.annotations.Nullable;

public class CustomLinkedList<T> {

  private Link<T> head;

  public CustomLinkedList() {
    this.head = null;
  }

  public void push(T object) {
    Link<T> link = new Link<>(object);
    link.setNext(head);
    head = link;
  }

  public void append(T object) {
    Link<T> link = new Link<>(object);
    if (head == null) {
      head = link;
    } else {
      Link<T> last = head;
      while (last.getNext() != null)
        last = last.getNext();
      last.setNext(link);
    }
  }

  public void insertAfter(Link<T> previousNode, T object) {
    if (previousNode == null) {
      throw new IllegalArgumentException("Previous node cannot be null");
    }
    Link<T> link = new Link<>(object);
    link.setNext(previousNode.next);
    previousNode.setNext(link);
  }

  public Link<T> delete() {
    Link<T> temp = head;
    if(head == null){
      return null;
    }
    head = head.getNext();
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
