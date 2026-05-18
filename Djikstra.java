import java.util.*;

public class Djikstra {      
    public static <Label> List<Label> djikstraPath(GraphList<Label> graph, Label start, Label end){
        
        Map<Label, Double> distance = new HashMap<>();
        Map<Label, Double> previousStation = new HashMap<>();
        Map<Label, Double> previousLine = new HashMap<>();
//use a priority queue to search by the best distance
        PriorityQueue<Label> prioQueue = new PriorityQueue<>(Comparator.comparingDouble(distance::get));

        GraphList<Label>.GraphNode node = graph.headNode;

        while (node!=null){
            distance.put(node.id, Double.POSITIVE_INFINITY);
            previousStation.put(node.id, null);
            previousLine.put(node.id, null);
            node = node.next;
        }

        


        
        
        
        return null;

    }
    

    public static void main(String[] args) {
        System.out.println("Djikstra's algorithm is one of the algorithms of all tim"); //yes
    }
}
