import java.util.*;

public class Djikstra {
    public static <Label> List<Label> djikstraPath(GraphList<Label> graph, Label start, Label end) {

        Map<Label, Double> distance = new HashMap<>();
        Map<Label, Label> previousStation = new HashMap<>();
        Map<Label, String> previousLine = new HashMap<>();
        // use a priority queue to search by the best distance
        PriorityQueue<Label> prioQueue = new PriorityQueue<>(Comparator.comparingDouble(distance::get));

        GraphList<Label>.GraphNode node = graph.headNode;

        while (node != null) {
            distance.put(node.id, Double.POSITIVE_INFINITY);
            previousStation.put(node.id, null);
            previousLine.put(node.id, null);
            node = node.next;
        }

        distance.put(start, 0.0);
        prioQueue.add(start);

        // the main loop of pain and suffering and dutch algorithmyicspeople

        while (!prioQueue.isEmpty()) {
            Label u = prioQueue.poll();

            if (u.equals(end)) {
                break; // as we have reached the end
            }

            GraphList<Label>.GraphNode uNode = graph.findNode(u);
            if (uNode == null)
                continue;

            for (GraphList<Label>.GraphNode neighbour : uNode.edges) {
                Label v = neighbour.id;

                double baseWeight = graph.getWeight(u, v);
                String lineUV = graph.getLine(u, v);
                String prev = previousLine.get(u);

                // adding in the line changes
                double lineChange = 0.0;

                if (prev != null && !prev.equalsIgnoreCase(lineUV)) {
                    lineChange = 2.0;
                }

                double newDistance = distance.get(u) + baseWeight + lineChange;

                if (newDistance < distance.get(v)) {
                    distance.put(v, newDistance);
                    previousStation.put(v, u);
                    previousLine.put(v, lineUV);
                    prioQueue.add(v);
                }

            }

        }

        // path reconstruction

        List<Label> path = new ArrayList<>();
        Label step = end;

        if (previousStation.get(step) == null && !step.equals(start)) {
            return path;
        }

        while (step != null) {
            path.add(step);
            step = previousStation.get(step);
        }

        Collections.reverse(path);// as it is bidirectional you also reverse it
        return path;

    }

    public static <Label> double computeJourneyTime(GraphList<Label> graph, List<Label> path) {
        double total = 0;

        for (int i = 0; i < path.size() - 1; i++) {
            Label a = path.get(i);
            Label b = path.get(i + 1);

            total += graph.getWeight(a, b);

            if (i > 0) {
                String previousLine = graph.getLine(path.get(i - 1), a);
                String nextLine = graph.getLine(a, b);
                if (previousLine != null && nextLine != null && !previousLine.equals(nextLine)) {
                    total += 2;
                }
            }

        }
        return total;
    }

    public static <Label> List<String> computeLineInstructions(GraphList<Label> graph, List<Label> path) {
        List<String> out = new ArrayList<>();
        if (path.size() < 2)
            return out;
        String currentLine = graph.getLine(path.get(0), path.get(1));

        out.add("Start your journey on the " + currentLine + " line at " + path.get(0));

        for (int i = 1; i < path.size() - 1; i++) {
            String previousLine = graph.getLine(path.get(i - 1), path.get(i));

            String nextLine = graph.getLine(path.get(i), path.get(i + 1));

            if (previousLine != null && nextLine != null && !previousLine.equals(nextLine)) {
                out.add("Change for the " + nextLine + " line at " + path.get(i));
            }
        }
        return out;
    }

    public static void main(String[] args) {
        // System.out.println("Djikstra's algorithm is one of the algorithms of all
        // tim"); // yes
    }
}
