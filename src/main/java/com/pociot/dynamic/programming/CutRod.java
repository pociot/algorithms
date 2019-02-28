package com.pociot.dynamic.programming;

import static java.lang.Integer.MIN_VALUE;

public class CutRod {

  private CutRod() {
  }

  public static int recursiveCutRod(int[] p, int n) {
    if (n == 0) {
      return 0;
    }
    int q = MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      q = Math.max(q, p[i] + recursiveCutRod(p, n - i));
    }
    return q;
  }

  public static int memorizedCutRod(int[] p, int n) {
    int[] r = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      r[i] = MIN_VALUE;
    }
    return memorizedCutRodAux(p, n, r);
  }

  private static int memorizedCutRodAux(int[] p, int n, int[] r) {
    if (r[n] >= 0) {
      return r[n];
    }
    int q;
    if (n == 0) {
      q = 0;
    } else {
      q = MIN_VALUE;
      for (int i = 1; i <= n; i++) {
        q = Math.max(q, p[i] + memorizedCutRodAux(p, n - i, r));
      }
    }
    r[n] = q;
    return q;
  }

  public static int bottomUpCutRod(int[] p, int n) {
    int[] r = new int[n + 1];
    r[0] = 0;
    for (int j = 1; j <= n; j++) {
      int q = MIN_VALUE;
      for (int i = 1; i <= j; i++) {
        q = Math.max(q, p[i] + r[j - i]);
      }
      r[j] = q;
    }
    return r[n];
  }

  private static int[][] extendedBottomUpCutRod(int[] p, int n) {
    int[][] rs = new int[2][n + 1];
    rs[0][0] = 0;
    for (int j = 1; j <= n; j++) {
      int q = MIN_VALUE;
      for (int i = 1; i <= j; i++) {
        if (q < p[i] + rs[0][j - i]) {
          q = p[i] + rs[0][j - i];
          rs[1][j] = i;
        }
      }
      rs[0][j] = q;
    }
    return rs;
  }

  public static String printCutRodSolution(int[] p, int n) {
    int[][] rs = extendedBottomUpCutRod(p, n);
    StringBuilder stringBuilder = new StringBuilder();
    while (n > 0) {
      stringBuilder.append(rs[1][n]).append(" ");
      n = n - rs[1][n];
    }
    return stringBuilder.toString();
  }

}
