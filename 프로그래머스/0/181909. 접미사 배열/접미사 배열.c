#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char** solution(const char* my_string) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int len_str = strlen(my_string);
    int i = 0;
    int j = 0;
    int result = 0;
    char *temp;
    char** answer = (char**)malloc(sizeof(char*) * (len_str + 1));
    while (i < len_str)
    {
        answer[i] = (char*)malloc(sizeof(char) * (len_str + 1));
        i ++;
    }
    i = 0;
    while(i < len_str)
    {
        j = 0;
        while (j < i + 1)
        {
            answer[i][j] = my_string[len_str - i + j - 1];
            j ++;
        }
        answer[i][j] = '\0';
        i++;
    }
    i = 0;
    while (i < len_str - 1)
    {
        j = i + 1;
        while (j < len_str)
        {
            result = strcmp(answer[i], answer[j]);
            if (result > 0)
            {
                temp = answer[i];
                answer[i] = answer[j];
                answer[j] = temp;
            }
            j ++;
        }
        i ++;       
    }
    return answer;
}