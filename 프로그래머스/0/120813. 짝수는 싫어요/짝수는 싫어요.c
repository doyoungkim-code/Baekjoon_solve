#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int n) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int) * (n / 2));
    int i = 0;
    int k = 0;
    while (i <= n)
    {
        if (i % 2 == 1)
        {
            answer[k] = i;
            k ++;
        }
        i ++;
    }
    return answer;
}