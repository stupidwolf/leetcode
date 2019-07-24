package xyz.stupidwolf;

import org.junit.Test;

import java.util.Arrays;

public class SortColors_75 {

    @Test
    public void test() {
        int[] nums = new int[] {2,0,2,1,1,0};
        nums = new int[] {2, 2, 2, 0, 0, 1, 1};
        nums = new int[] {2};
        nums = new int[] {1};
        nums = new int[] {0};
        nums = new int[] {0,2,2,2,0,2,1,1};
        nums = new int[] {0,1,2,0,0,2,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        int index = 0;
        int firstBlueIndex = nums.length - 1;
        int firstWhiteIndex = -1;
        while (firstBlueIndex >= 0 && nums[firstBlueIndex] == 2) {
            firstBlueIndex --;
        }
        while (index <= firstBlueIndex) {
            if (nums[index] == 2) {
                swap(nums, index, firstBlueIndex);
                while (firstBlueIndex >= 0 && nums[firstBlueIndex] == 2) {
                    firstBlueIndex --;
                }
            }

            if (nums[index] == 0 && firstWhiteIndex != -1) {
                swap(nums, index, firstWhiteIndex);
                firstWhiteIndex ++;
            }

            if (nums[index] == 1 && firstWhiteIndex == -1) {
                firstWhiteIndex = index;
            }
            index ++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
