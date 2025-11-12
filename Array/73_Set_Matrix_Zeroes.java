// Brute Force Time Complexity - O(n)cube

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // First pass: if an element is 0, mark its entire row and column as -1
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if ( matrix[i][j] == 0 ){
                    setRow(matrix, i, m);
                    setCol(matrix, j, n);
                }
            }
        }

        // Second Pass - Mark All -1 to Zero
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if ( matrix[i][j] == -1 ){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Marks all non-zero elements in the given row as -1 (temporary marker)
    void setRow(int[][] matrix, int i, int m){
        for (int j=0; j<m; j++){
            if ( matrix[i][j] != 0 ){
                matrix[i][j] = -1;
            }
        }
    }

    // Marks all non-zero elements in the given column as -1 (temporary marker)
    void setCol(int[][] matrix, int j, int n){
        for (int i=0; i<n; i++){
            if ( matrix[i][j] != 0 ){
                matrix[i][j] = -1;
            }
        }
    }
}