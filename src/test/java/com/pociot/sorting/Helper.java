package com.pociot.sorting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import org.apache.logging.log4j.LogManager;

public class Helper {
  public static void main(String[] args) {
    try {
      generateTestData();
    } catch (IOException e) {
      LogManager.getLogger(Helper.class).error("Error while generating integers sets.");
    }
  }

  private static void generateTestData() throws IOException {
    Random random = new Random();
    int[] array = new int[100000];
    FileOutputStream fileOutputStream = new FileOutputStream("integers.txt");
    for (int i = 0; i < 100000; i++) {
      array[i] = random.nextInt(100000);
      fileOutputStream.write(String.valueOf(array[i] + "\n").getBytes());
    }
    fileOutputStream.close();

    Arrays.sort(array);
    fileOutputStream = new FileOutputStream("integers_sorted.txt");
    for (int i = 0; i < 100000; i++) {
      fileOutputStream.write(String.valueOf(array[i] + "\n").getBytes());
    }
    fileOutputStream.close();

  }
}
