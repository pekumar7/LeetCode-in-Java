package g0201_0300.s0214_shortest_palindrome;

// #Hard #String #Hash_Function #String_Matching #Rolling_Hash
// #2022_03_05_Time_3_ms_(94.71%)_Space_43.6_MB_(23.95%)

public class Solution {
    public String shortestPalindrome(String s) {
        int i;
        int x;
        int diff;
        int n = s.length();
        int m = (n << 1) + 1;
        char[] letters = new char[m];
        for (i = 0; i < n; i++) {
            letters[i] = letters[m - 1 - i] = s.charAt(i);
        }
        letters[i] = '#';
        int[] lps = new int[m];
        lps[0] = 0;
        for (i = 1; i < m; i++) {
            x = lps[i - 1];
            while (letters[i] != letters[x]) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        diff = n - lps[m - 1];
        if (diff == 0) {
            return s;
        } else {
            StringBuilder builder = new StringBuilder();
            for (i = n - 1; i >= n - diff; i--) {
                builder.append(s.charAt(i));
            }
            builder.append(s);
            return builder.toString();
        }
    }
}
