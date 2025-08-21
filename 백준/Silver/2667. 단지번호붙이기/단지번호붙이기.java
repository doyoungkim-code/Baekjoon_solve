import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int N;
	static int count;
	static int danjiNum;
	static ArrayList<Integer> result;
	static int[][] arr;
	
	private static void dfs(int i, int j, int num)
	{
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for (int k = 0; k < 4; ++k)
		{
			if (i + dx[k] >= 0 && i + dx[k] < N && j + dy[k] >= 0 && j + dy[k] < N)
			{
				if (arr[i + dx[k]][j + dy[k]] == 1)
				{
					count ++;
					arr[i + dx[k]][j + dy[k]] = num;	
					dfs(i + dx[k], j + dy[k], num);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		result = new ArrayList<>();
		
		for (int i = 0; i < N; ++i)
		{
			String str = br.readLine();
			for (int j = 0; j < N; ++j)
			{
				arr[i][j] = (str.charAt(j) - '0');
			}
		}
		
		int num = 2;
		for (int i = 0; i < N; ++i)
		{
			for (int j = 0; j < N; ++j)
			{
				if (arr[i][j] == 1)
				{
					arr[i][j] = num;
					dfs(i, j, num);
					result.add(count + 1);
					count = 0;
					danjiNum ++;
					num ++;
				}
			}
		}
		Collections.sort(result);
		System.out.println(danjiNum);
		for (int i = 0; i < result.size(); ++i)
		{
			System.out.println(result.get(i));
		}
	}
}
