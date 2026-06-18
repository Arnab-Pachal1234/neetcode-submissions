
class Solution {
 
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; 
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#') {
            return;
        }

        char currentChar = board[r][c];
        TrieNode nextNode = node.children[currentChar - 'a'];

      
        if (nextNode == null) {
            return;
        }

      
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null;
        }

       
        board[r][c] = '#';

      
        dfs(board, r + 1, c, nextNode, result); 
        dfs(board, r - 1, c, nextNode, result); 
        dfs(board, r, c + 1, nextNode, result); 
        dfs(board, r, c - 1, nextNode, result);


        board[r][c] = currentChar;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.word = word; // Store the word at the leaf
        }
        return root;
    }
}