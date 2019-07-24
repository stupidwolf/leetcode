package xyz.stupidwolf;

import org.junit.Test;

import java.util.Stack;

public class TrappingRainWater_42 {
    @Test
    public void test() {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        int rs = trap(height);
        int rs2 = trap2(height);
        int rs3 = trap3(height);
        int rs4 = trap4(height);
        System.out.println(rs);
        System.out.println(rs2);
        System.out.println(rs3);
        System.out.println(rs4);
    }
    public int trap(int[] height) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxRight = -1;

        while (left < height.length - 1) {
            if (height[left + 1] >= height[left]) {
                left ++;
            } else {
                int temp = left;
                while (temp < height.length - 1 && height[temp] >= height[temp + 1]) {
                    temp ++;
                }
                right = temp;
                while (right < height.length - 1) {
                    if (height[right + 1] < height[right]) {
                        break;
                    }
                    right ++;
                }
                int minHeight = Math.min(height[left], height[right]);
                int area =minHeight * (right - left);
                for (int i = left; i < right; i ++) {
                   area -= Math.min(height[i], minHeight);
                }
//                System.out.println(area);
                sum += area;
                left = right;
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int sum = 0;
        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    sum += maxLeft - height[left];
                }
                left ++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    sum += maxRight - height[right];
                }
                right --;
            }
        }
        return sum;
    }

    public int trap3(int[] height) {
        if (height == null || height.length <= 0) {
            return 0;
        }
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int sum = 0;
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i ++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length -2; i >= 0; i --) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        for (int i = 0; i < height.length;i ++) {
            sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return sum;
    }

    public int trap4(int[] height) {
        if (height == null || height.length <= 0) {
            return 0;
        }
        int current = 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[stack.peek()], height[current]) - height[top];
                sum += distance * boundedHeight;
            }
            stack.push(current ++);
        }

        return sum;
    }

}
