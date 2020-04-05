import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPath2 {
	public static int findShortestPath(Graph g, int start, int stop) {
        int count = 0;
        Queue <Integer> toVisit = new LinkedList<>();
        Set <Integer> alreadyVisited = new HashSet<>();

        Map <Integer, Integer> parent = new HashMap<>();
        alreadyVisited.add(start);
        toVisit.add(start);

        parent.put(start, null);
        while(!toVisit.isEmpty()) {
            int cur = toVisit.poll();
            if(cur == stop) {
                Integer at = cur;
                while(at != null) {
                    count++;
                    at = parent.get(at);
                }
                return count - 1;
            }
            for(int e : g.getEdges(cur)) {
                if(!alreadyVisited.contains(e)) {
                    parent.put(e, cur);
                    alreadyVisited.add(e);
                    toVisit.offer(e);
                }
            }
        }
        return -1;
    }
}