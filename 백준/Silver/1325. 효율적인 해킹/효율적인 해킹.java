import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a); // b 해킹 -> a도 해킹됨 (역방향 저장)
        }
        
        int[] results = new int[N + 1];
        int max = 0;
        
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            int cnt = bfs(i, visited);
            results[i] = cnt;
            max = Math.max(max, cnt);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (results[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    
    static int bfs(int start, boolean[] visited) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start] = true;
        int cnt = 1;
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    dq.add(next);
                }
            }
        }
        return cnt;
    }
}
