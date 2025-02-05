package g0501_0600.s0517_super_washing_machines;

// #Hard #Array #Greedy #2022_03_19_Time_0_ms_(100.00%)_Space_42.4_MB_(94.65%)

public class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int i : machines) {
            total += i;
        }
        if (total % machines.length != 0) {
            return -1;
        }
        int avg = total / machines.length;
        int cnt = 0;
        int max = 0;
        for (int load : machines) {
            cnt += load - avg;
            max = Math.max(Math.max(max, Math.abs(cnt)), load - avg);
        }
        return max;
    }
}
