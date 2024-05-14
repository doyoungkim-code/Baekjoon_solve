#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// index_list_len은 배열 index_list의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string, int index_list[], size_t index_list_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc((index_list_len + 1));
    int i = 0;
    while (i < index_list_len)
    {
        answer[i] = my_string[index_list[i]];
        i ++;
    }
    answer[i] = '\0';
    return answer;
}