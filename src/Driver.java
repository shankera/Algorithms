
public class Driver {
	private static Node[] graph = new Node[7]; 
	public static void main(String[] args){
		for(int x = 0; x < graph.length; x++){
			graph[x] = new Node("N"+x);
		}
		graphCreator();
		
		
		//Create list of nodes
		//Create connections between nodes
		//N0, N1, N2, N3, N4, N5, N6
		//find shortest path between two nodes > k
		//k is a specified value
		//MINIMUM total SUM OF EDGE WITHGS among all possible S to T paths
		//with no more than K edges
	
	}
	private static void graphCreator(){
		graph[0].addEdge(graph[1], 1);
		graph[0].addEdge(graph[2], 3);
		graph[0].addEdge(graph[6], 5);
		graph[1].addEdge(graph[0], 2);
		graph[1].addEdge(graph[2], 1);
		graph[1].addEdge(graph[5], 7);
		graph[1].addEdge(graph[6], 1);
		graph[2].addEdge(graph[0], 3);
		graph[2].addEdge(graph[1], 2);
		graph[2].addEdge(graph[3], 2);
		graph[2].addEdge(graph[4], 1);
		graph[3].addEdge(graph[2], 4);
		graph[3].addEdge(graph[4], 5);
		graph[4].addEdge(graph[2], 2);
		graph[4].addEdge(graph[3], 1);
		graph[5].addEdge(graph[1], 3);
		graph[5].addEdge(graph[6], 4);
		graph[6].addEdge(graph[0], 6);
		graph[6].addEdge(graph[1], 1);
		graph[6].addEdge(graph[5], 2);
	}
}
