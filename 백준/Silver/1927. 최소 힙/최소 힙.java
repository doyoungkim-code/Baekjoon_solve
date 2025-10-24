import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
	
	static class Num implements Comparable<Num>{
		int val;
		
		public Num(int val) {
			super();
			this.val = val;
		}
		@Override
		public int compareTo(Num o) {
			// TODO Auto-generated method stub
			return (Integer.compare(this.val, o.val));
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Num> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; ++i)
		{
			int input = Integer.parseInt(br.readLine());
			
			if (input != 0)
			{
				pq.add(new Num(input));
			}
			else
			{
				if (pq.isEmpty())
					System.out.println("0");
				else
					System.out.println(pq.poll().val);
			}
		}
	}
}