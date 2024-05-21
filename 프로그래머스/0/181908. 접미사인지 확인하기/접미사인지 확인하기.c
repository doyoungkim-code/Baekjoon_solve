#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* my_string, const char* is_suffix) {
    int answer = 0;
    int i = 0;
    int suffix_len = strlen(is_suffix);
    int my_string_len = strlen(my_string);
    while(my_string_len - suffix_len + i < my_string_len)
    {
        if(my_string[my_string_len - suffix_len + i] != is_suffix[i])
            return (0);
        i ++;
    }
    return (1);
}