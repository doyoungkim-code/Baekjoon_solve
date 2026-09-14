class Solution {
    public int[] solution(int money) {
        int[] answer = {0, 0};
        
        while (money >= 5500)
        {
            answer[0] ++;
            money = money - 5500;
        }
        
        answer[1] = money;
        return answer;
    }
}