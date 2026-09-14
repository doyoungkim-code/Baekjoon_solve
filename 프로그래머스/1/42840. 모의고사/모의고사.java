public class Solution {
    public static int[] a = {1, 2, 3, 4, 5};
    public static int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
    public static int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static int[] solution(int[] answers) {
        int[] ret = {};
        int[] res = new int[3];

        for (int i = 0; i < answers.length; ++i)
        {
            if (answers[i] == a[i % 5])
                res[0] ++;
            if (answers[i] == b[i % 8])
                res[1] ++;
            if (answers[i] == c[i % 10])
                res[2] ++;
        }

        if (res[0] > res[1] && res[0] > res[2])
            ret = new int[]{1};
        else if (res[1] > res[0] && res[1] > res[2])
            ret = new int[]{2};
        else if (res[2] > res[0] && res[2] > res[1])
            ret = new int[]{3};
        else if (res[0] == res[1] && res[0] > res[2])
            ret = new int[]{1, 2};
        else if (res[0] == res[2] && res[0] > res[1])
            ret = new int[]{1, 3};
        else if (res[1] == res[2] && res[1] > res[0])
            ret = new int[]{2, 3};
        else
            ret = new int[]{1, 2, 3};

        return ret;
    }
}