class Edge implements Comparable<Edge> {
    public int pos;
    public int height;
    public boolean isStart;

    public Edge(int pos, int height, boolean isStart) {
        this.pos = pos;
        this.height = height;
        this.isStart = isStart;
    }

    public int compareTo(Edge e) {
        if (this.pos != e.pos) return Integer.compare(this.pos, e.pos);
        if (this.isStart && e.isStart) return Integer.compare(e.height, this.height);
        if (!this.isStart && !e.isStart) return Integer.compare(this.height, e.height);
        return this.isStart ? -1 : 1;
    }
}

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0
                || buildings[0].length == 0) return res;
        List<Edge> edges = new ArrayList<>();
        for (int[] building : buildings) {
            Edge start = new Edge(building[0], building[2], true);
            Edge end = new Edge(building[1], building[2], false);
            edges.add(start);
            edges.add(end);
        }
        Collections.sort(edges);

        PriorityQueue<Integer> heap = new PriorityQueue<>(10, Collections.reverseOrder());
        for (Edge edge : edges) {
            if (edge.isStart) {
                if (heap.isEmpty() || edge.height > heap.peek()) {
                    res.add(new int[] {edge.pos, edge.height});
                }
                heap.add(edge.height);
            } else {
                heap.remove(edge.height);
                if (heap.isEmpty() || edge.height > heap.peek()) {
                    res.add(new int[] {edge.pos, heap.isEmpty() ? 0 : heap.peek()});
                }
            }
        }
        return res;
    }
}