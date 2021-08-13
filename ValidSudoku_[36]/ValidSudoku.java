import java.util.Set;
import java.util.HashSet;

public class ValidSudoku {

    //PROBLEM: Valid Sudoku
    //  Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the
    //  following rules:
    //  Each row must contain the digits 1-9 without repetition.
    //  Each column must contain the digits 1-9 without repetition.
    //  Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    //  Note:
    //  A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    //  Only the filled cells need to be validated according to the mentioned rules.
    //Constraints:
    //  board.length == 9
    //  board[i].length == 9

    public static void main(String[] args) {

    }

    // time complexity: O(n^2)
    // space complexity: O(n^2)
    //[HashSet] Build a hashset for each row, col and box. So, create an array of hashset as rows, cols and boxes. Then,
    //traverse the matrix and check if the character is already there in hashset of any of the rows/cols/boxes
    //took 5 ms (37 percentile) and 45 MB (5 percentile)
    public static boolean isValidSudoku(char[][] board){
        int n = 9;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];

        for(int i = 0; i < n; i++){
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                char ch = board[r][c];

                if(ch == '.') continue;
                if(rows[r].contains(ch)) return false;

                if(cols[c].contains(ch)) return false;

                int index = (r / 3) * 3 + c / 3;
                if(boxes[index].contains(ch)) return false;

                rows[r].add(ch);
                cols[c].add(ch);
                boxes[index].add(ch);
            }
        }
        return true;
    }

    // time complexity: O(n^2)
    // space complexity: O(n^2)
    //[Array] Build an array for each row, col and box. So, create an array of array of integers for rows, cols and
    //boxes. Then, traverse the matrix and check if the character is already there in hashset of any of the
    //rows/cols/boxes
    //took 3 ms (51 percentile) and 43.4 MB (6 percentile)
    public static boolean isValidSudoku2(char[][] board) {
        int N = 9;

        // Use an array to record the status
        int[][] rows = new int[N][N];
        int[][] cols = new int[N][N];
        int[][] boxes = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // Check if the position is filled with number
                if (board[r][c] == '.') {
                    continue;
                }
                int pos = board[r][c] - '1';

                // Check the row
                if (rows[r][pos] == 1) {
                    return false;
                }
                rows[r][pos] = 1;

                // Check the column
                if (cols[c][pos] == 1) {
                    return false;
                }
                cols[c][pos] = 1;

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx][pos] == 1) {
                    return false;
                }
                boxes[idx][pos] = 1;
            }
        }
        return true;
    }
}
