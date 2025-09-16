import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int result;
	static List <Integer> idxResult;
	static int[] lps;
	
	static void partTable(String pattern){
		
		int size = pattern.length();
		
		int idx = 1;
		int len = 0;
		
		lps[0] = 0;
		while (idx < size)
		{
			if (pattern.charAt(idx) == pattern.charAt(len))
			{
				len ++;
				lps[idx] = len;
				idx ++;
			}
			else
			{
				if (len != 0)
				{
					len = lps[len - 1];
				}
				else
				{
					lps[idx] = 0;
					idx ++;
				}
			}
			
		}
	}
	
	static void kmpAlgorithm(String text, String pattern) {
		
		int textSize = text.length();
		int patternSize = pattern.length();
		
		int idx = 0;
		int len = 0;
		
		while (idx < textSize)
		{
			if (text.charAt(idx) == pattern.charAt(len))
			{
				idx ++;
				len ++;
				if (len == patternSize)
				{
					result ++;
					idxResult.add(idx - patternSize + 1);
					len = lps[len - 1];
				}
			}
			else
			{
				if (len != 0)
				{
					len = lps[len - 1];
				}
				else
				{
					idx ++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine();
		String pattern = br.readLine();

		lps = new int[pattern.length()];
		idxResult = new ArrayList<>();
		
		partTable(pattern);
		kmpAlgorithm(text, pattern);
		System.out.println(result);
		for (int idx : idxResult)
			System.out.print(idx + " ");
	}

}
