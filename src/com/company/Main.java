package com.company;

public class Main {

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
//                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
//                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
//                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0}
//        };
        int[][] matrix = new int[][]{
                {0, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1, 0, 0}
        };
        Graph graph = new Graph(matrix);
        System.out.println(graph);
        long time = System.nanoTime();
        int color = graph.color();
        time = System.nanoTime() - time;
        System.out.println(graph);
        System.out.println("Number of colors: " + color);
        System.out.println("Time(ns): " + time);
    }
}
