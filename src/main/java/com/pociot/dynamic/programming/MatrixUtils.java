package com.pociot.dynamic.programming;

import com.pociot.structures.Matrix;

public class MatrixUtils {

  private MatrixUtils() {
  }

  public static Matrix matrixMultiply(Matrix a, Matrix b) {
    if (a.columns != b.rows) {
      throw new IllegalArgumentException(
          "Number of columns in matrix A has to match number of rows in matrix B.");
    }
    Matrix c = new Matrix(a.rows, b.columns);
    for (int i = 0; i < a.rows; i++) {
      for (int j = 0; j < b.columns; j++) {
        c.set(i, j, 0);
        for (int k = 0; k < a.columns; k++) {
          c.set(i, j, c.get(i, j) + (a.get(i, k) * b.get(k, j)));
        }
      }
    }
    return c;
  }

}
