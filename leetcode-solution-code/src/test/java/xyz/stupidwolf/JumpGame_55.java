package xyz.stupidwolf;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <p>create at <code>2019-06-19</code></p>
 *
 * @author chenmingli
 */
public class JumpGame_55 {

    @Test
    public void test() {
        int[] nums = new int[] {2,3,1,1,4};
        System.out.println(canJump(nums));
        System.out.println(canJump2(nums));
        System.out.println(canJump3(nums));

        nums = new int[] {3,2,1,0,4};
        System.out.println(canJump(nums));
        System.out.println(canJump2(nums));
        System.out.println(canJump3(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 0) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> handledSet = new HashSet<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (i + nums[i] >= nums.length - 1) {
                return true;
            } else {
                for (int j = i + 1, end = i + nums[i]; j <= end; j ++) {
                    if (!handledSet.contains(j) && (nums[j] + j > i + nums[i])) {
                        queue.add(j);
                        handledSet.add(j);
                    }
                }
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        if (nums.length <= 0) {
            return true;
        }
        int i = 0;
        while (true) {
            if (nums[i] + i >= nums.length - 1) {
                return true;
            } else {
                int maxIndex = i;
                int maxStep = nums[i] + i;
                for (int j = i + 1, end = nums[i] + i; j <= end; j ++) {
                    int temp = nums[j] + j;
                    if (temp >= maxStep) {
                        maxIndex = j;
                        maxStep = temp;
                    }
                }
                if (maxIndex <= i) {
                    break;
                } else {
                    i = maxIndex;
                }
            }
        }
        return false;
    }

    public boolean canJump3(int[] nums) {
        if (nums.length <= 0) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return max >= (nums.length - 1);
    }
}
