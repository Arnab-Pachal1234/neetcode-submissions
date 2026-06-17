class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        arr[j] = c;

                        String newWord = new String(arr);

                        if (newWord.equals(endWord)) return level + 1;

                        if (dict.contains(newWord)) {
                            queue.add(newWord);
                            dict.remove(newWord); 
                        }
                    }
                    arr[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
}
