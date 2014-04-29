import java.util.HashMap;


public class Node {
	private String name;
	private HashMap<Node, Integer> edges = new HashMap<Node, Integer>();
	
	public Node(String name){
		this.name = name;
	}
	public void addEdge(Node n, int weight){
		if(!edges.containsKey(n)){
			edges.put(n, weight);
			
		}
		else{
			System.out.println("Error adding node " + n);
		}
	}
	public HashMap<Node, Integer> getEdges(){
		return edges;
	}
	public String toString(){
		return name;
	}
}
