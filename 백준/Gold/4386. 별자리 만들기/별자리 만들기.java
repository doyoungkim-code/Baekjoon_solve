import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	static Coord[] coordList;
	
	static class Edge implements Comparable<Edge>{
		int n;
		double weight;
		
		public Edge(int n, double weight) {
			super();
			this.n = n;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return (Double.compare(this.weight, o.weight));
		}
	}
	
	static class Coord {
		double x;
		double y;
		
		public Coord(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        coordList = new Coord[n];
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; ++i)
        {
        	st = new StringTokenizer(br.readLine());
        	double a = Double.parseDouble(st.nextToken());
        	double b = Double.parseDouble(st.nextToken());
        	
        	coordList[i] = new Coord(a, b);
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        
        double result = 0;
        while (!pq.isEmpty())
        {
        	Edge e = pq.poll();
        	
        	if (visited[e.n])
        		continue;
        	
        	visited[e.n] = true;
        	result += e.weight;
        	for (int i = 0; i < n; ++i)
        	{
        		if (!visited[i])
        		{
        			double dx = (coordList[i].x - coordList[e.n].x);
        			double dy = (coordList[i].y - coordList[e.n].y);
        			
        			double dist = Math.sqrt((dx * dx) + (dy * dy));
        			pq.add(new Edge(i, dist));
        		}
        	}
        }
        System.out.println(result);
    }
}