package com.pociot.structures;

import org.junit.Assert;
import org.junit.Test;

public class CustomLinkedListTest {

  @Test
  public void testLinkedList() {
    CustomLinkedList<Integer> list = new CustomLinkedList<>();

    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    list.insert(5);

    Assert.assertEquals((Integer)5, list.first());
    list.delete();
    Assert.assertEquals((Integer)4, list.first());
    list.delete();
    Assert.assertEquals((Integer)3, list.first());
    list.delete();
    Assert.assertEquals((Integer)2, list.first());
    list.delete();
    Assert.assertEquals((Integer)1, list.first());
    list.delete();
    Assert.assertNull(list.first());
  }

}
