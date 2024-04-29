#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* s) {
    int num = 0;
    int i = 0;
    int j = 0;
    int a_count = 0;
    int b_count = 0;
    while (s[i] != '\0')
    {
        if (s[i] == s[j])
        {
            a_count++;
        }
        else
            b_count++;
        i ++;
        if (a_count == b_count)
        {
            num++;
            j = i;
        }
    }
    if (a_count != b_count)
        num ++;
    return num;
}