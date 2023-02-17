package com.leah.graph;

public class DepthFirstSearch {
    public static String dfs (Graph g) {
        String result = "";
        boolean [] visited = new boolean[g.vertices];

        for (int i =0; i< g.vertices; i++) {
            if (!visited[i]) {
                result += dfsVisit(g, i , visited);
            }
        }
        return result;
    }

    public static String dfsVisit (Graph g, int source, boolean[] visited) {
        String result = "";
        Stack<Integer> stack = new Stack<>(g.vertices);

        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            result += String.valueOf(currentNode);

            DoublyLinkedList<Integer>.Node temp = null;
            while (g.adjacencyList[currentNode] != null) {
                temp = g.adjacencyList[currentNode].headNode;
            }

            while (temp != null) {
                if (!visited[temp.data]) {
                    stack.push(temp.data);
                    visited[temp.data] = true;
                }
            }
            temp = temp.nextNode;
        }
        return result;
    }
}
