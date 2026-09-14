import java.io.*;
import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        
        for (int i = 0; i < my_string.length(); i++)
        {
            for (int j = 0; j < n; j++)
            {
                sb.append(my_string.charAt(i));
            }
        }
        
        answer = sb.toString();
        return answer;
    }
}