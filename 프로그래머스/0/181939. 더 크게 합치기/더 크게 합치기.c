#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int zarisu(int n)
{
    int result = 1;
    while (n >= 10)
    {
        n = n / 10;
        result++;
    }
    return (result);
}

int answers(int n1, int n2)
{
    int i = 0;
    while (i < zarisu(n2))
    {
        n1 = n1 * 10;
        i ++;
    }
    return (n1 + n2);
}

int solution(int a, int b) {
    int an1 = answers(a, b);
    int an2 = answers(b, a);
    if (an1 >= an2)
        return (an1);
    else if (an1 < an2)
        return (an2);
}