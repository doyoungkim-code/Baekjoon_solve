#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// included_len은 배열 included의 길이입니다.
int solution(int a, int d, bool included[], size_t included_len) {
    int answer = 0;
    int i = 0;
    while (i < included_len)
    {
        answer = answer + included[i] * (a + d * i);
        i ++;
    }
    return answer;
}