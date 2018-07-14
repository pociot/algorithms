package com.pociot.structures;

import org.junit.Assert;
import org.junit.Test;

public class CustomLinkedListTest {

  @Test
  public void testLinkedList() {
    CustomLinkedList<Integer> list = new CustomLinkedList<>();

    list.push(1);
    list.push(2);
    list.push(3);
    list.push(4);
    list.insertAfter(list.getHead().getNext(), 10);
    list.push(5);
    list.append(9);
    list.append(8);
    list.append(7);

    Assert.assertEquals((Integer)5, list.getHead().getValue());
    Assert.assertEquals((Integer)5, list.delete().getValue());

    Assert.assertEquals((Integer)4, list.getHead().getValue());
    Assert.assertEquals((Integer)4, list.delete().getValue());

    Assert.assertEquals((Integer)3, list.getHead().getValue());
    Assert.assertEquals((Integer)3, list.delete().getValue());

    Assert.assertEquals((Integer)10, list.getHead().getValue());
    Assert.assertEquals((Integer)10, list.delete().getValue());

    Assert.assertEquals((Integer)2, list.getHead().getValue());
    Assert.assertEquals((Integer)2, list.delete().getValue());

    Assert.assertEquals((Integer)1, list.getHead().getValue());
    Assert.assertEquals((Integer)1, list.delete().getValue());

    Assert.assertEquals((Integer)9, list.getHead().getValue());
    Assert.assertEquals((Integer)9, list.delete().getValue());

    Assert.assertEquals((Integer)8, list.getHead().getValue());
    Assert.assertEquals((Integer)8, list.delete().getValue());

    Assert.assertEquals((Integer)7, list.getHead().getValue());
    Assert.assertEquals((Integer)7, list.delete().getValue());

    Assert.assertNull(list.delete());
    Assert.assertNull(list.getHead());
  }

}
