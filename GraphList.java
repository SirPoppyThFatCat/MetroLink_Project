import java.util.*;

public class GraphList<Label> {

    // adjacency list container
    GraphNode headNode;
    // Map<<c.fromStation, c.destinationStation>, Double> weights;

    public class GraphNode {
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

    public void getOrCreateNode(Label label) {
        node = findNode(label);
        if (node == null) {
            addNode(label);
            node = findNode(label);
        } return;
    }

    public void addEdge(Label l1, Label l2) {
        GraphNode node1 = findNode(l1);
        GraphNode node2 = findNode(l2);
        if (node1 != null && node2 != null) {
            node1.edges.add(node2);
            node2.edges.add(node1);
        }
    }

    public void print() {
        GraphNode<Label> node = headNode;
        while (node != null) {
            System.out.print("[ " + node.id + " : ");
            for (GraphNode<Label> neighbor : node.edges) {
                System.out.print(neighbor.id + " ");
            }
            System.out.println("]");
            node = node.next;
        }
    }

    public static void main(String[] args) {

    }

}