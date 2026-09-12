class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean [][] visited = new boolean[n][m];
        boolean ans = false;

        for(int i=0; i<n ; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    ans = dfs(board, word, visited, i, j, 0);
                    if(ans)
                        return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true;
        
        if (dfs(board, word, visited, i + 1, j, index + 1) ||
            dfs(board, word, visited, i - 1, j, index + 1) ||
            dfs(board, word, visited, i, j + 1, index + 1) ||
            dfs(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}