package com.lyh.algorithm.gragh;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
}

class Gragh2 {
    LinkedList<Integer>[] lists;
    int V;

    Gragh2(int v) {
        V = v;
        lists = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            lists[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int num) {
        lists[v].add(num);
    }

    public void dfsGragh(int s) {
        boolean visited[] = new boolean[V];;
        dfs(s, visited);
    }

    private void dfs(int s, boolean[] visited) {
        visited[s] = true;
        System.out.println(s + " ");
        Iterator<Integer> iterator = lists[s].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n]) {
                dfs(n, visited);
            }
        }
    }
    public static void main(String args[])
    {
        Gragh2 g = new Gragh2(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.dfsGragh(2);
    }
}