package g0001_0100.s0016_3sum_closest;

// #Medium #Array #Sorting #Two_Pointers #2022_06_14_Time_3_ms_(99.98%)_Space_43.5_MB_(16.47%)

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int n = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] + nums[n - 1] + nums[n - 2] < target) {
                sum = nums[i] + nums[n - 1] + nums[n - 2];
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) {
                int temp = nums[i] + nums[i + 1] + nums[i + 2];
                return lessGap(sum, temp, target);
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp == target) {
                    return target;
                }
                if (temp < target) {
                    j++;
                } else {
                    k--;
                }
                sum = lessGap(sum, temp, target);
            }
        }
        return sum;
    }

    private int lessGap(int sum, int temp, int target) {
        return Math.abs(sum - target) < Math.abs(temp - target) ? sum : temp;
    }
}
