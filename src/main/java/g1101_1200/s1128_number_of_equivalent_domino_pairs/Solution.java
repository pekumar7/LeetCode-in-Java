package g1101_1200.s1128_number_of_equivalent_domino_pairs;

// #Easy #Array #Hash_Table #Counting #2022_03_09_Time_10_ms_(69.88%)_Space_51.4_MB_(88.61%)

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int[] dominoe : dominoes) {
            int smaller = Math.min(dominoe[0], dominoe[1]);
            int bigger = Math.max(dominoe[0], dominoe[1]);
            int key = smaller * 10 + bigger;
            count += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return count;
    }
}
