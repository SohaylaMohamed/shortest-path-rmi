import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.LinkedHashSet;
import java.util.List;

public class ShortestPath {
    private static LinkedHashSet<Integer> out = new LinkedHashSet<Integer>();
    private static LinkedHashSet<Integer> traversedNodes = new LinkedHashSet<Integer>();

    static int findShortestPath(Graph g, int node1, int node2, int knownLength) {
        int minLen = Integer.MAX_VALUE;
        LinkedHashSet<Integer> minPath = new LinkedHashSet<Integer>();

        if (!traversedNodes.contains(node1)) {
            traversedNodes.add(node1);

            if (node1 != node2) {
                for (int i =0; i < g.getEdges(node1).size(); i++) {
                    int len = findShortestPath(g, g.getEdges(node1).get(i), node2, knownLength + 1);
                    if (len < minLen) {
                        minLen = len;
                        minPath.clear();
                        minPath.addAll(out);
                    }
                }
            } else {
                minLen = knownLength + 1;
                minPath.addAll(traversedNodes);
            }

            if (minPath.size() > 0) {
                out.clear();
                out.addAll(minPath);
            }
            traversedNodes.remove(node1);
        }
        return minLen;
    }

    static int getResult(int i) {
        if (i != Integer.MAX_VALUE) {
            return i-1;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) throws RemoteException {
        Graph g = new Graph();

        try {
            List<String> allLines = Files.readAllLines(Paths.get("input.txt"));
            for (String line : allLines) {
                if(!line.equals("S")){
                    char[] parts = line.toCharArray();
                    g.addEdge(Integer.parseInt(Character.toString(parts[0])),
                            Integer.parseInt(Character.toString(parts[2])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("output.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            List<String> allLines = Files.readAllLines(Paths.get("batch1.txt"));
            for (String line : allLines) {
                if(!line.equals("F")){
                    char[] parts = line.toCharArray();
                    char operation = parts[0];
                    int s = Integer.parseInt(Character.toString(parts[2]));
                    int e = Integer.parseInt(Character.toString(parts[4]));
                    switch (operation) {
                        case 'A':
                            g.addEdge(s, e);
                            break;
                        case 'Q':
                            pr.println(getResult(findShortestPath(g,s, e, 0)));

                            break;
                        case 'D':
                            g.removeEdge(s, e);
                            break;
                        default:
                            System.out.println("Error in batch file");

                    }
                }
            }
            pr.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
