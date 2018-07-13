package com.pociot.structures;

public class CustomLinkedList<T> {

  private Link<T> first;

  public CustomLinkedList() {
    this.first = null;
  }

  public void insert(T object) {
    Link<T> link = new Link<>(object);
    link.next = first;
    first = link;
  }

  public Link<T> delete() {
    Link<T> temp = first;
    if(first == null){
      return null;
    }
    first = first.next;
    return temp;
  }

  public T first() {
    if(first != null)
      return first.data;
    return null;
  }

  protected static class Link<T> {
    private T data;
    private Link<T> next;

    public Link(T data) {
      this.data = data;
    }

  }
}
