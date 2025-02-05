package g0301_0400.s0349_intersection_of_two_arrays;

// #Easy #Array #Hash_Table #Sorting #Binary_Search #Two_Pointers
// #2022_03_15_Time_1_ms_(99.75%)_Space_43.9_MB_(40.34%)

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] occ = new boolean[1001];
        for (int k : nums1) {
            occ[k] = true;
        }
        List<Integer> res = new ArrayList<>();
        for (int j : nums2) {
            if (occ[j]) {
                occ[j] = false;
                res.add(j);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
