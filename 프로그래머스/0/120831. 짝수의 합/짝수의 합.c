#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int i = 0;
    while (i <= n)
    {
        if (i % 2 == 0)
            answer = answer + i;
        i ++;
    }
    return answer;
}