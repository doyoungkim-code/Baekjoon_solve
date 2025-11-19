import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		long T = Long.parseLong(st.nextToken());
		long S = Long.parseLong(st.nextToken());

		long resZip = 0;
		long resDok = 0;
		
		if (N / 8 == 0)
			resZip = N;
		else
		{
			long b;
			if (N % 8 == 0)
				b = (N / 8) - 1;
			else
				b = N / 8;
			
			resZip = N + b * S;
		}
		
		if (M / 8 == 0)
			resDok =  T + M;
		else
		{
			long b;
			if (M % 8 == 0)
				b = (M / 8) - 1;
			else
				b = M / 8;
			
			resDok = T + M + b * (2 * T + S);
		}

		System.out.println(Long.compare(resZip, resDok) < 0 ? "Zip" : "Dok");
		System.out.println(Long.min(resZip, resDok));
	}

}
