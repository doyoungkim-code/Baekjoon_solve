
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; ++i)
		{
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		
		Arrays.sort(arr);
		
		int sum = 0;
		int x = 0;
		int y = n - 1;
		while (x < y)
		{
			int res = arr[x] + arr[y];
			
			if (res == k)
			{
				sum ++;
				x ++;
				y --;
			}
			else if (res < k)
				x ++;
			else
				y --;
		}
		System.out.println(sum);
	}
}

