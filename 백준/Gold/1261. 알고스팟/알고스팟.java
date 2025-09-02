import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int INF = 2147483647;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] map;
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int totalWall;
		
		public Point(int x, int y, int totalWall) {
			super();
			this.x = x;
			this.y = y;
			this.totalWall = totalWall;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return (Integer.compare(this.totalWall, o.totalWall));
		}
	}
	
	static int dijkstra(int startX, int startY)
	{
		int[][] minWall = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for (int i = 0; i < N; ++i)
		{
			for (int j = 0; j < M; ++j)
			{
				minWall[i][j] = INF;
			}
		}
		minWall[startX][startY] = 0;
		
		PriorityQueue <Point> dq = new PriorityQueue<>();
		
		dq.offer(new Point(startX, startY, minWall[startX][startY]));
		
		while (!dq.isEmpty())
		{
			Point pollData = dq.poll();
			int x = pollData.x;
			int y = pollData.y;
			int totalWall = pollData.totalWall;
			
			if (visited[x][y])
				continue;
			
			visited[x][y] = true;
			
			if (x == N - 1 && y == M - 1)
			{
				return totalWall;
			}
			
			for (int d = 0; d < 4; ++d)
			{
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= N || nx < 0 || ny >= M || ny < 0)
					continue;
				
				if (!visited[nx][ny] && minWall[nx][ny] > totalWall + map[nx][ny])
				{
					minWall[nx][ny] = totalWall + map[nx][ny];
					dq.offer(new Point(nx, ny, minWall[nx][ny]));			
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; ++i)
		{
			String str = br.readLine();
			
			for (int j = 0; j < M; ++j)
			{
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(dijkstra(0, 0));
	}
	
}