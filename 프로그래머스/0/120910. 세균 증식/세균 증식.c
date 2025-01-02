#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n, int t) {
    int answer = n;
    for(int i = 0; i < t; i ++)
    {
        answer = answer * 2;
    }
    return answer;
}