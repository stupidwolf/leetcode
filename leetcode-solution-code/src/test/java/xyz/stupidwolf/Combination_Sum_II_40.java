package xyz.stupidwolf;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>create at <code>2019-06-14</code></p>
 *
 * @author chenmingli
 */
public class Combination_Sum_II_40 {

    @Test
    public void test() {
//        int[] candidates = new int[] {10,1,2,7,6,1,5};
        int[] candidates = new int[] {2,5,2,1,2};
//        int target = 8;
        int target = 5;
        System.out.println(combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        backTrace(res, new LinkedList<>(), candidates, 0, target);
        return res;
    }

    private void backTrace(List<List<Integer>> res, LinkedList<Integer> curRow, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new LinkedList<>(curRow));
        } else if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i ++) {
                if (i > start
                        && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                curRow.addLast(candidates[i]);
                backTrace(res, curRow, candidates, i + 1, target - candidates[i]);
                curRow.removeLast();
            }
        }
    }
}
