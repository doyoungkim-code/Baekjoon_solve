class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;
        
        for (int i = 0; i < num_list.length; i++)
        {
            if (num_list[i] % 2 == 0)
            {
                answer[0] ++;
            }
            else
            {
                answer[1] ++;
            }
        }
        return answer;
    }
}