package xyz.stupidwolf;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p>create at <code>2019-06-17</code></p>
 *
 * @author chenmingli
 */
public class FirstMissingPositive_41 {

    @Test
    public void test() {
        int[] nums = new int[] {1,2,0};
//        System.out.println(firstMissingPositive(nums));

        nums = new int[]{3,4,-1,1};
//        System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositive2(nums));

        nums = new int[]{0, 1, 2};
//        System.out.println(firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] <= 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i ++) {
            int idx = Math.abs(nums[i]);
            if (idx > 0 && idx <= nums.length) {
                if (nums[idx - 1] > 0) {
                    nums[idx - 1] *= -1;
                } else {
                    nums[idx - 1] = -1;
                }
            }
        }
//        System.out.println(Arrays.toString(nums));
        for (int i = 0;i < nums.length; i ++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] - 1 == i || nums[i] > nums.length) i ++;
            else if (nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else i++;
        }
        System.out.println(Arrays.toString(nums));

        i = 0;
        while (i < nums.length && nums[i] - 1 == i) {
            i ++;
        }
        return i + 1;
    }
}
