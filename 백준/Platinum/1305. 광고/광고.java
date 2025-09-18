
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	static int N;
	static int count;
	static int[] lps;
	
	static void lpsProcessing(int[] pattern)
	{
		int idx = 1;
		int len = 0;
		
		lps[0] = 0;
		
		while (idx < N)
		{
			if (pattern[idx] == pattern[len])
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        int[] pattern = new int[N];
        
        String str = br.readLine();
        for (int i = 0; i < N; ++i){
            pattern[i] = str.charAt(i) - 'a';
        }
        
        lps = new int[N];
        lpsProcessing(pattern);
        System.out.println(N - lps[N - 1]);
    }
}
