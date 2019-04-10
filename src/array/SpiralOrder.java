package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 螺旋遍历
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class SpiralOrder {
    // 定义方向
    private int RIGHT = 0;
    private int DOWN = 1;
    private int LEFT = 2;
    private int UP = 3;
    private int[] directions = {0, 1, 2, 3};

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int row = 0;
        int column = 0;
        int direction = directions[RIGHT];
        int maxRow = visited.length - 1;
        int maxColumn = visited[0].length - 1;

        while (row >= 0 && row <= maxColumn && column >= 0 && column <= maxColumn && !visited[row][column]) {
            result.add(matrix[row][column]);
            visited[row][column] = true;

            // 改变方向
            if (!isValidGoingToThisDirection(visited, direction, maxRow, maxColumn, row, column)) {
                direction = (direction + 1) % 4;
            }

            if (direction == RIGHT) {
                column++;
            } else if (direction == DOWN) {
                row++;
            } else if (direction == LEFT) {
                column--;
            } else if (direction == UP) {
                row--;
            }
        }

        return result;
    }

    /**
     * 判断是否继续在当前方向上继续遍历
     */
    private boolean isValidGoingToThisDirection(boolean[][] visited, int direction, int maxRow, int maxColumn, int row, int column) {
        // 向右 如果列数+1大于最大的列数或者右边一个元素已经被遍历过 返回false
        if (directions[RIGHT] == direction && (column + 1 > maxColumn || visited[row][column + 1])) return false;

        // 向下 如果行数+1大于最大行数或者下面一个元素已经被遍历过 返回false
        if (directions[DOWN] == direction && (row + 1 > maxRow || visited[row + 1][column])) return false;

        // 向左 如果列数-1小于0或者左边一个元素已经被遍历过 返回false
        if (directions[LEFT] == direction && (column - 1 < 0 || visited[row][column - 1])) return false;

        // 向上 如果行数-1小于0或者上面一个元素已经被遍历过
        if (directions[UP] == direction && (row - 1 < 0 || visited[row - 1][column])) return false;

        return true;
    }
}
