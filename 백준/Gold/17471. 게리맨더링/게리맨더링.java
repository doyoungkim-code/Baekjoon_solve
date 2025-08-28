import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	
    static int N;
    static List<List<Integer>> city;
    static List<List<Integer>> linkedCity;
    static int[] population;
    static int min = 2147483647;
    
    static boolean bfs(List<Integer> lst)
    {
    	int cnt = 0;
    	boolean[] visited = new boolean[N + 1];
    	ArrayDeque <Integer> dq = new ArrayDeque<>();
    	
    	dq.add(lst.get(0));
    	visited[lst.get(0)] = true;
    	cnt ++;
    	
    	while (!dq.isEmpty())
    	{
    		int pollData = dq.poll();
    		
    		for (int i : linkedCity.get(pollData))
    		{
    			if (!visited[i] && lst.contains(i))
    			{
    				visited[i] = true;
    				dq.add(i);
    				cnt ++;
    			}
    		}
    	}
    	
    	if (cnt == lst.size())
    		return true;
    	else
    		return false;
    }
    
    static void comb(int start, List<Integer> result)
    {
        if (!result.isEmpty() && result.size() != N)
        {
            city.add(new ArrayList<>(result));
        }
        
        for (int i = start; i <= N; ++i)
        {
            result.add(i);
            comb(i + 1, result);
            result.remove(result.size() - 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        city = new ArrayList<>();
        population = new int[N + 1];
        linkedCity = new ArrayList<>();
        for (int i = 0; i <= N; ++i)
        {
        	linkedCity.add(new ArrayList<>());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i)
        {
        	population[i] = Integer.parseInt(st.nextToken());
        	// population 배열에 도시별 각 인구수 저장
        }
        
        for (int i = 1; i <= N; ++i)
        {
        	st = new StringTokenizer(br.readLine());
	        int numLink = Integer.parseInt(st.nextToken());
	        for (int j = 0; j < numLink; ++j)
	        {
	        	int link = Integer.parseInt(st.nextToken());
	        	linkedCity.get(i).add(link);
	        	// linkedCity 리스트에 각 도시별 연결된 도시들을 저장
	        }
        }
        
        comb(1, new ArrayList<>());
        // city 리스트에 가능한 조합들을 모두 저장
        
        for (List<Integer> groupA : city)
        {
        	int sumA = 0;
        	int sumB = 0;
        	List<Integer> groupB = new ArrayList<>();
        	boolean[] isGroupA = new boolean[N + 1];
        	
        	for (int groupNum : groupA)
        	{
        		isGroupA[groupNum] = true;
        		sumA += population[groupNum];
        	}
        	
        	for (int i = 1; i <= N; ++i)
        	{
        		if(!isGroupA[i]) {
        			groupB.add(i);
        			sumB += population[i];
        		}
        	}
        	
        	if (bfs(groupA) && bfs(groupB))
        	{
        		int diff = Math.abs(sumA - sumB);
        		if (min > diff)
        			min = diff;
        	}
        }
        if (min == 2147483647)
        	System.out.println(-1);
        else
        	System.out.println(min);
    }
}