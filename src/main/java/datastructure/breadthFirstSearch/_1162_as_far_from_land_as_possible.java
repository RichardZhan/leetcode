package datastructure.breadthFirstSearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Richard.Zhan
 * @Description:
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents
 * land, find a water cell such that its distance to the nearest land cell is maximized and
 * return the distance.
 *
 * The distance used in this problem is the Manhattan distance: the distance between two
 * cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *
 * If no land or water exists in the grid, return -1.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/23 16:32
 */
public class _1162_as_far_from_land_as_possible {


    public int maxDistance(int[][] grid) {
        int N = grid.length;

        Queue<int []> queue = new ArrayDeque<>();
        // 所有的陆地格子入队列
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }

        // 只有陆地或海洋，返回-1
        if (queue.isEmpty() || queue.size() == N*N){
            return -1;
        }

        int distance = -1;
        while (!queue.isEmpty()) {
            distance ++;
            int n = queue.size();
            // 遍历上下左右，层序遍历
            for (int i = 0; i < n; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                // 遍历上方单元格
                if (r-1 >= 0 && grid[r-1][c] == 0) {
                    grid[r-1][c] = 2;
                    queue.add(new int[]{r-1, c});
                }
                // 遍历下方单元格
                if (r+1 < N && grid[r+1][c] == 0) {
                    grid[r+1][c] = 2;
                    queue.add(new int[]{r+1, c});
                }
                // 遍历左边单元格
                if (c-1 >= 0 && grid[r][c-1] == 0) {
                    grid[r][c-1] = 2;
                    queue.add(new int[]{r, c-1});
                }
                // 遍历右边单元格
                if (c+1 < N && grid[r][c+1] == 0) {
                    grid[r][c+1] = 2;
                    queue.add(new int[]{r, c+1});
                }

            }
        }

        return distance;
    }



    public static void main(String[] args) {
        // [[1,0,1],[0,0,0],[1,0,1]]
        int[][] grid = new int[][] {{1,0,1},{0,0,0},{1,0,1}};

        _1162_as_far_from_land_as_possible instance = new _1162_as_far_from_land_as_possible();
        int distance = -1;
        distance = instance.maxDistance(grid);
        System.out.println(distance);

    }


}
