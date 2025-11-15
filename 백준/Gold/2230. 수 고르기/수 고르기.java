import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; ++i)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = 1;
		int min = 2147483647;
		
		while (left <= right)
		{
			if (left == right)
			{
				right ++;
			}
			
			if (right > N - 1)
				break;
			
			int diff = arr[right] - arr[left];
			
			if (diff >= M && min > diff)
			{
				min = diff;
				left ++;
			}
			else if (diff < M)
			{
				right ++;
			}
			else
				left ++;
		}
		System.out.println(min);
	}

}
