package xyz.stupidwolf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets_II_90 {
    @Test
    public void test() {
        int[] nums = new int[] {1, 2, 2};
        List<List<Integer>> list = subsetsWithDup(nums);
        System.out.println(list);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        backTrace(list, new ArrayList<Integer>(), 0, nums);
        return list;
    }

    private void backTrace(List<List<Integer>> list, List<Integer> template, int start, int[] nums) {
        list.add(new ArrayList<Integer>(template));

        for (int i = start; i < nums.length; i ++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            template.add(nums[i]);
            backTrace(list, template, i + 1, nums);
            template.remove(template.size() - 1);
        }
    }
}
