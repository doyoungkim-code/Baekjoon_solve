#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// numbers_len은 배열 numbers의 길이입니다.
double solution(int numbers[], size_t numbers_len) {
    double answer = 0;
    int i = 0;
    int sum = 0;
    while (i < numbers_len)
    {
        sum = sum + numbers[i];
        i ++;
    }
    answer = (double)sum / (double)numbers_len;
    return answer;
}