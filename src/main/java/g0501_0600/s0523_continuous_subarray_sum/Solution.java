package g0501_0600.s0523_continuous_subarray_sum;

// #Medium #Array #Hash_Table #Math #Prefix_Sum
// #2022_03_20_Time_25_ms_(78.40%)_Space_90.4_MB_(67.54%)

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (map.containsKey(remainder)) {
                if (map.get(remainder) + 1 < i) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
