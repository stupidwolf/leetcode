package xyz.stupidwolf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>create at <code>2019-06-14</code></p>
 *
 * @author chenmingli
 */
public class Combinations_77 {

    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        backTrace(res, 1, n - k + 1, new ArrayList<>(k), k);
        return res;
    }

    private void backTrace(List<List<Integer>> res, int start, int end, List<Integer> row, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(row));
        } else {
            for (int i = start; i <= end; i ++) {
                row.add(i);
                backTrace(res, i + 1, end + 1, row, k - 1);
                row.remove(row.size() - 1);
            }
        }
    }
}
