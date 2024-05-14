#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* number) {
    int answer = 0;
    int i = 0;
    int sum = 0;
    while (number[i] != '\0')
    {
        sum = sum + (number[i] - '0');
        i++;
    }
    answer = sum % 9;
    return answer;
}