#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int n, int k) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int) * n);
    int i = 1;
    int s = 0;
    while (i < n + 1)
    {
        if (i % k == 0)
        {
            answer[s] = i;
            s ++;
        }
        i ++;
    }
    return answer;
}