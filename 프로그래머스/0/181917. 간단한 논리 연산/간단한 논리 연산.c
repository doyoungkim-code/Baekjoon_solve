#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool solution(bool x1, bool x2, bool x3, bool x4) {
    bool answer = true;
    bool x5 = true;
    bool x6 = true;
    if (x1 || x2)
        x5 = true;
    else
        x5 = false;
    if (x3 || x4)
        x6 = true;
    else
        x6 = false;
    if (x5 && x6)
        answer = true;
    else
        answer = false;
    return answer;
}