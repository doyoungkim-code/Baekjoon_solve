#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(int n, const char* control) {
    int answer = 0;
    int i = 0;
    while (control[i] != '\0')
    {
        if (control[i] == 'w')
            n = n + 1;
        else if (control[i] == 's')
            n = n - 1;
        else if (control[i] == 'd')
            n = n + 10;
        else if (control[i] == 'a')
            n = n - 10;
        i ++;
    }
    answer = n;
    return answer;
}