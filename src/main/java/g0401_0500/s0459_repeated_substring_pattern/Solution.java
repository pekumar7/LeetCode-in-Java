package g0401_0500.s0459_repeated_substring_pattern;

// #Easy #String #String_Matching #Programming_Skills_II_Day_2
// #2022_03_18_Time_9_ms_(90.15%)_Space_50.5_MB_(46.55%)

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n < 2) {
            return false;
        }
        int i = 0;
        while (i < (n + 1) / 2) {
            if (n % (i + 1) != 0) {
                i++;
                continue;
            }
            boolean match = true;
            String substring = s.substring(0, i + 1);
            int skippedI = i;
            for (int j = i + 1; j < n; j += i + 1) {
                if (!s.substring(j, j + i + 1).equals(substring)) {
                    match = false;
                    break;
                }
                skippedI += i + 1;
            }
            if (match) {
                return true;
            }
            i = skippedI;
            i++;
        }
        return false;
    }
}
