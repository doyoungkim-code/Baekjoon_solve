
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static class Task{
        int len;
        int profit;
        
        public Task(int len, int profit) {
            super();
            this.len = len;
            this.profit = profit;
        }
    }
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List <Task> taskList = new ArrayList<>();
        
        for (int i = 0; i < N; ++i)
        {
            st  = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            taskList.add(new Task(l, p));
        }
        
        int dp[] = new int[N + 1];
        int maxProfit = 0;
        
        for (int i = 0; i < N; ++i)
        {
        	maxProfit = Math.max(maxProfit, dp[i]);
        	int len = taskList.get(i).len;
            int profit = taskList.get(i).profit;
            int nextDay = i + len;
           
        	if (nextDay <= N)
        	{
        		dp[nextDay] = Math.max(dp[nextDay], maxProfit + profit);
        	}
        }
        System.out.println(Math.max(maxProfit, dp[N]));
    }
}
