#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n, int k) {
    int answer = 0;
    int service = n / 10;
    return (n * 12000 + k * 2000 - service * 2000);
}