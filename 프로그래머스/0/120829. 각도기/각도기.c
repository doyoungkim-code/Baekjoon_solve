#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int angle) {
    if (0 < angle && angle < 90)
        return (1);
    else if (angle == 90)
        return (2);
    else if (90 < angle && angle < 180)
        return (3);
    else if (angle == 180)
        return (4);
    return (0);
}