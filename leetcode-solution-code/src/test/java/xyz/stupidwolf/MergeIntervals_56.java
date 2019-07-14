package xyz.stupidwolf;

import org.junit.Test;

import java.util.*;

/**
 * <p>create at <code>2019-06-19</code></p>
 *
 * @author chenmingli
 */
public class MergeIntervals_56 {
    @Test
    public void test() {
        int[][] intervals = new int[][] {
                {1,3},{3,8},{8,10},{15,18},{18, 28}
        };

        intervals = new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println(Arrays.deepToString(merge(intervals)));
        System.out.println(Arrays.deepToString(merge2(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int i = 0, end = intervals.length; i < end;) {
            int j = i + 1;
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (j < intervals.length) {
                if (right >= intervals[j][0]) {
                    right = Math.max(right, intervals[j][1]);
                    j ++;
                } else {
                    break;
                }
            }
            res.add(new int[] {left, right});
            i = j;
        }
        return res.toArray(new int[][]{});
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0;i < intervals.length; i ++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> list = new ArrayList<>(starts.length);
        int start = starts[0];
        int end = ends[0];

        for (int i = 1; i < intervals.length; i ++) {
            if (starts[i] > end) {
                list.add(new int[] {start, end});
                start = starts[i];
                end = ends[i];
            } else {
                end = ends[i];
            }
        }
        list.add(new int[] {start, end});
        return list.toArray(new int[][]{});
    }
}
