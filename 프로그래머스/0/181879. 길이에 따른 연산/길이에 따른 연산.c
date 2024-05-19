#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// num_list_len은 배열 num_list의 길이입니다.
int solution(int num_list[], size_t num_list_len) {
    int answer = 0;
    int i = 0;
    if (num_list_len >= 11)
    {
        while(i < num_list_len)
        {
            answer = answer + num_list[i];
            i ++;
        }
    }
    else
    {
        answer = 1;
        while(i < num_list_len)
        {
            answer = answer * num_list[i];
            i ++;
        }
    }
    return answer;
}