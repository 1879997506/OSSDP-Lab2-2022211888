
/**
 * @description:
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 */
public class Solution8 {


    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        //将周边为'1'的矩阵位置改为'0'
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        //确保矩阵的行数大于等于1并且小于等于300
        if(grid.length<1 || grid.length >300){
            throw new IllegalArgumentException("矩阵的行数必须大于1并且小于等于300");
        }
        //确保矩阵每行的列数大于等于1并且小于等于300
        for(int i = 0 ; i< grid.length;i++){
            if(grid[i].length<1 || grid[i].length >300){
                throw new IllegalArgumentException("矩阵每行的列数必须大于等于1并且小于等于300");
            }
        }
        //确保矩阵中的值为'0'或'1'
        for(int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j <grid[i].length; j++){
                if(grid[i][j]!='0' & grid[i][j]!='1'){
                    throw new IllegalArgumentException("矩阵中的值只能为'0‘或'1'");
                }
            }
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        //计算岛屿数量
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}