import java.io.IOException;
import java.util.*;

/**
 * MarvelPaths is a class that reads in data from a given file, builds a graph
 * from the data in the file, and finds paths between two data points.
 */
public class MarvelPaths {

    /**
     * @param filename the file that will be read
     * @spec.requires filename cannot be null
     * @spec.effects constructs a directed graph using information about
     *               all the characters and their connections contained in the given file
     * @return a directed graph that layouts how characters are connected through
     *         different comics in the Marvel universe
     */
    public static MapGraph<String, String> buildPaths(String filename) {
        assert(filename != null): "filename cannot be null";

        Map<String, Set<String>> comicToChars = new HashMap<>();
        MapGraph<String, String> marvelGraph = new MapGraph<>();

        // read in data from MarvelParser
        try {
            comicToChars = MarvelParser.parseData(filename);
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        // create and add edges
        for(String comic : comicToChars.keySet()) {
            // create directed edges between each pair of nodes
            for(String name1 : comicToChars.get(comic)) {
                // add nodes
                if(!marvelGraph.containsNode(name1)) {
                    marvelGraph.addNode(name1);
                }
                // add directed edges
                for(String name2 : comicToChars.get(comic)) {
                    if(!name1.equals(name2)) {
                        marvelGraph.addEdge(new Edge<>(name1, name2, comic));
                    }
                }
            }
        }
        return marvelGraph;
    }

    /**
     * Uses BFS to find the lexicographically shortest path between two given nodes.
     *
     * @param firstChar the first character to find path for
     * @param secondChar the second character to find path for
     * @param marvelGraph the graph to find path in
     * @spec.requires firstChar and secondChar and marvelGraph cannot be null and
     *                the two characters must be contained in the graph
     * @return the path with least number of edges between the given characters;
     *         returns null if no path exist between the characters
     */
    public static List<Edge<String, String>> findPath(String firstChar, String secondChar,
                                                      MapGraph<String, String> marvelGraph) {
        Queue<String> toVisit = new LinkedList<>();
        Map<String, List<Edge<String, String>>> paths = new HashMap<>();
        toVisit.add(firstChar);
        paths.put(firstChar, new ArrayList<>());

        while(!toVisit.isEmpty()) {
            String currentChar = toVisit.remove();
            if(currentChar.equals(secondChar)) {
                return paths.get(currentChar);
            }
            // Sort in lexicographic order
            // e.g. [acb, abd, abc] -> [abc, abd, acb]
            List<Edge<String, String>> children = marvelGraph.getChildren(currentChar);
            Collections.sort(children, (Comparator<Edge<String, String>>) (e1, e2) -> {
                if(e1.getTo().equals(e2.getTo())) {
                    return e1.getLabel().compareTo(e2.getLabel());
                }
                return e1.getTo().compareTo(e2.getTo());
            });
            // Explore outgoing edge from the current node
            // Explore by layers not by path:
            //      |    |    |
            // x -> | -> | -> |
            //      |    |    |
            for(Edge<String, String> path : children) {
                if(!paths.containsKey(path.getTo())) {
                    paths.put(path.getTo(), new ArrayList<>(paths.get(currentChar)));
                    paths.get(path.getTo()).add(path);
                    toVisit.add(path.getTo());
                }
            }
        }
        return null;
    }
}
