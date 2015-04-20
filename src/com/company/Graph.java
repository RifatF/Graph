package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Rigen on 20.04.15.
 */

class VertexComporator implements Comparator<Vertex> {

    @Override
    public int compare(Vertex o1, Vertex o2) {
        int o1Size = o1.getLinkedVertices().size();
        int o1Color = o1.getColor();
        int o2Color = o2.getColor();
        int o2Size = o2.getLinkedVertices().size();
        if (o1Size == o2Size && (o1Color == o2Color || o1Color != 0 && o2Color != 0))
            return 0;
        else if ((o1Color == 0 && o2Color != 0) || (!(o1Color != 0 && o2Color == 0) && o1Size > o2Size))
            return -1;
        else
            return 1;
    }
}

public class Graph {
    private ArrayList<Vertex> vertices = new ArrayList<Vertex>(20);

    public Graph(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }


    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public boolean hasEdge(Vertex first, Vertex two) {
        return first.getLinkedVertices().contains(two);
    }

    public void sort() {
        Collections.sort(this.vertices, new VertexComporator());
    }

    public int color() {
        boolean flag = false;
        boolean flag2 = false;
        int color = 0;
        while (!flag) {
            this.sort();
            color++;
            for (Vertex vertex : this.vertices) {
                flag2 = false;
                if (vertex.getColor() != 0) {
                    if (this.vertices.get(0).equals(vertex)) {
                        flag = true;
                    }
                    break;
                }
                for (Vertex vertex1 : vertex.getLinkedVertices()) {
                    if (vertex1.getColor() == color) {
                        flag2 = true;
                        break;
                    }
                }
                if (!flag2)
                    vertex.setColor(color);
            }
        }
        return color;
    }

    @Override
    public String toString() {
        return vertices.toString();
    }
}