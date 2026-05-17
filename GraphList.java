import java.util.*;

public class GraphList<Label> {
    

    // adjacency list container
    GraphNode headNode;
    //Map<<c.fromStation, c.destinationStation>, Double> weights; 

    public class GraphNode<label> {
        Label id; // station name
        LinkedHashSet<GraphNode> edges; // set of neighbour nodes
        GraphNode next; // pointer to next station in the list

        public GraphNode(Label label) {
            this.id = label;
            this.edges = new LinkedHashSet<GraphNode>();
        }
    }

    public void addNode(Label label) {
        GraphNode node = new GraphNode(label);
        node.next = headNode;
        headNode = node;
    }

    private GraphNode findNode(Label label) {
        GraphNode node = headNode;
        while (node != null) {
            if (node.id == label)
                return node;
            node = node.next;
        }
        return null;
    }

    private void getOrCreateNode(Label label) {
        GraphNode node = node;
        node = findNode(label);
        if (node == null) {
            addNode(label);
            node = findNode(label);
        }
    }

}