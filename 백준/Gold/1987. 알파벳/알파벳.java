import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static int max = 0;
	static int[][] arr;
	
	private static void dfs(int i, int j, boolean[] visited, int count)
	{
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		for (int k = 0; k < 4; ++k)
		{
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[arr[nx][ny]])
			{
				visited[arr[nx][ny]] = true;
				dfs(nx, ny, visited, count + 1);
				visited[arr[nx][ny]] = false;
			}
		}
		if (count > max)
			max = count;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		boolean[] visited = new boolean[26];
		
		for (int i = 0; i < R; ++i)
		{
			String str = br.readLine();
			for (int j = 0; j < C; ++j)
			{
				arr[i][j] = str.charAt(j) - 'A';
			}
		}
		
		visited[arr[0][0]] = true;
		dfs(0, 0, visited, 1);
		
		System.out.println(max);
	}
}
