package algorithm;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraEagerWay {

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.dijkstra_GetMinDistances(0);
    }


    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        void addEdge(int src, int des, int weight) {
            Edge edge = new Edge(src, des, weight);
            adjacencylist[src].add(edge);

            edge = new Edge(des, src, weight);
            adjacencylist[des].add(edge);

        }

        static class Edge {
            int source;
            int destination;
            int weight;

            public Edge(int source, int destination, int weight) {
                this.source = source;
                this.destination = destination;
                this.weight = weight;
            }
        }

        public void dijkstra_GetMinDistances(int source) {

            // distance used to store the distance
            int[] distance = new int[vertices];

            boolean[] visited = new boolean[vertices];

            // initialize with maximum value
            for (int i = 0; i < vertices; i++) {
                distance[i] = Integer.MAX_VALUE;
            }

            PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(vertices, (o1, o2) -> {
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return key1 - key2;
            });

            // create the pair for first index(src)
            distance[0] = 0;
            Pair<Integer, Integer> p0 = new Pair<>(distance[0], 0);
            priorityQueue.add(p0);

            while (!priorityQueue.isEmpty()) {
                Pair<Integer, Integer> extractedPair = priorityQueue.remove();

                int extractedVertex = extractedPair.getValue();

                if (!visited[extractedVertex]) {
                    visited[extractedVertex] = true;

                    LinkedList<Edge> neighbour = adjacencylist[extractedVertex];
                    for (int i = 0; i < neighbour.size(); i++) {
                        Edge edge = neighbour.get(i);
                        int destination = edge.destination;
                        if (!visited[destination]) {
                            int newDis = distance[extractedVertex] + edge.weight;
                            int current = distance[destination];

                            if (current > newDis) {
                                Pair<Integer, Integer> p = new Pair<>(newDis, destination);
                                priorityQueue.offer(p);
                                distance[destination] = newDis;
                            }
                        }

                    }

                }


            }
            printGraph(distance, source);

        }

        void printGraph(int[] distance, int source) {
            System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
            for (int i = 0; i < vertices; i++) {
                System.out.println("Source Vertex: " + source + " to vertex " + +i +
                        " distance: " + distance[i]);
            }
        }

    }
}


