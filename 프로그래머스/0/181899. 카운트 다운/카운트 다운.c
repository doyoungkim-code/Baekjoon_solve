#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int start, int end_num) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int) *(start - end_num + 1));
    int i = 0;
    while (i < start - end_num + 1)
    {
        answer[i] = start - i;
        i ++;
    }
    return answer;
}