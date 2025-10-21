import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int size;
	static int min = 2147483647;
	static int[][] map;
	static boolean[][] sight;
	static final int[] dx = {0, -1, 0, 1};
	static final int[] dy = {1, 0, -1, 0};
	static List <CCTV> cctvList;
	
	static class CCTV {
		int x;
		int y;
		int mode;
		
		public CCTV(int x, int y, int mode) {
			super();
			
			this.x = x;
			this.y = y;
			this.mode = mode;
		}
	}
	
	static void mainLogic(int x, int y, int dir) {
		int d = dir % 4;
		int k = 0;
		
		while (true)
		{
			int nx = x + dx[d] * k;
			int ny = y + dy[d] * k;
			
			if (nx >= N || nx < 0 || ny >= M || ny < 0)
				break;
			
			if (map[nx][ny] == 6)
				break;
			
			sight[nx][ny] = true;
			k ++;
		}
	}
	
	static void backTracking(int depth) {
		if (depth == size)
		{
			int res = 0;
			
			for (int i = 0; i < N; ++i)
			{
				for (int j = 0; j < M; ++j)
				{
					if (!sight[i][j] && map[i][j] == 0)
						res ++;
				}
			}
			
			if (res < min)
				min = res;
			
			return;
		}
		
		CCTV nowCCTV = cctvList.get(depth);
		int x = nowCCTV.x;
		int y = nowCCTV.y;
		int mode = nowCCTV.mode;
		
		for (int dir = 0; dir < 4; ++dir)
		{
			boolean[][] temp = new boolean[N][M];
			for (int i = 0; i < N; ++i)
			{
				for (int j = 0; j < M; ++j)
				{
					temp[i][j] = sight[i][j];
				}
			}
			
			switch (mode) {
			case 1:
			{
				mainLogic(x, y, dir);
				break;
			}
			case 2:
			{
				mainLogic(x, y, dir);
				mainLogic(x, y, dir + 2);
				break;
			}
			case 3:
			{
				mainLogic(x, y, dir);
				mainLogic(x, y, dir + 3);
				break;
			}
			case 4:
			{
				mainLogic(x, y, dir);
				mainLogic(x, y, dir + 2);
				mainLogic(x, y, dir + 3);
				break;
			}
			case 5:
			{
				mainLogic(x, y, dir);
				mainLogic(x, y, dir + 1);
				mainLogic(x, y, dir + 2);
				mainLogic(x, y, dir + 3);
				break;
			}
			default :
				break;
			}
			
			backTracking(depth + 1);
			
			sight = temp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cctvList = new ArrayList<>();
		map = new int[N][M];
		sight = new boolean[N][M];
		
		for (int i = 0; i < N; ++i)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5)
					cctvList.add(new CCTV(i, j, map[i][j]));
			}
		}
		
		size = cctvList.size();
		backTracking(0);
		System.out.println(min);
	}
}