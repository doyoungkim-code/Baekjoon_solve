#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>

int solution(int a, int b, int c, int d) {
    int nums[6] = {0, 0, 0, 0, 0, 0};
    int i = 0, j = 0, p = 0, min = 0;

    nums[a - 1] ++;
    nums[b - 1] ++;
    nums[c - 1] ++;
    nums[d - 1] ++;
    while (i < 6)
    {
        if (nums[i] == 4)
            return(1111 * (i + 1));
        if (nums[i] == 3)
        {
            while (j < 6)
            {
                if (nums[j] == 1)
                    break;
                j ++;
            }
            return((10 * (i + 1) + (j + 1)) * (10 * (i + 1) + (j + 1)));
        }
        if (nums[i] == 2)
        {
            while (j < 6)
            {
                if (nums[j] == 2 && j != i)
                    break;
                else if (nums[j] == 1 && p == 0)
                    p = j + 1;
                else if (nums[j] == 1 && p != 0)
                    return (p * (j + 1));
                j ++;
            }
            return(((i + 1) + (j + 1)) * abs(i - j));
        }
        i ++;
    }
    i = 0;
    while (i < 6)
    {
        if(nums[i] == 1)
            return (i + 1);
        i ++;
    }
    return (0);
}
