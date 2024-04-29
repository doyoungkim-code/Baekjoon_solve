#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int number, int n, int m) {
    int answer = 0;
    if (number % n == 0 && number % m == 0)
        return (1);
    else
        return (0);
    return answer;
}