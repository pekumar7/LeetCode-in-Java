package g0401_0500.s0463_island_perimeter;

// #Easy #Array #Depth_First_Search #Breadth_First_Search #Matrix
// #2022_03_18_Time_9_ms_(74.15%)_Space_62.2_MB_(45.55%)

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        neighbours++;
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        neighbours++;
                    }
                }
            }
        }
        return 4 * islands - 2 * neighbours;
    }
}
