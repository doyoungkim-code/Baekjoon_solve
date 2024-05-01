#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* code) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int i = 0;
    int j = 0;
    int mode = 0;
    char* answer = (char*)malloc(strlen(code));
    while(code[i] != '\0')
    {
        if(mode == 0)
        {   
            if(code[i] != '1')
            {
                if(i%2 == 0)
                {
                    answer[j] = code[i];
                    j ++;
                }
            }
            else
                mode = 1;
        }
        else if(mode == 1)
        {   
            if(code[i] != '1')
            {
                if(i%2 == 1)
                {
                    answer[j] = code[i];
                    j ++;
                }
            }
            else
                mode = 0;
        }
        i ++;
    }
    answer[j] = '\0';
    if (answer[0] == '\0')
        return ("EMPTY");
    return answer;
}