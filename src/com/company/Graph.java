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
        int o2Size = o2.getLinkedVertices().size();
        int o1Color = o1.getColor();
        int o2Color = o2.getColor();
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

    public Graph(int[][] matrix) {
        int numberOfVertices = matrix.length;
        for (int i = 0; i < numberOfVertices; i++) {
            this.vertices.add(new Vertex(i + 1));
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (matrix[i][j] == 1) {
                    this.vertices.get(i).getLinkedVertices().add(this.vertices.get(j));
                    this.vertices.get(j).getLinkedVertices().add(this.vertices.get(i));
                }
            }
        }
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
        int color = 0;
        this.sort();
        for (Vertex vertex : this.vertices) {
            int newColor = findColor(vertex);
            if (newColor > color)
                color = newColor;
            vertex.setColor(newColor);
        }
        return color;
    }

    public static int findColor(Vertex vertex) {
        int color = 1;
        while(true) {
            for (Vertex linkedVertex : vertex.getLinkedVertices()) {
                if (linkedVertex.getColor() == color) {
                    color++;
                    continue;
                }
            }
            return color;
        }
    }

    @Override
    public String toString() {
        return vertices.toString();
    }
}
