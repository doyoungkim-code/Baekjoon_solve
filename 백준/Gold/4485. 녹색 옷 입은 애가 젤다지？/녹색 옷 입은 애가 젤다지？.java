import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int INF = 2147483647;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};	
	static int[][] map;
	
	static class Point implements Comparable<Point> {
		int x;
		int y;
		int rupee;
				
		public Point(int x, int y, int rupee) {
			super();
			this.x = x;
			this.y = y;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return (Integer.compare(this.rupee, o.rupee));
		}
	}
	
	static int dijikstra(int startX, int startY)
	{
		int[][] minRupee = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < N; ++i)
		{
			for (int j = 0; j < N; ++j)
			{
				minRupee[i][j] = INF;
			}
		}
		
		minRupee[startX][startY] = map[startX][startY];
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		pq.offer(new Point(startX, startY, minRupee[startX][startY]));
		
		while (!pq.isEmpty())
		{
			Point pollData = pq.poll();
			int x = pollData.x;
			int y = pollData.y;
			int rupee = pollData.rupee;
			
			if (visited[x][y])
				continue;
			
			visited[x][y] = true;
			
			if (x == N - 1 && y == N - 1)
			{
				return rupee;
			}
			
			for (int d = 0; d < 4; ++d)
			{
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= N || nx < 0 || ny >= N || ny < 0)
					continue;
				
				if (!visited[nx][ny] && minRupee[nx][ny] > map[nx][ny] + rupee)
				{
					minRupee[nx][ny] = map[nx][ny] + rupee;
					pq.offer(new Point(nx, ny, minRupee[nx][ny]));
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = 1;
		
		while(true)
		{
			N = Integer.parseInt(br.readLine());
			
			if (N == 0)
				break;
			map = new int[N][N];
			
			for (int i = 0; i < N; ++i)
			{
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("Problem " + tc + ": " + dijikstra(0, 0) + "\n");
			tc ++;
		}
		System.out.println(sb);
	}
}