package model;

public class Dijkstra {
    public static void dijkstra(double[][] graph, int source, String[] vertice) {
          int count = graph.length;
          boolean[] verticeLido = new boolean[count];
          double[] distancia = new double[count];
          for (int i = 0; i < count; i++) {
            verticeLido[i] = false;
            distancia[i] = Double.POSITIVE_INFINITY;
          }
      
          distancia[source] = 0;
          for (int i = 0; i < count; i++) {
        
            int u=verticeInicial(distancia, verticeLido);
            verticeLido[u] = true;

            for (int v = 0; v < count; v++) {
              if (!verticeLido[v] && graph[u][v] != 0 && (distancia[u] + graph[u][v] < distancia[v])) {
                distancia[v] = distancia[u] + graph[u][v];
              }
            }
          }
  
          for (int i = 0; i < distancia.length; i++) {
            System.out.println(String.format("Distância de %s para %s é %s", vertice[source], vertice[i], distancia[i]));
          }
        }
      
        private static int verticeInicial(double[] distancia, boolean[] verticeLido) {
          double minDistancia = Double.POSITIVE_INFINITY;
          int minDistanciaVertice = -1;
          for (int i = 0; i < distancia.length; i++) {
            if (!verticeLido[i] && distancia[i] < minDistancia) {
              minDistancia = distancia[i];
              minDistanciaVertice = i;
            }
          }
          return minDistanciaVertice;
        }
  }  