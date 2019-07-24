package xyz.stupidwolf;

import org.junit.Test;

public class WordSearch_79 {
    @Test
    public void test() {
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        board = new char[][] {
                {'a', 'b'},
                {'c', 'd'}
        };

        String word = "ABCCED";
        word = "SEE";
        word = "ABCB";
        word = "acdb";
        boolean rs =  exist(board, word);
        System.out.println(rs);

        System.out.println(exist2(board, word));
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] hasSearch = new boolean[board.length][board[0].length];
        int m = board.length;
        int n = board[0].length;
        boolean[] found = new boolean[] {false};

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                backtrace(word, board, 0, hasSearch, m, n, i, j, found);
                if (found[0]) {
                    break;
                }
            }
        }
        return found[0];
    }

    private void backtrace(String word, char[][] board, int start, boolean[][] hasSearch, int m , int n, int i, int j, boolean[] found) {
        if (found[0]) {
            return;
        }
       if (start >= word.length()) {
           found[0] = true;
//           System.out.println(Arrays.deepToString(hasSearch));
           return;
       }

        if (i >= 0 && i < m && j >= 0 && j < n && !hasSearch[i][j] && word.charAt(start) == board[i][j]) {
            //left
           hasSearch[i][j] = true;
           backtrace(word, board, start + 1, hasSearch, m, n, i, j - 1, found);
           // bottom
           backtrace(word, board, start + 1, hasSearch, m, n, i + 1, j, found);
           // right
           backtrace(word, board, start + 1, hasSearch, m, n, i, j + 1, found);
           // top
           backtrace(word, board, start + 1, hasSearch, m, n, i - 1, j, found);
           hasSearch[i][j] = false;
       }
    }

    public boolean exist2(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] hasSearched = new boolean[m][n];
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (backtrace(words, board, 0, hasSearched, m, n, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrace(char[] word, char[][] board, int start, boolean[][] hasSearched, int m, int n, int i, int j) {
        if (start >= word.length) {
            return true;
        }

        if (i < 0 || i >= m || j < 0 || j >= n || hasSearched[i][j] || board[i][j] != word[start]) {
            return false;
        }

        hasSearched[i][j] = true;
        boolean exist = backtrace(word, board, start + 1, hasSearched, m, n, i, j - 1) ||
                backtrace(word, board, start + 1, hasSearched, m, n, i + 1, j) ||
                backtrace(word, board, start + 1, hasSearched, m, n, i, j + 1) ||
                backtrace(word, board, start + 1, hasSearched, m, n, i - 1, j);
        hasSearched[i][j] = false;
        return exist;
    }
}
