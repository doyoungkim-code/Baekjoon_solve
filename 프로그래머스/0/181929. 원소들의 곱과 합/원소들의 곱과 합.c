#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// num_list_len은 배열 num_list의 길이입니다.
int solution(int num_list[], size_t num_list_len) {
    int i = 0;
    int gob = 1;
    int hab = 0;
    while (i < num_list_len)
    {
        gob = gob * num_list[i];
        hab = hab + num_list[i];
        i ++;
    }
    if (gob < hab * hab)
        return (1);
    else
        return (0);
}