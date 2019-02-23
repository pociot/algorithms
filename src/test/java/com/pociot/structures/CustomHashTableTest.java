package com.pociot.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CustomHashTableTest {

  @Test
  void shouldCreateHashTableWithoutErrors() {
    CustomHashTable<String, String> hashTable = new CustomHashTable<>();
    for (int i = 0; i < 75; i++) {
      hashTable.put("key-" + i, "value-" + i);
    }
    assertEquals(hashTable.get("key-2"), "value-2");
    assertEquals(hashTable.get("key-59"), "value-59");
    assertEquals(hashTable.get("key-34"), "value-34");
    assertEquals(hashTable.get("key-23"), "value-23");
  }

  @Test
  void shouldReturnNullIfKeyNotPresent() {
    CustomHashTable<String, String> hashTable = new CustomHashTable<>();
    hashTable.put("some-key", "some-value");
    assertNull(hashTable.get("other-key"));
  }

}
