#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* s) {
    int answer = 0;
    int minus = 0;
    int i = 0;
    while (s[i] != '\0')
    {
        if (s[0] == '-' && minus == 0)
        {
            minus = -1;
            i ++;
        }
        else if (s[0] == '+' && minus == 0)
        {
            minus = 1;
            i ++;
        }
        answer = 10 * answer + (s[i] - '0');
        i ++;
    }
    if (minus == 0)
        minus = 1;
    return (minus * answer);
}