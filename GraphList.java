import java.util.*;

@SuppressWarnings("unchecked")
public class GraphList<Label> {

    // adjacency list container
    GraphNode headNode;
    private final Map<String, Double> weightMap = new HashMap<>(); // hashmap
    private final Map<String, String> lineMap = new HashMap<>();

    public class GraphNode {
        Label id; // station name
        LinkedHashSet<GraphNode> edges; // set of neighbour nodes
        GraphNode next; // pointer to next station in the list

        public GraphNode(Label label) {
            this.id = label;
            this.edges = new LinkedHashSet<>();
        }
    }

    private String makeKey(Label from, Label to) {
        return from + "," + to;
    }

    public void storeWeight(Label from, Label to, double time) {
        weightMap.put(makeKey(from, to), time);
    }

    public void storeLine(Label from, Label to, String lineColour) {
        lineMap.put(makeKey(from, to), lineColour);
    }

    public String getLine(Label from, Label to) {
        return lineMap.get(makeKey(from, to));
    }

    public double getWeight(Label from, Label to) {
        return weightMap.get(makeKey(from, to));
    }

    

    public void addNode(Label label) {
        GraphNode node = new GraphNode(label);
        node.next = headNode;
        headNode = node;
    }

    GraphNode findNode(Label label) {
        GraphNode node = headNode;
        while (node != null) {
            if (node.id.equals(label))
                return node;
            node = node.next;
        }
        return null;
    }

    private GraphNode getOrCreateNode(Label label) {
        GraphNode node = findNode(label);

        if (node == null) {
            addNode(label);
            node = findNode(label);
        }

        return node;
    }

    public void addEdge(Label l1, Label l2) {
        GraphNode node1 = getOrCreateNode(l1);
        GraphNode node2 = getOrCreateNode(l2);

        node1.edges.add(node2);
        node2.edges.add(node1); // got both because it's bidirectional
    }

    public void buildGraph(List<Connection> connections) {
        for (Connection c : connections) {
            Label from = (Label) c.getFromStation();
            Label to = (Label) c.getDestinationStation();
            double time = c.getTravelTime();
            storeLine(from, to, c.getLineColour().toLowerCase());
            storeLine(to, from, c.getLineColour().toLowerCase());

            addEdge(from, to);
            storeWeight(from, to, time);
            storeWeight(to, from, time);
        }
    }



    

    public static void main(String[] args) {

    }

}
