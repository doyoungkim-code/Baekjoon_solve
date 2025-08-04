import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String As = br.readLine();
		int A = Integer.parseInt(As);
		String Bs = br.readLine();
		int B = Integer.parseInt(Bs);
		int C = Integer.parseInt(br.readLine());
		
		String ABs = As + Bs;
		int AB = Integer.parseInt(ABs);
		
		System.out.println(A + B - C);
		System.out.println(AB - C);
	}
}