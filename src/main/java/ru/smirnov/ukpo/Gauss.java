package ru.smirnov.ukpo;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.abs;

public class Gauss {
    String countTheMatrix(Double[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            int max = i;

            for (int k = i + 1; k < matrix.length; ++k) {
                if (abs(matrix[max][i]) < abs(matrix[k][i])) max = k;
            }

            swap(matrix, i, max);

            for (int k = i + 1; k <= matrix.length; ++k) {
                matrix[i][k] /= matrix[i][i];
            }

            for (int k = 0; k < matrix.length; ++k) {
                if (k != i) {
                    for (int q = i + 1; q <= matrix.length; ++q) matrix[k][q] -= (matrix[k][i] * matrix[i][q]);
                }
            }
        }

        StringBuilder vec = new StringBuilder();

        for (Double[] doubles : matrix) {
            vec.append(round(doubles[matrix.length])).append(" ");
        }

        return vec.toString();
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static double round(double value) {
        if (!Double.isInfinite(value) && !Double.isNaN(value)) {
            BigDecimal bd = BigDecimal.valueOf(value);
            bd = bd.setScale(3, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }
        return value;
    }
}