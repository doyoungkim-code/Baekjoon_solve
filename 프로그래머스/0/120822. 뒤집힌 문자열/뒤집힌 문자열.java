import java.io.*;
import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int len = my_string.length();
        
        for (int i = 0; i < len; i++)
        {
            sb.append(my_string.charAt(len - i - 1));
        }
        answer = sb.toString();
        return answer;
    }
}