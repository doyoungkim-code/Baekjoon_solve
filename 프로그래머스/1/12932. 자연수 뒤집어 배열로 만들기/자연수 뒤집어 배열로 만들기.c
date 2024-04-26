#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int zarisu(long long n){
    int i;
    
    i = 0;
    while (n > 0)
    {
        n = n / 10;
        i ++;
    }
    return (i);
}

int* solution(long long n) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    int z = zarisu(n);
    int* answer = (int*)malloc(sizeof(int) * z);
    int i = 0;
    
    while (i < z)
    {
        answer[i] = n % 10;
        n = n / 10;
        i ++;
    }
    return answer;
}