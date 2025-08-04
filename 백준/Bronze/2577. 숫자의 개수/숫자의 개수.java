import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int sum = A * B * C;
		int[] nums = new int[10];
		
		while (sum > 0)
		{
			nums[sum % 10] ++;
			sum = sum / 10;
		}
		for (int i : nums)
		{
			System.out.println(i);
		}
	}
}