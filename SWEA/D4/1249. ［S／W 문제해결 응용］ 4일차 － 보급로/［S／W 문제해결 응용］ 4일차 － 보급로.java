import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	
	static int N;
	static int INF = 2147483647;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map;
	
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int time;
		
		public Point(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			return (Integer.compare(this.time, o.time));
		}
	}
	
	static int dijkstra(int startx, int starty)
	{
		int[][] minTime = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < N; ++i)
		{
			for (int j = 0; j < N; ++j)
			{
				minTime[i][j] = INF;
			}
		}
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		minTime[startx][starty] = 0;
		pq.offer(new Point(startx, starty, minTime[startx][starty]));
		
		while (!pq.isEmpty())
		{
			Point stopOver = pq.poll();
			int r = stopOver.r;
			int c = stopOver.c;
			int totaltime = stopOver.time;
			
			if (visited[r][c])
				continue;
			
			visited[r][c] = true;
			
			if (r == N - 1 && c == N - 1) // 목적지 도착
			{
				return totaltime;
			}
			
			for (int d = 0; d < 4; d++)
			{
				int nr = r + dx[d];
				int nc = c + dy[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				
				if (!visited[nr][nc] && minTime[nr][nc] > totaltime + map[nr][nc])
				{
					minTime[nr][nc] = totaltime + map[nr][nc];
					pq.offer(new Point(nr, nc, minTime[nr][nc]));
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc)
		{
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; ++i)
			{
				String str = br.readLine();
				for (int j = 0; j < N; ++j)
				{
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			sb.append("#" + tc + " " + dijkstra(0, 0) + "\n");
		}
		System.out.println(sb);
	}
}