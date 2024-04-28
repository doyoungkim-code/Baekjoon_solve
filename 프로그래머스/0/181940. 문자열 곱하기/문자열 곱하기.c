#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string, int k) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int len = strlen(my_string);
    char* answer = (char*)malloc(len * k + 1);
    int i = 0;
    int j = 0;
    while (i < k)
    {
        j = 0;
        while (j < len)
        {
            answer[i * len + j] = my_string[j];
            j ++;
        }
        i ++;
    }
    return answer;
}