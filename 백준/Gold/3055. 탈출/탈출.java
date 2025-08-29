import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int min = 100000;
	static int R;
	static int C;
	static int[][] map;
	static Coord goseumdochi;
	static Coord veever;
	
	static class Coord{
		int x;
		int y;
		
		public Coord(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	static void waterFall()
	{
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		boolean[][] visited = new boolean[R][C];
		
		for (int i = 0; i < R; ++i)
		{
			for (int j = 0; j < C; ++j)
			{
				if (map[i][j] == 1 && !visited[i][j])
				{
					visited[i][j] = true;
					for (int k = 0; k < 4; ++k)
					{
						int ni = i + dx[k];
						int nj = j + dy[k];
						
						if (ni >= R || ni < 0 || nj >= C || nj < 0)
							continue ;
						
						if (!visited[ni][nj] && map[ni][nj] == 0)
						{
							visited[ni][nj] = true;
							map[ni][nj] = 1;
						}
					}
				}
			}
		}
	}
	
	static void bfs()
	{
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		
		int[][] visited = new int[R][C];
		ArrayDeque<Coord> dq = new ArrayDeque<>();
		
		visited[goseumdochi.x][goseumdochi.y] = 1;
		dq.add(goseumdochi);
		
		while (!dq.isEmpty())
		{
			waterFall();
			
			int turnSize = dq.size();
			
			for (int i = 0; i < turnSize; i++)
			{
				Coord pollData = dq.poll();
				
				for (int k = 0; k < 4; ++k)
				{
					int nx = pollData.x + dx[k];
					int ny = pollData.y + dy[k];
					
					if (nx >= R || nx < 0 || ny >= C || ny < 0)
						continue ;
					
					if (visited[nx][ny] == 0 && map[nx][ny] == 0)
					{
						visited[nx][ny] = visited[pollData.x][pollData.y] + 1;
						dq.add(new Coord(nx, ny));
					}
					if (visited[nx][ny] == 0 && map[nx][ny] == 3)
					{
						visited[nx][ny] = visited[pollData.x][pollData.y] + 1;
						if (min > visited[nx][ny] - 1)
							min = visited[nx][ny] - 1;
						return;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int i = 0; i < R; ++i)
		{
			String temp = br.readLine();
			for (int j = 0; j < C; ++j)
			{
				char c = temp.charAt(j);
				if (c == '.')
					map[i][j] = 0;
				else if (c == '*')
					map[i][j] = 1;
				else if (c == 'X')
					map[i][j] = 2;
				else if (c == 'D')
				{
					map[i][j] = 3;
					veever = new Coord(i, j);
				}
				else if (c == 'S')
				{
					map[i][j] = 4;
					goseumdochi = new Coord(i, j);
					
				}
			}
		}
		
		bfs();
		if (min == 100000)
			System.out.println("KAKTUS");
		else
			System.out.println(min);
	}
}