import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] arr = new long[n + 1];
		
		arr[0] = 1;
		arr[1] = 0;

		
		if (n >= 2)
		{
			arr[2] = 3;
		}
		
		for (int i = 3; i <= n; ++i)
		{
			arr[i] = arr[i - 2] * arr[2];
			
			for (int j = 4; j <= i; j += 2)
			{
				arr[i] = arr[i] + arr[i - j] * 2;
			}
		}
		
		System.out.println(arr[n]);
		sc.close();
	}
}