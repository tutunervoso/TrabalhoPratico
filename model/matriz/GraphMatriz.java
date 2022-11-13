package model.matriz;

import java.util.HashMap;

import exception.VertexNotFoundException;
import model.Graph;
import model.Vertex;

public class GraphMatriz implements Graph {
    private double[][] mat;
    private boolean isDirected;
    private HashMap<String, Integer> names;
    private int currentNumVertex;

    public GraphMatriz(int numVertex, boolean directed) {
        mat = new double[numVertex][numVertex];
        this.names = new HashMap<>();
        this.isDirected = directed;
    }

    public boolean addEdge(Vertex u, Vertex v, double value) {
        Integer line = names.get(u.getName());
        Integer column = names.get(v.getName());
        if (line == null || column == null) {
            return false;
        }
        mat[line][column] = value;
        if (!isDirected) {
            mat[column][line] = value;
        }
        return true;
    }

    @Override
    public void addVertex(Vertex v) throws VertexNotFoundException {
        if (v.getName() == null) {
            throw new VertexNotFoundException("Vértice " + v.getName() + " não encontrado.");
        }
        names.put(v.getName(), currentNumVertex);
        currentNumVertex++;
    }

    @Override
    public String toString() {
        String out = "";
        for (double[] linha : mat) {
            for (double valor : linha) {
                out += ("| "+valor + "\t");
            }
            out += "|\n";
        }
        return out;
    }

    @Override
    public boolean adjacent(Vertex u, Vertex v) {
        Integer line = names.get(u.getName());
        Integer column = names.get(v.getName());
        if (line == null || column == null) {
            return false;
        }
        return mat[line][column] == 1;
    }

    @Override
    public boolean removeVertex(Vertex v) {
        // can't remove
        return false;
    }

    @Override
    public boolean removeEdge(Vertex u, Vertex v) {
        Integer line = names.get(u.getName());
        Integer column = names.get(v.getName());
        if (line == null || column == null) {
            return false;
        }
        mat[line][column] = 0;
        mat[column][line] = 0;
        return true;
    }

    @Override
    public boolean isDirected() {
        return isDirected;
    }

    public boolean notDirected() {
        return !isDirected;
    }

    @Override
    public double[][] converter(){
        double conv[][]=new double[mat.length][mat.length];
        for (int i=0;i<mat.length;i++) {
            for (int j=0;j<mat.length;j++) {
                conv[i][j]=mat[i][j];
            }
        }
        return conv;
    }

    @Override
    public String[] conLista() {
        // TODO Auto-generated method stub
        return null;
    }

}
