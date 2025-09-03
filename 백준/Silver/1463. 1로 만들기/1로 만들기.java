import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];
		
		arr[1] = 0;
		if (N >= 2)
			arr[2] = 1;
		if (N >= 3)
			arr[3] = 1;
 		
		for (int i = 4; i <= N; ++i)
		{
			int min = 2147483647;
			if (i % 3 == 0 && min > arr[i / 3])
			{
				min = arr[i / 3];
				arr[i] = arr[i / 3] + 1;
			}
			if (i % 2 == 0 && min > arr[i / 2])
			{
				min = arr[i / 2];
				arr[i] = arr[i / 2] + 1;
			}
			if (min > arr[i - 1])
			{
				min = arr[i - 1];
				arr[i] = arr[i - 1] + 1;
			}
		}
		
		System.out.println(arr[N]);
	}
}
