#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int i = 0;
    if (n % 2 == 1)
    {
        i = 1;
        while (i <= n)
        {
            answer = answer + i;
            i = i + 2;
        }
    }
    else
    {
        i = 0;
        while (i <= n)
        {
            answer = answer + (i * i);
            i = i + 2;
        }
    }
    return answer;
}