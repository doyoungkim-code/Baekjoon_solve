import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayDeque<Character> dq = new ArrayDeque<>();
		
		String str = br.readLine();
		
		int len = str.length();

		for (int i = 0; i < len; ++i)
		{
			if (str.charAt(i) == 'K' && (dq.isEmpty() || dq.peekLast() == 'A'))
				dq.add('K');
			else if (str.charAt(i) == 'O' && (!dq.isEmpty() && dq.peekLast() == 'K'))
				dq.add('O');
			else if (str.charAt(i) == 'R' && (!dq.isEmpty() && dq.peekLast() == 'O'))
				dq.add('R');
			else if (str.charAt(i) == 'E' && (!dq.isEmpty() && dq.peekLast() == 'R'))
				dq.add('E');
			else if (str.charAt(i) == 'A' && (!dq.isEmpty() && dq.peekLast() == 'E'))
				dq.add('A');
		}
		
		System.out.println(dq.size());
	}
}
