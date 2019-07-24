package xyz.stupidwolf;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p>create at <code>2019-06-13</code></p>
 *
 * @author chenmingli
 */
public class CombinationSum_39 {

    @Test
    public void test1() {
//        int[] candidates = new int[] {2,3,6,7};
        int[] candidates = new int[] {2,3,5};
//        int[] candidates = new int[] {7,3};
//        int target = 7;
        int target = 8;
//        int target = 17;
        System.out.println(combinationSum(candidates, target));
        System.out.println(combinationSum2(candidates, target));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rs = new LinkedList<>();
        Arrays.sort(candidates);
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int total;
        for (int i = 0, length = candidates.length; i < length; i ++) {
            int j = i;
            total = 0;
            while (true) {
                total += candidates[j];
//                System.out.println(stack + " + " + candidates[j] + " : " + total);
                if (total < target) {
                    stack.push(candidates[j]);
                    indexStack.push(j);
                } else if (total == target) {
                    List<Integer> row = new LinkedList<>(stack);
                    row.add(candidates[j]);
                    rs.add(row);
                    total -= candidates[j];
                    if (!stack.isEmpty()) {
                        total -= stack.pop();
                        j = indexStack.pop() + 1;
                    }
                } else if (!stack.isEmpty()) {
                    total -= candidates[j];
                    total -= stack.pop();
                    j = indexStack.pop() + 1;
                }


                if (stack.isEmpty()) {
                    break;
               } else if (j >= length) {
                    while (!stack.isEmpty() && j >= length) {
                        total -= stack.pop();
                        j = indexStack.pop() + 1;
                    }
                    if (j >= length || stack.isEmpty()) {
                        break;
                    }
                }
           }
        }
        return rs;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        backTrace(res, new LinkedList<Integer>(), candidates, 0, target);
        return res;
    }

    private void backTrace(List<List<Integer>> res, LinkedList<Integer> curRow, int[] candidates, int startIndex, int target) {
        if (target == 0) {
            res.add(new LinkedList<>(curRow));
        } else if (target > 0) {
            for (int i = startIndex; i < candidates.length && target >= candidates[i]; i ++) {
                curRow.addLast(candidates[i]);
                backTrace(res, curRow, candidates, i, target - candidates[i]);
//                System.out.println("before:" + curRow);
                curRow.removeLast();
//                System.out.println("after:" + curRow);
            }
        }
    }


    @Test
    public void test2() {
        System.out.println("\r\n");
    }
}
