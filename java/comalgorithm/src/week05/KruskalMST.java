package week05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class KruskalMST {
	
	
	
	public static void main(String[] args) {
		
		int[] weight = {1, 1, 2, 2, 3, 4, 4, 7, 8, 9};
		char[] v1s = {'B', 'C','B','A','D','A','B','D','A','E'};
		char[] v2s = {'C','F','F','D','E','E','D','F','B','F'};
		
		HashSet<Character> vertices = new HashSet<Character>();
		for(int i = 0; i < v1s.length; i++) {
			vertices.add(v1s[i]);
			vertices.add(v2s[i]);
		}
		System.out.println(vertices.size());
		
		ArrayList<Edge> L = new ArrayList<Edge>();
		
		for(int i = 0; i <weight.length; i++) {
			L.add(new Edge(weight[i], v1s[i], v2s[i]));
		}
		
		Comparator<Edge> comparator = new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {

				
				return o1.weight - o2.weight;
			}
		};
		
	 	Collections.sort(L , comparator);
	 	
		System.out.println(L);
		
		HashSet<Edge> T = new HashSet<Edge>();
		
		while(T.size() < vertices.size() - 1) {
			Edge tmp = L.remove(0);
			if(isNotCyclic(T,tmp)) {
				T.add(tmp);
			}
		}
		
		System.out.println(T);
	}

	private static boolean isNotCyclic(HashSet<Edge> T, Edge tmp) {
		HashSet<Character> visited = new HashSet<Character>();
	    visited.add(tmp.v1);
	    visited.add(tmp.v2);
	    for (Edge e : T) {
	        if (visited.contains(e.v1) && visited.contains(e.v2)) {
	            return false;
	        }
	        if (visited.contains(e.v1)) {
	            visited.add(e.v2);
	        } else if (visited.contains(e.v2)) {
	            visited.add(e.v1);
	        }
	    }
	    return true;
	}
}

class Edge {
	
	int weight;
	char v1;
	char v2;
	
	
	
	public Edge(int weight, char v1, char v2) {
		this.weight = weight;
		this.v1 = v1;
		this.v2 = v2;
	}



	@Override
	public String toString() {
		return "[" + v1 + "(" + weight + ")" + v2 + "]";
	}
	
	
}


