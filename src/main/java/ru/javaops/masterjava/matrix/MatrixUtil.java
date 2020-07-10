package ru.javaops.masterjava.matrix;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;

import static ru.javaops.masterjava.matrix.MainMatrix.MATRIX_SIZE;

/**
 * gkislin
 * 03.07.2016
 */
public class MatrixUtil {

    final static int MATRIX_PART = MATRIX_SIZE / MainMatrix.THREAD_NUMBER;

    static final int[][] matrixC = new int[MATRIX_SIZE][MATRIX_SIZE];

    // TODO implement parallel multiplication matrixA*matrixB
    public static int[][] concurrentMultiply(int[][] matrixA, int[][] matrixB, ExecutorService executor) throws InterruptedException, ExecutionException {
        /*System.out.println("Matrix A" + Arrays.deepToString(matrixA));
        System.out.println("Matrix B" + Arrays.deepToString(matrixB));

        for (int j = 0; j < MATRIX_SIZE; j++) {
            if (j == 0 || (j > 0 && j % MATRIX_PART == 0)) {
                int finalJ = j;
                executor.submit(new Runnable() {
                    @Override
                    public void run() {
                        int[][] partMatrixA = copyPartMatrix(finalJ, MATRIX_SIZE, matrixA);
                        int[][] partMatrixB = copyPartMatrix(MATRIX_SIZE, finalJ, matrixB);
                        System.out.println(finalJ);
                        multiplyPartMatrices(partMatrixA, partMatrixB, matrixC, finalJ, finalJ);
                        System.out.println("Concurrent matrix at run: " + Arrays.deepToString(matrixC));
                    }
                });
            }
        }
        executor.shutdown();
        return matrixC;*/

        final int matrixSize = matrixA.length;
        final int[][] matrixC = new int[matrixSize][matrixSize];

        class ColumnMultipleResult {
            private final int col;
            private final int[] columnC;

            private ColumnMultipleResult(int col, int[] columnC) {
                this.col = col;
                this.columnC = columnC;
            }
        }

        final CompletionService<ColumnMultipleResult> completionService = new ExecutorCompletionService<>(executor);

        for (int j = 0; j < matrixSize; j++) {
            final int col = j;
            final int[] columnB = new int[matrixSize];
            for (int k = 0; k < matrixSize; k++) {
                columnB[k] = matrixB[k][col];
            }
            completionService.submit(() -> {
                final int[] columnC = new int[matrixSize];

                for (int row = 0; row < matrixSize; row++) {
                    final int[] rowA = matrixA[row];
                    int sum = 0;
                    for (int k = 0; k < matrixSize; k++) {
                        sum += rowA[k] * columnB[k];
                    }
                    columnC[row] = sum;
                }
                return new ColumnMultipleResult(col, columnC);
            });
        }

        for (int i = 0; i < matrixSize; i++) {
            ColumnMultipleResult res = completionService.take().get();
            for (int k = 0; k < matrixSize; k++) {
                matrixC[k][res.col] = res.columnC[k];
            }
        }
        return matrixC;
    }

    // TODO optimize by https://habrahabr.ru/post/114797/
    public static int[][] singleThreadMultiply(int[][] matrixA, int[][] matrixB) {
        final int matrixSize = matrixA.length;
        final int[][] matrixC = new int[matrixSize][matrixSize];

        int thatColumn[] = new int[matrixSize];

        for (int j = 0; j < matrixSize; j++) {
            for (int k = 0; k < matrixSize; k++) {
                thatColumn[k] = matrixB[k][j];
            }
            for (int i = 0; i < matrixSize; i++) {
                int thisRow[] = matrixA[i];
                int summ = 0;
                for (int k = 0; k < matrixSize; k++) {
                    summ += thisRow[k] * thatColumn[k];
                }
                matrixC[i][j] = summ;
            }
        }
        return matrixC;
    }

    /*private static void multiplyPartMatrices(int[][] matrixA, int[][] matrixB, int[][] matrixC, int startRow, int startCol) {
        final int aColsLength = matrixA[0].length;
        final int aRowsLength = matrixA.length;
        final int bColsLength = matrixB[0].length;
        final int bRowsLength = matrixB.length;

        int thatColumn[] = new int[bRowsLength];

        for (int j = 0, jj = startCol; j < bColsLength; j++, jj++) {
            for (int k = 0; k < bColsLength; k++) {
                thatColumn[k] = matrixB[k][j];
            }
            for (int i = 0, ii = startRow; i < bRowsLength; i++, ii++) {
                int thisRow[] = matrixA[i];
                int summ = 0;
                for (int k = 0; k < aColsLength; k++) {
                    summ += thisRow[k] * thatColumn[k];
                }
                matrixC[ii][jj] = summ;
            }
        }
    }*/

    public static int[][] create(int size) {
        int[][] matrix = new int[size][size];
        Random rn = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rn.nextInt(10);
            }
        }
        return matrix;
    }

    public static boolean compare(int[][] matrixA, int[][] matrixB) {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /*private static int[][] copyPartMatrix(int rowNum, int colNum, int[][] sourceMatrix) {
        int maxColNum, maxRowNum, minRowNum, minColNum;
        int[][] partMatrix;
        if (rowNum == sourceMatrix.length) {
            maxRowNum = MATRIX_SIZE;
            minRowNum = 0;
            maxColNum = colNum + MATRIX_PART;
            minColNum = colNum;
            partMatrix = new int[maxRowNum][MATRIX_PART];
        } else {
            maxRowNum = rowNum + MATRIX_PART;
            minRowNum = rowNum;
            maxColNum = MATRIX_SIZE;
            minColNum = 0;
            partMatrix = new int[MATRIX_PART][maxColNum];
        }
        for (int i = minRowNum, ii = 0; i < maxRowNum; i++, ii++) {
            for (int j = minColNum, jj = 0; j < maxColNum; j++, jj++) {
                partMatrix[ii][jj] = sourceMatrix[i][j];
            }
        }
        System.out.println("part matrix: " + Arrays.deepToString(partMatrix));
        return partMatrix;
    }*/
}
