package com.leah.graph;

public class BreathFirstSearch {

    public static String bfs(Graph g) {
        String result = "";
        boolean [] visited = new boolean [g.vertices];

        for (int i =0; i<g.vertices; i++) {
            if (!visited[i]) {
                result += bfsVisit(g, i, visited);

            }
        }
        return result;
    }

    public static String bfsVisit(Graph g, int source, boolean[] visited) {
        String result = "";
        Queue<Integer> queue = new Queue<>(g.vertices);

        queue.enqueue(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.dequeue();
            result += String.valueOf(currentNode);

            DoublyLinkedList<Integer>.Node temp = null;

            while (g.adjacencyList[currentNode] != null) {
                temp = g.adjacencyList[currentNode].headNode;
            }

            while (temp != null) {
                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true;
                }
            }
            temp = temp.nextNode;
        }
        return result;

    }


}
