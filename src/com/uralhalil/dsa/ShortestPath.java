package com.uralhalil.dsa;

class ShortestPath {

    static int V = 9;

    int min_distance(int[] dist, boolean[] spt) {
        int min_distance = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++) {
            if (spt[v] == false && dist[v] <= min_distance) {
                min_distance = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void printResult(int[] dist) {
        System.out.println("Vertex   Distance from Source");
        for (int v = 0; v < V; v++) {
            System.out.println(v + " tt " + dist[v]);
        }
    }

    void dijkstra(int[][] graph, int source) {

        int[] dist = new int[V];  // O(v)
        boolean[] spts = new boolean[V]; // O(v)

        // Time Complexity = c1 * v + c2 * v

        // Assign initial values for each members of the arrays

        for (int i = 0; i < V; i++) {  // v times
            dist[i] = Integer.MAX_VALUE; // O(1)
            spts[i] = false; // O(1)
        }

        //

        // THe distance from the source is also 0

        dist[source] = 0;

        for (int counter = 0; counter < V; counter++) {

            int u = min_distance(dist, spts);

            spts[u] = true;

            for (int v = 0; v < V; v++) {
                if (!spts[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }


        // printh the results

        printResult(dist);

    }


    // Driver method
    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, // 0.vertex distance set
                {4, 0, 8, 0, 0, 0, 0, 11, 0}, // 1.vertex distance set
                {0, 8, 0, 7, 0, 4, 0, 0, 2}, // 2.vertex distance set
                {0, 0, 7, 0, 9, 14, 0, 0, 0}, // 3.vertex distance set
                {0, 0, 0, 9, 0, 10, 0, 0, 0}, // 4.vertex distance set
                {0, 0, 4, 14, 10, 0, 2, 0, 0}, // 5.vertex distance set
                {0, 0, 0, 0, 0, 2, 0, 1, 6}, // 6.vertex distance set
                {8, 11, 0, 0, 0, 0, 1, 0, 7}, // 7.vertex distance set
                {0, 0, 2, 0, 0, 0, 6, 7, 0}}; // 8.vertex distance set
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}