import java.lang.classfile.Label;
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

        distance.put(start, 0.0);
        prioQueue.add(start);

        //the main loop of pain and suffering and dutch algorithmyicspeople

        while(!prioQueue.isEmpty()){
            Label u = prioQueue.poll();

            if(u.equals(end)){
                break;  //as we have reached the end
            }


            GraphList<Label>.GraphNode uNode = graph.findNode(u);
            if (uNode == null) continue;

            for(GraphList<Label>.GraphNode neighbour: uNode.edges){
                Label v = neighbour.id;

                double baseWeight = graph.getWeight(u,v);
                String lineUV = graph.getLine(u,v);


                //adding in the line changes
                double lineChange = 2.0;

                if(previousLine.get(u) !=null && !previousLine.get(u).equals(lineUV)){
                    lineChange = 2.0;
                }

                double newDistance = distance.get(u) + baseWeight + lineChange;

                if(newDistance<distance.get(v)){
                    distance.put(v, newDistance);
                    previousStation.put(v, u);
                    previousLine.put(v, lineUV);
                    prioQueue.add(v);
                }


            }
            


        }

        


        
        
        
        return null;

    }

    public static void main(String[] args) {
        System.out.println("Djikstra's algorithm is one of the algorithms of all tim"); // yes
    }
}
