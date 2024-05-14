#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>

int solution(int a, int b, int c, int d) {
    int nums[6] = {0, 0, 0, 0, 0, 0};
    int result = 0;
    int i = 0;
    int j = 0;
    int p = 0;
    int min = 0;

    nums[a - 1] ++;
    nums[b - 1] ++;
    nums[c - 1] ++;
    nums[d - 1] ++;
    while (i < 6)
    {
        if (nums[i] == 4)
        {
            result = 1111 * (i + 1);
            break;
        }
        if (nums[i] == 3)
        {
            while (j < 6)
            {
                if (nums[j] == 1)
                    break;
                j ++;
            }
            result = (10 * (i + 1) + (j + 1)) * (10 * (i + 1) + (j + 1));
            break;
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
            result = ((i + 1) + (j + 1)) * abs(i - j);
            break;
        }
        i ++;
    }
    if (result == 0)
    {
        i = 0;
        while (i < 6)
        {
            if(nums[i] == 1)
            {
                result = i + 1;
                break;
            }
            i ++;
        }
    }
    return (result);
}