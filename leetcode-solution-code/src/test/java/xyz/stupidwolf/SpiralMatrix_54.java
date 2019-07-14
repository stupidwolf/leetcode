package xyz.stupidwolf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>create at <code>2019-06-19</code></p>
 *
 * @author chenmingli
 */
public class SpiralMatrix_54 {

    @Test
    public void test() {
        int[][] matrix = new int[][] {
                { 1, 2, 3 },{ 4, 5, 6 },{ 7, 8, 9 }
        };

        System.out.println(spiralOrder(matrix));

        matrix = new int[][] {
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}
        };

        System.out.println(spiralOrder(matrix));

        matrix = new int[][] {
                {1, 2, 3, 4}
        };

        System.out.println(spiralOrder(matrix));

        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[i].length; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length <= 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>(matrix.length);

        int total = matrix.length * matrix[0].length;
        int index = 0;
        int i = 0;
        int j = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (index < total) {
            while (index < total && j <= right) {
                list.add(matrix[i][j]);
                j++;
                index ++;
            }
            i ++;
            top ++;
            j = right;

            while (index < total && i <= bottom) {
                list.add(matrix[i][j]);
                i ++;
                index ++;
            }
            right --;
            j --;
            i = bottom;

            while (index < total && j >=left ) {
                list.add(matrix[i][j]);
                j --;
                index ++;
            }
            i --;
            bottom --;
            j = left;

            while (index < total && i >= top) {
                list.add(matrix[i][j]);
                i --;
                index ++;
            }
            j ++;
            left ++;
            i = top;
        }

        return list;
    }
}
