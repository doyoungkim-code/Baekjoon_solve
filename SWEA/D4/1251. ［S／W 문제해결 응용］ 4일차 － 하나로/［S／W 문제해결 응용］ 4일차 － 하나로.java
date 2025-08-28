import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    
    static List<Edge> edgeList;
    
    static class Edge implements Comparable<Edge>{
        int to;
        long range;
        
        public Edge(int to, long range) {
            this.to = to;
            this.range = range;
        }

        @Override
        public int compareTo(Edge o) {
            return (Long.compare(this.range, o.range));
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; ++tc)
        {
            int N = Integer.parseInt(br.readLine());    
            long[] Nx = new long[N];
            long[] Ny = new long[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i)
                Nx[i] = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i)
                Ny[i] = Long.parseLong(st.nextToken());
            double E = Double.parseDouble(br.readLine());
            
            edgeList = new ArrayList<>();
            
            long totalRange = 0;
            int count = 0;
            
            boolean[] visited = new boolean[N];
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.offer(new Edge(0, 0));
            
            while (!pq.isEmpty())
            {
                Edge pollEdge = pq.poll();
                int pollEdgeTo = pollEdge.to;
                long pollEdgeRange = pollEdge.range;
                
                if (visited[pollEdgeTo])
                	continue;
                
                visited[pollEdgeTo] = true;
                totalRange += pollEdgeRange;
                count ++;
                
                for (int i = 0; i < N; ++i)
                {
                	if (!visited[i])
                	{
                		long dx = Nx[pollEdgeTo] - Nx[i];
                		long dy = Ny[pollEdgeTo] - Ny[i];
                		
                		long dist = dx * dx + dy * dy;
                		
                		pq.add(new Edge(i, dist));
                	}
                }
            }
            
            long finalRange = Math.round(totalRange * E);
            sb.append("#" + tc + " " + finalRange + "\n");
        }
        System.out.println(sb);
        
    }
}
