package com.uralhalil.dsa;

class ShortestPath {

    static int V = 10;

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
        System.out.println("Vertex      Distance from Vertex");
        for (int v = 0; v < V; v++) {
            System.out.println(v + " tt " + dist[v]);
        }
    }

    void dijkstra(int graph[][], int source) {

        int[] dist = new int[V];
        boolean[] spt = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            spt[i] = false;
        }

        dist[source] = 0;

        for (int counter = 0; counter < V; counter++) {

            int u = min_distance(dist, spt);

            spt[u] = true;

            for (int v = 0; v < V; v++) {
                if (!spt[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printResult(dist);
    }


    // Driver method
    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0, 4}, // 0.vertex distance set
                {4, 0, 8, 0, 0, 0, 0, 11, 0, 3}, // 1.vertex distance set
                {0, 8, 0, 7, 0, 4, 0, 0, 2, 1}, // 2.vertex distance set
                {0, 0, 7, 0, 9, 14, 0, 0, 0, 3}, // 3.vertex distance set
                {0, 0, 0, 9, 0, 10, 0, 0, 0, 0}, // 4.vertex distance set
                {0, 0, 4, 14, 10, 0, 2, 0, 0, 2}, // 5.vertex distance set
                {0, 0, 0, 0, 0, 2, 0, 1, 6, 0}, // 6.vertex distance set
                {8, 11, 0, 0, 0, 0, 1, 0, 7, 2}, // 7.vertex distance set
                {0, 0, 2, 0, 0, 0, 6, 7, 0, 5},// 8.vertex distance set
                {0, 0, 2, 0, 0, 0, 6, 7, 0, 5}}; // 9.vertex distance set
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}
// This code is contributed by Aakash Hasija