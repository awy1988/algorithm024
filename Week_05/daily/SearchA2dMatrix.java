package Week_05.daily;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchA2dMatrix {
    /**
     * 时间顺序查找复杂度为O(m+n)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int column = -1;
        if (matrix.length > 1) {
            for (int i = 0; i < matrix.length - 1; i++) {

                if (matrix[i][0] == target || matrix[i + 1][0] == target) {
                    return true;
                }

                if (matrix[i][0] < target && matrix[i+1][0] > target) {
                    column = i;
                }
            }
            if (column == -1) column = matrix.length - 1;
        } else {
            column = 0;
        }
        for (int i = 0; i < matrix[column].length; i++) {
            if (matrix[column][i] == target) return true;
        }

        return false;
    }

    /**
     * 二分查找
     * 由于这个二维数组有序，所以可以将二维数组视为一个一维数组，在一维数组中采用二分查找算法。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix,int target) {
        // m行n列的数组
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        int mid = (left + right) / 2;
        while(left <= right) {
            mid = (left + right) / 2;
            int row = mid / n;
            int column = mid % n;
            if (matrix[row][column] > target)  right = mid - 1;
            else if (matrix[row][column] < target) left = mid + 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] testData = new int[][] {
            {1,3,5,7},{10,11,16,20},{23,30,34,60}
        };
        SearchA2dMatrix searchA2dMatrix = new SearchA2dMatrix();
        System.out.println(searchA2dMatrix.searchMatrix2(testData,30));
    }
}
