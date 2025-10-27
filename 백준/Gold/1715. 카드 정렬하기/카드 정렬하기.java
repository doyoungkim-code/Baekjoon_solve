import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    
	static class Data implements Comparable<Data>{
		int num;

		public Data(int num) {
			super();
			this.num = num;
		}

		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return (Integer.compare(this.num, o.num));
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Data> pq = new PriorityQueue<>();
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; ++i)
        {
        	int input = Integer.parseInt(br.readLine());
        	pq.add(new Data(input));
        }
        
        int sum = 0;
        while(pq.size() > 1)
        {
        	int plus = 0;
        	
        	plus += pq.poll().num;
        	plus += pq.poll().num;
        	sum += plus;
        	
        	pq.add(new Data(plus));
        }
        
        System.out.println(sum);
    }
}