import model.Graph;
import util.LoadData;

public class AppMatriz {

    public static void main(String[] args) {
        Graph graphMatriz;

        graphMatriz = LoadData.loadAdj("data/data.txt");

        System.out.println("Matriz:");
        System.out.println(graphMatriz);

        Graph lisGraph = LoadData.loadList("data/data.txt");

        System.out.println("Lista:");
        System.out.println(lisGraph);
    }
}