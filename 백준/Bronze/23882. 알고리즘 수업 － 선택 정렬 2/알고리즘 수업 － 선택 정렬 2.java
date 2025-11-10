import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int count = 0;
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; ++i)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = n - 1; i >= 0; --i)
		{
			int maxIndex = 0;
			for (int j = 0; j <= i; ++j)
			{
				if (arr[j] > arr[maxIndex])
					maxIndex = j;
			}
			
			if (maxIndex != i)
			{
				int temp = arr[i];
				arr[i] = arr[maxIndex];
				arr[maxIndex] = temp;
				
				count ++;
			}
			
			if (count == k)
			{
				for (int j = 0; j < n; ++j)
				{
					System.out.print(arr[j] + " ");
				}
				return ;
			}
		}
		System.out.println("-1");
	}
}
