import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; ++i)
		{
			arr[i] = i;
		}
		
		for (int m = 0; m < M; ++m)
		{
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			if (i == j)
				continue;
			
			if (i > j)
			{
				int l = i;
				for (int k = j; k <= (i + j) / 2; ++k)
				{
					int temp = arr[k];
					arr[k] = arr[l];
					arr[l] = temp;
					l --;
				}
			}
			else
			{
				int l = j;
				for (int k = i; k <= (i + j) / 2; ++k)
				{
					int temp = arr[k];
					arr[k] = arr[l];
					arr[l] = temp;
					l --;
				}
			}
		}
		
		for (int i = 1; i <= N; ++i)
		{
			System.out.print(arr[i] + " ");
		}
	}

}
