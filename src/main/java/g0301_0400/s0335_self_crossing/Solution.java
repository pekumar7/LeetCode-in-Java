package g0301_0400.s0335_self_crossing;

// #Hard #Array #Math #Geometry #2022_03_15_Time_6_ms_(44.12%)_Space_51.3_MB_(52.94%)

public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x.length < 4) {
            return false;
        }
        for (int i = 3; i < x.length; i++) {
            if (x[i - 1] <= x[i - 3] && x[i] >= x[i - 2]) {
                return true;
            }
            if (i > 4
                    && x[i] >= x[i - 2] - x[i - 4]
                    && x[i - 1] >= x[i - 3] - x[i - 5]
                    && x[i - 1] <= x[i - 3]
                    && x[i - 2] >= x[i - 4]) {
                return true;
            }
            if (i > 3 && x[i - 1] == x[i - 3] && x[i] >= x[i - 2] - x[i - 4]) {
                return true;
            }
        }
        return false;
    }
}
