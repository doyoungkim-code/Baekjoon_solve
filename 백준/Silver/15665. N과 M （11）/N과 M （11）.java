import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	private static void dfs(int depth)
	{
		if (depth == M)
		{
			for (int i = 0; i < M; ++i)
			{
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			
			return ;
		}
		
		int temp = -1;
		for (int i = 0; i < N; ++i)
		{
			if (arr[i] != temp)
			{
				temp = arr[i];
				result[depth] = arr[i];
				dfs(depth + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
		System.out.println(sb);
	}

}
