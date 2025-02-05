package g0301_0400.s0324_wiggle_sort_ii;

// #Medium #Top_Interview_Questions #Array #Sorting #Divide_and_Conquer #Quickselect
// #2022_03_15_Time_6_ms_(69.23%)_Space_56.2_MB_(21.55%)

import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        int i = 1;
        // Start filling all peaks (which is all at odd indexes) from start
        for (; i < nums.length; i += 2) {
            result[i] = nums[index];
            --index;
        }

        // Start filling all valleys (which is all at even indexes) from end
        // why from end, as the last peak index may have smallest largest value, so to
        // make sure, that is also '>', fill in the smallest element near it.
        i = ((nums.length - 1) % 2 == 0) ? nums.length - 1 : nums.length - 2;
        index = 0;
        for (; i >= 0; i -= 2) {
            result[i] = nums[index];
            ++index;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
