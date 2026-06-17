class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // Build graph with lexicographically sorted outgoing edges
        for (List<String> t : tickets) {
            graph.putIfAbsent(t.get(0), new PriorityQueue<>());
            graph.get(t.get(0)).add(t.get(1));
        }

        dfs("JFK");
        return path;
    }

    private void dfs(String airport) {
        PriorityQueue<String> dests = graph.get(airport);

        while (dests != null && !dests.isEmpty()) {
            String next = dests.poll();
            dfs(next);
        }

        path.addFirst(airport);
    }
}
