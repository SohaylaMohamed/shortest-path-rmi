import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph  extends UnicastRemoteObject implements IGraph, Serializable{
	
	HashMap<Integer, ArrayList<Integer>> g = new HashMap<Integer, ArrayList<Integer>>();
	HashSet<Integer> edges = new HashSet<Integer>();
	public Graph() throws RemoteException {
		super();
		g = new HashMap<Integer, ArrayList<Integer>>();
		edges = new HashSet<Integer>();
	}

	@Override
	public void addEdge(int src, int dst) {
		System.out.println("Adding edge");
		//g.get(src).add(dst);
		edges.add(src);
		edges.add(dst);
	}

	@Override
	public void removeEdge(int src, int dst) {
		g.get(src).remove(dst);
	}

	@Override
	public int getShortestPath(int src, int dst) {
		System.out.println(edges.size());
		int sum = 0;
		for (Integer n: edges) {
			sum += n;
		}
		return sum;
	}

	@Override
	public void printGraph() {
		System.out.println("Graph is");
		System.out.println(edges);
	}

}
