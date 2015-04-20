package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vertex> list = new ArrayList<Vertex>();
        for (int i = 0; i < 10; i++) {
            list.add(new Vertex(i));
        }
        list.get(0).setLinkedVertices(new Vertex[]{list.get(1), list.get(4), list.get(5)});
        list.get(1).setLinkedVertices(new Vertex[]{list.get(0), list.get(2), list.get(6)});
        list.get(2).setLinkedVertices(new Vertex[]{list.get(1), list.get(3), list.get(7)});
        list.get(3).setLinkedVertices(new Vertex[]{list.get(2), list.get(4), list.get(8)});
        list.get(4).setLinkedVertices(new Vertex[]{list.get(3), list.get(0), list.get(9)});
        list.get(5).setLinkedVertices(new Vertex[]{list.get(0), list.get(7), list.get(8)});
        list.get(6).setLinkedVertices(new Vertex[]{list.get(1), list.get(8), list.get(9)});
        list.get(7).setLinkedVertices(new Vertex[]{list.get(2), list.get(5), list.get(9)});
        list.get(8).setLinkedVertices(new Vertex[]{list.get(3), list.get(5), list.get(6)});
        list.get(9).setLinkedVertices(new Vertex[]{list.get(4), list.get(6), list.get(7)});
        Graph graph = new Graph(list);
        System.out.println(graph);
        long time = System.nanoTime();
        int color = graph.color() - 1;
        time = System.nanoTime() - time;
        System.out.println(graph);
        System.out.println("Number of colors: " + color);
        System.out.println("Time(ns): " + time);
    }
}
