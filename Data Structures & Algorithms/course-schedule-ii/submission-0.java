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

        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

  
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, inStack)) {
                    return false;
                }
            }
        }

        return true;
    }
    public int[] findOrder(int numCourses, int[][] pre) {
        if(!canFinish(numCourses,pre)) return new int[0];
        int indegree[] = new int[numCourses];
          ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : pre) {
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0) q.add(i);
        }
        int[] ans = new int[numCourses];
        int l=0;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            ans[l++]=curr;
            for(Integer neigh : graph[curr])
            {
                indegree[neigh]--;
                if(indegree[neigh]==0) q.add(neigh);
            }   
        }
        return ans;


    }
}
