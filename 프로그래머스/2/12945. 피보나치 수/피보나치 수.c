#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n)
{
    int num = 0;
    int i, j, k;
    i = 1;
    j= 1;
    k = 0;
    while (num + 1 < n)
    {
        i = (j + k) % 1234567;
        k = j;
        j = i;
        num++;
    }
    return (i);
}