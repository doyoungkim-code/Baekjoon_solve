import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nums = new int[26];
		String str = br.readLine();
		for (int i = 0; i < 26; ++i)
		{
			nums[i] = -1;
		}
		for (int i = 0; i < str.length(); ++i)
		{
			if (nums[str.charAt(i) - 'a'] == -1)
				nums[str.charAt(i) - 'a'] = i;
		}
		for (int i = 0; i < 26; ++i)
		{
			System.out.print(nums[i] + " ");
		}
	}
}