
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
	
	static void kmpProcessing(int[] pattern, int[] text)
	{
		int idx = 0;
		int len = 0;
		
		while (idx < N * 2 - 1)
		{
			if (text[idx] == pattern[len])
			{
				len ++;
				idx ++;
				
				if (len == N)
				{
					len = lps[len - 1];
					count ++;
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
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        int[] pattern = new int[N];
        int[] text = new int[2 * N - 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i){
            pattern[i] = st.nextToken().charAt(0) - 'A';
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i){
            text[i] = st.nextToken().charAt(0) - 'A';
        }
        for (int i = N; i < 2 * N - 1; ++i){
            text[i] = text[i - N];
        }
        
        lps = new int[N];
        lpsProcessing(pattern);
        kmpProcessing(pattern, text);
        
        int resN = N;
        int resCount = count;

        int i = count;
        while (resCount > 1)
        {
        	if (resN % i == 0 && resCount % i == 0)
        	{
        		resN = resN / i;
        		resCount = resCount / i;
        	}
        	else
        	{
        		i --;
        	}
        }
        System.out.println(resCount + "/" + resN);
    }
}
