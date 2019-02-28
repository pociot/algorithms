package com.pociot.structures;

public class Matrix {

  public final int columns;
  public final int rows;

  private final int[][] matrixTable;

  public Matrix(int rows, int columns) {
    this.columns = columns;
    this.rows = rows;
    this.matrixTable = new int[rows][columns];
  }

  public void set(int x, int y, int value) {
    this.matrixTable[x][y] = value;
  }

  public int get(int x, int y) {
    return this.matrixTable[x][y];
  }
}
