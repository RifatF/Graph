package com.company;

import java.util.ArrayList;

/**
 * Created by Rigen on 20.04.15.
 */
public class Vertex {
    private int number;
    private int color;
    private ArrayList<Vertex> linkedVertices = new ArrayList<Vertex>(20);

    public Vertex(int number, ArrayList<Vertex> linkedVertices) {
        this.number = number;
        this.color = 0;
        this.linkedVertices = linkedVertices;
    }

    public Vertex(int number, Vertex[] array) {
        this.number = number;
        this.color = 0;
        for (Vertex vertex : array) {
            this.linkedVertices.add(vertex);
        }
    }

    public Vertex(int number) {
        this.number = number;
        this.color = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public ArrayList<Vertex> getLinkedVertices() {
        return linkedVertices;
    }

    public void setLinkedVertices(ArrayList<Vertex> linkedVertices) {
        this.linkedVertices = linkedVertices;
    }

    public void setLinkedVertices(Vertex[] array) {
        this.linkedVertices.clear();
        for (Vertex vertex : array) {
            this.linkedVertices.add(vertex);
        }
    }

    @Override
    public String toString() {
        String result = "{" + this.number + ", " + color + ", [";
        for (Vertex vertex : linkedVertices) {
            result += vertex.getNumber() + ", ";
        }
        result += "]}";
        return result;
    }
}
