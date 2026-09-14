class Solution {

    public int solution(int[][] sizes) {
        int aMax = 0;
        int bMax = 0;

        for (int i = 0; i < sizes.length; i++)
        {
            if (sizes[i][0] > sizes[i][1])
            {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            if (sizes[i][0] > aMax)
                aMax = sizes[i][0];
            if (sizes[i][1] > bMax)
                bMax = sizes[i][1];
        }

        return (aMax * bMax);
    }
}