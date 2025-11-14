import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Date implements Comparable<Date>{
		int start;
		int end;
		
		public Date(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Date o) {
			if (this.end == o.end)
				return (Integer.compare(this.start, o.start));
			return (Integer.compare(this.end, o.end));
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		PriorityQueue<Date> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; ++i)
		{
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			pq.add(new Date(a, b));
		}
		
		int count = 0;
		int day = -1;
		for (int i = 0; i < n; ++i)
		{
			Date d = pq.poll();
			if (day > d.start)
				continue;
			
			day = d.end;
			count ++;
		}
		
		System.out.println(count);
	} 
}
