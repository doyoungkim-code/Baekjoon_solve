#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h> 

// queries_rows는 2차원 배열 queries의 행 길이, queries_cols는 2차원 배열 queries의 열 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string, int** queries, size_t queries_rows, size_t queries_cols) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int i = 0, j = 0, z = 0, temp = 0, k = 0;
    int len = strlen(my_string);
    char* answer = (char*)malloc(len + 1);
    strcpy(answer, my_string);
    while (i < queries_rows)
    {
        j = queries[i][0];
        k = queries[i][1];
        z = 0;
        while (j < k - z)
        {
            temp = answer[j];
            answer[j] = answer[k - z];
            answer[k - z] = temp;
            j ++;
            z ++;
        }
        i ++;
    }
    answer[len] = '\0';
    return answer;
}