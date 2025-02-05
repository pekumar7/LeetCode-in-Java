package g0401_0500.s0419_battleships_in_a_board;

// #Medium #Array #Depth_First_Search #Matrix #2022_03_18_Time_1_ms_(83.10%)_Space_44.4_MB_(38.04%)

public class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.'
                        && (j <= 0 || board[i][j - 1] != 'X')
                        && (i <= 0 || board[i - 1][j] != 'X')) {
                    count++;
                }
            }
        }
        return count;
    }
}
