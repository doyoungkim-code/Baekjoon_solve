#include <stdio.h>
#define LEN_INPUT 10

int main(void) {
    char s1[LEN_INPUT];
    scanf("%s", s1);
    int i = 0;
    
    while(s1[i] != '\0')
    {
        if(s1[i] <= 'Z')
        {
            s1[i] = s1[i] + 32;
        }
        else if(s1[i] >= 'a')
        {
            s1[i] = s1[i] - 32;
        }
        printf("%c", s1[i]);
        i ++;
    }
    return 0;
}
