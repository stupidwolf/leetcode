package xyz.stupidwolf;

import org.junit.Test;

/**
 * <p>create at <code>2019-06-19</code></p>
 *
 * @author chenmingli
 */
public class JumpGameII_45 {

    @Test
    public void test() {
        int[] nums = new int[] {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int i = 0;
        int step = 0;
        while (true) {
            if (nums[i] + i >= nums.length - 1) {
                break;
            } else {
                int maxIndex = i;
                int maxStep = nums[i] + i;
                for (int j = i + 1, end = i + nums[i]; j <= end; j ++) {
                    if (nums[j] + j > maxStep) {
                        maxIndex = j;
                        maxStep = nums[j] + j;
                    }
                }
                if (maxIndex == i) {
                    return 0;
                } else {
                    i = maxIndex;
                    step ++;
                }
            }
        }

        return step;
    }
}
