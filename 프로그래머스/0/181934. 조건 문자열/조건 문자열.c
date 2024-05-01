#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* ineq, const char* eq, int n, int m) {
    if(ineq[0] == '<')
    {
        if(eq[0] == '=')
            return (n <= m ? 1 : 0);
        else if(eq[0] == '!')
            return (n < m ? 1 : 0);
    }
    else if(ineq[0] == '>')
    {
        if(eq[0] == '=')
            return (n >= m ? 1 : 0);
        else if(eq[0] == '!')
            return (n > m ? 1 : 0);
    }
}