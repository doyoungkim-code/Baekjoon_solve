#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

char* solution(int num) {
    char *answer;
    if (num % 2 == 0)
    {
        answer = strdup("Even");
    }
    else
    {
        answer = strdup("Odd");
    }
    return answer;
}