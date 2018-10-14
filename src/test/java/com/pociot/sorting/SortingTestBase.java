package com.pociot.sorting;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class SortingTestBase {

  private static final Logger logger = LogManager.getLogger(SortingAlgorithmTest.class);

  private List<Integer> unsortedList = null;

  private Integer[] table;
  private Integer[] sortedTable = null;

  void sortTest(SortingAlgorithm algorithm) {
    logger.info("{} started", algorithm.getClass().getSimpleName());
    long startDate = System.currentTimeMillis();
    assertArrayEquals(sortedTable, algorithm.sort(table));
    logger.info("Sorting took {} ms", System.currentTimeMillis() - startDate);
  }

  void setUp(String unsortedFilePath, String sortedFilePath) {
    initializeUnsortedList(unsortedFilePath);
    assertNotNull(unsortedList);
    initializeSortedArray(sortedFilePath);
    assertNotNull(sortedTable);
    initializeUnsortedArray();
    assertNotNull(table);
  }

  private void initializeUnsortedList(String filePath) {
    if (unsortedList == null) {
      unsortedList = readFileToIntegerList(filePath);
    }
  }

  private void initializeSortedArray(String filePath) {
    if (sortedTable == null) {
      sortedTable = readFileToIntegerList(filePath).toArray(new Integer[0]);
    }
  }

  private void initializeUnsortedArray() {
    if (unsortedList != null) {
      table = unsortedList.toArray(new Integer[0]);
    }
  }

  private List<Integer> readFileToIntegerList(String filePath) {
    String absoluteFilePath = Objects
        .requireNonNull(getClass().getClassLoader().getResource(filePath))
        .getPath();
    Path path = Paths.get(absoluteFilePath);
    try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
      return lines.map(Integer::valueOf).collect(toList());
    } catch (IOException e) {
      logger.error("Error while reading file {}", filePath, e);
    }
    return new ArrayList<>();
  }
}
