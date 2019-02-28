package com.pociot.dynamic.programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pociot.structures.Matrix;
import org.junit.jupiter.api.Test;

public class MatrixUtilsTest {

  @Test
  void matrixMultiplyTest() {
    Matrix a = new Matrix(3, 2);
    Matrix b = new Matrix(2, 3);

    for (int i = 0; i < a.rows; i++) {
      for (int j = 0; j < a.columns; j++) {
        a.set(i, j, i + j);
      }
    }
    for (int i = 0; i < b.rows; i++) {
      for (int j = 0; j < b.columns; j++) {
        b.set(i, j, i + j);
      }
    }

    Matrix c = MatrixUtils.matrixMultiply(a, b);

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < c.rows; i++) {
      for (int j = 0; j < c.columns; j++) {
        stringBuilder.append(c.get(i, j)).append(" ");
      }
      stringBuilder.append("\n");
    }

    assertEquals(
        "1 2 3 \n"
            + "2 5 8 \n"
            + "3 8 13 \n",
        stringBuilder.toString()
    );
  }
}
