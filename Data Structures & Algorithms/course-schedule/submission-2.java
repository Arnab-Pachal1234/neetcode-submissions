class Solution {

    private boolean dfs(int node, ArrayList<Integer>[] graph, boolean[] visited, boolean[] inStack) {
        visited[node] = true;
        inStack[node] = true;

        for (int neigh : graph[node]) {
            if (!visited[neigh]) {
                if (dfs(neigh, graph, visited, inStack)) return true;
            } else if (inStack[neigh]) {
            
                return true;
            }
        }

        inStack[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph: b → a means: to take a, you must complete b first
        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

        // Check each component for cycle
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, inStack)) {
                    return false; // cycle means cannot complete courses
                }
            }
        }

        return true; // no cycle → possible
    }
}
