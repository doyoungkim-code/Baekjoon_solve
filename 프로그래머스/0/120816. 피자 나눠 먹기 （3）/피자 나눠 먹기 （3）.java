
class Solution {
    public int solution(int slice, int n) {
        int num = 1;

        while (num * slice < n)
        {
            num++;
        }

        return num;
    }
}