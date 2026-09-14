import java.io.*;
import java.util.*;

public class Solution {

    public Set<Integer> s;
    public int[] arr;
    public boolean[] visited;
    public int[] result;

    public boolean isPrime(int n)
    {
        if (n == 0 || n == 1)
            return false;

        if (n == 2)
            return true;

        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public void perm(int depth, int r)
    {
        if (depth == r)
        {
            int res = result[0];
            for (int i = 1; i < depth; ++i)
            {
                res = res * 10 + result[i];
            }
            s.add(res);
            return;
        }

        for (int i = 0; i < arr.length; ++i)
        {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                perm(depth + 1, r);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers)
    {
        int answer = 0;
        int len = numbers.length();

        s = new HashSet<>();
        arr = new int[len];
        visited = new boolean[len];
        result = new int[len];

        for (int i = 0; i < len; ++i)
        {
            arr[i] = numbers.charAt(i) - '0';
        }

        for (int i = 1; i <= len; ++i)
        {
            perm(0, i);
        }

        for (int num : s) {
            if (isPrime(num)) answer ++;
        }
        return answer; 
    }
}