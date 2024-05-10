#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int l, int r) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int n, na;
    int k = 0;
    int z = 0;
    int i;
    int* answer = (int*)malloc(1000);
    while (k < 64)
    {
        n = k;
        i = 10;
        na = 0;
        while (n > 0)
        {
            na = na + (i) * (n % 2);
            n = n / 2;
            i = i * 10;
        }
        na = (na / 10) * 5;
        if (l <= na && na <= r)
        {
            answer[z] = na;
            z ++;
        }
        k ++;
    }
    if (z == 0)
        answer[0] = -1;
    return answer;
}