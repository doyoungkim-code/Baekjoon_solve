#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// A_len은 배열 A의 길이입니다.
// B_len은 배열 B의 길이입니다.

// void sorting(int *list[], size_t len)
// {
//     int temp = 0;
//     int i = 0;
//     int j = 0;
//     while(i < len)
//     {
//         j = i + 1;
//         while (j < len)
//         {
//             if ((*list)[i] > (*list)[j])
//             {
//                 temp = (*list)[j];
//                 (*list)[j] = (*list)[i];
//                 (*list)[i] = temp;
//             }
//             j ++;   
//         }
//         i ++;
//     }
// }
int compare(const void *a, const void *b)
{
    return (*(int*)a - *(int*)b);
}

int solution(int A[], size_t A_len, int B[], size_t B_len) {
    int answer = 0;
    int i = 0;
    qsort(A, A_len, sizeof(int), compare);
    qsort(B, B_len, sizeof(int), compare);
    while (i < A_len)
    {
        answer = answer + (A[i] * B[A_len - i - 1]);
        i++;
    }
    return answer;
}