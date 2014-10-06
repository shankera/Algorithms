
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Random;

public class Driver {
	static LinkedList<Edge> edges;
	static int wArr[];
	static int pArr[];
	static int numVertices;
	static int size;
	static int sourceVertex = 0;

	public static void main(String[] args){
		File file = new File("times.txt");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
			edges = new LinkedList<Edge>();
			test();
			for(int x = 5; x < 505; x++){
				genGraph(x);
				long t1 = System.nanoTime();
				doStuff();
				long t2 = System.nanoTime();
				writer.println(t2-t1);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	private static void doStuff(){
		size = edges.size();
		wArr = new int[numVertices];
		pArr = new int[numVertices];
		relax();
	}
	private static void genGraph(int seed){
		edges = new LinkedList<Edge>();
		Random rand = new Random();
		numVertices = seed;
		int other;
		for(int x = 0; x < numVertices; x++){
			other = rand.nextInt(numVertices);
			edges.add(new Edge(x, other, rand.nextInt(10)));
			edges.add(new Edge(other, x, rand.nextInt(10)));
		}
	}
	private static void test(){

		numVertices = 7;
		graphCreator();
		doStuff();
		if(cycle()){
			for(int x = 0; x < numVertices; x++){
				System.out.println(sourceVertex + " --> " + wArr[x]);
			}
		}
		print();
	}
	private static void graphCreator(){
		edges.add(new Edge(0,1,1));
		edges.add(new Edge(0,2,3));
		edges.add(new Edge(0,6,5));
		edges.add(new Edge(1,0,1));
		edges.add(new Edge(1,2,1));
		edges.add(new Edge(1,5,7));
		edges.add(new Edge(1,6,1));
		edges.add(new Edge(2,0,3));
		edges.add(new Edge(2,1,1));
		edges.add(new Edge(2,3,2));
		edges.add(new Edge(2,4,1));
		edges.add(new Edge(3,2,2));
		edges.add(new Edge(3,4,5));
		edges.add(new Edge(4,2,1));
		edges.add(new Edge(4,3,5));
		edges.add(new Edge(5,1,7));
		edges.add(new Edge(5,6,4));
		edges.add(new Edge(6,0,5));
		edges.add(new Edge(6,1,1));
		edges.add(new Edge(6,5,4));
	}
	private static void relax(){
		for(int i = 0; i<numVertices; i++){
			wArr[i] = Integer.MAX_VALUE;
			pArr[i] = -1;
		}
		wArr[sourceVertex]=0;
		for(int i = 0; i < numVertices-1; i++){
			for(int j = 0; j < size; j++){
				if(wArr[edges.get(j).u] + edges.get(j).weight < wArr[edges.get(j).v]){
					wArr[edges.get(j).v] = wArr[edges.get(j).u] + edges.get(j).weight;
					pArr[edges.get(j).v] = edges.get(j).u;
				}
			}
		}
	}
	private static boolean cycle(){
		for(int x = 0; x< size; x++){
			if(wArr[edges.get(x).u] + edges.get(x).weight < wArr[edges.get(x).v]){
				return false;
			}
		}
		return true;
	}
	private static void print(){
		for(int x = 0; x < numVertices; x++){
			System.out.println("Vertex " + x + " preceded by " + pArr[x]);
		}
	}
}
