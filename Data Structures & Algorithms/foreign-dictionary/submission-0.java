

class Solution {

    private String topoSort(HashMap<Character, HashSet<Character>> graph) {
        HashMap<Character, Integer> indegree = new HashMap<>();

        // Initialize indegree of every character as 0
        for (char ch : graph.keySet()) {
            indegree.put(ch, 0);
        }

        // Calculate indegree
        for (char u : graph.keySet()) {
            for (char v : graph.get(u)) {
                indegree.put(v, indegree.get(v) + 1);
            }
        }

        Queue<Character> q = new LinkedList<>();

        // Add all characters with indegree 0
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                q.add(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        // Kahn's Algorithm
        while (!q.isEmpty()) {
            char curr = q.poll();
            result.append(curr);

            for (char next : graph.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    q.add(next);
                }
            }
        }

        // Cycle detected
        if (result.length() != graph.size()) {
            return "";
        }

        return result.toString();
    }

    public String foreignDictionary(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();

        // Step 1: Add all unique characters as graph nodes
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
            }
        }

        // Step 2: Compare adjacent words only
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            boolean foundDifference = false;
            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    foundDifference = true;
                    break;
                }
            }

            // Invalid case: "abc" comes before "ab"
            if (!foundDifference && w1.length() > w2.length()) {
                return "";
            }
        }

        return topoSort(graph);
    }
}