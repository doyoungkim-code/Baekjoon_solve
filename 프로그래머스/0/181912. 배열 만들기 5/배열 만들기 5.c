#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// intStrs_len은 배열 intStrs의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int* solution(const char* intStrs[], size_t intStrs_len, int k, int s, int l) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int) * intStrs_len);
    int num = 0;
    size_t i = 0;
    int z = 0;
    int n = 0;
    while(i < intStrs_len)
    {
        z = 0;
        num = 0;
        while (z < l)
        {
            num = num * 10 + intStrs[i][s + z] - '0';
            z ++;
        }
        if (num > k)
        {
            answer[n] = num;
            n ++;
        }
        i ++;
    }
    return answer;
}