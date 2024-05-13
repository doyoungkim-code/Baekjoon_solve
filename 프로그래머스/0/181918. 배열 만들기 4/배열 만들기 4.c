#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// arr_len은 배열 arr의 길이입니다.
int* solution(int arr[], size_t arr_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* stk = (int*)calloc(sizeof(int), arr_len);
    int i = 0;
    int j = 0;
    int flag = 1;
    while (i < arr_len)
    {
        if(flag == 1)
        {
            stk[j] = arr[i];
            flag = 0;
        }
        else
        {
            if (stk[j] < arr[i])
            {
                stk[j + 1] = arr[i];
                j ++;
            }
            else
            {
                stk[j] = arr[i];
                j --;
                i --;
            }
        }
        i ++;
    }
    return stk;
}