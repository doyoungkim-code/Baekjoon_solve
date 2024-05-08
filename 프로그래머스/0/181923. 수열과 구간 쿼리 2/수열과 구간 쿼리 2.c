#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// arr_len은 배열 arr의 길이입니다.
// queries_rows는 2차원 배열 queries의 행 길이, queries_cols는 2차원 배열 queries의 열 길이입니다.
int* solution(int arr[], size_t arr_len, int** queries, size_t queries_rows, size_t queries_cols) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int) * queries_rows);
    int i = 0;
    int k = 0;
    int min = 0;
    while (i < queries_rows)
    {
        k = queries[i][0];
        min = 1000001;
        while (k <= queries[i][1])
        {
            if (queries[i][0] <= k && k <= queries[i][1])
            {
                if (queries[i][2] < arr[k] && arr[k] <= min)
                    min = arr[k];
            }
            k ++;
        }
        if (min > 1000000)
            min = -1;
        answer[i] = min;
        i ++;
    }
    return answer;
}