import java.io.*;
import java.util.*;

class Solution {
    
    public int n;
    public int m;
    public int[][] map;
    public int[] dx = {0, -1, 0, 1};
    public int[] dy = {1, 0, -1, 0};
    
    public int bfs()
    {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            int a = cur[0];
            int b = cur[1];
            
            if (a == n - 1 && b == m - 1)
                return dist[a][b];
            
            for (int d = 0; d < 4; ++d)
            {
                int rx = a + dx[d];
                int ry = b + dy[d];
                
                if (rx < 0 || rx >= n || ry < 0 || ry >= m)
                    continue;
                if (map[rx][ry] == 0 || dist[rx][ry] != 0)
                    continue;
                
                dist[rx][ry] = dist[a][b] + 1;
                q.offer(new int[]{rx, ry});
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        map = maps;
        
        n = map.length;
        m = map[0].length;
        
        return bfs();
    }
}