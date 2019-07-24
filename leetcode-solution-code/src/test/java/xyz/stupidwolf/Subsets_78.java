package xyz.stupidwolf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
    @Test
    public void test() {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrace(result, new ArrayList<Integer>(), 0, nums);
        return result;
    }

    private void backtrace(List<List<Integer>> list, List<Integer> template, int start, int[] nums) {
        list.add(new ArrayList<Integer>(template));
        for (int i = start; i < nums.length; i ++) {
            template.add(nums[i]);
            backtrace(list, template, i + 1, nums);
            template.remove(template.size() - 1);
        }
    }
}
