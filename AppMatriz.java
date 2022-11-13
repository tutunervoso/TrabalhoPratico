import model.Graph;
import util.LoadData;
import model.Dijkstra;

public class AppMatriz {

    public static void main(String[] args) {
        Graph graphMatriz;
        String conversaoVerticeNome[];

        graphMatriz = LoadData.loadAdj("data/data.txt");

        System.out.println("Matriz:");
        System.out.println(graphMatriz);

        Graph lisGraph = LoadData.loadList("data/data.txt");

        System.out.println("Caminhos:");
        System.out.println(lisGraph);

        Dijkstra.dijkstra(graphMatriz.converter(), 0, conversaoVerticeNome=lisGraph.conLista());
    }
}