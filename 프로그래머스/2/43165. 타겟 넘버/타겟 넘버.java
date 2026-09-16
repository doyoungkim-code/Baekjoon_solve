class Solution {
    
    public int[] nums;
    public int tar;
    
    public int dfs(int depth, int res){
        if (depth == nums.length)
        {
            if (res == tar)
                return (1);
            else
                return (0);
        }
        
        return (dfs(depth + 1, res + nums[depth]) + dfs(depth + 1, res - nums[depth]));
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        nums = numbers;
        tar = target;
        
        answer = dfs(0, 0);
        return answer;
    }
}